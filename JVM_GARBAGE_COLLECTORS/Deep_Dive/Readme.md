# Things to consider
  - Stop the world events (Whole application will pause while collection happening)
  - Memory Fragmentation
  - Througput (How fast the gc getting completed)

# Basic Ideas
    - Has a 'Young Generation' and an 'Old Generation'
    - Most Initial Objects allocated in 'Eden Space'
    - Young Generation also has two 'Survivor Spaces'
    - Objects that survive a GC get moved to the survivor space
    - Only one survivor space in use at a time
    - Objects copied between survivor spaces
    - Old generation is where long lived objects(after multiple gc's) go to die
    - Permanent Generation is `META-SPACE` where class loading, static context and string constant pool's will be there... No Garbage Collection will take's place
    
<img src="images/Memory_players.png" center="ture" width="1500">

# Young Generation

*   Most Objects live for a very short time
    *   The 'turtle' theory of garbage collection
    *   i.e. you die young or live 'forever'

# Minor Garbage Collection

*   Objects will start allocating into Eden Space
  
    <img src="images/allocation.png" center="ture" width="1500">

    *  When GC runs, live objects are copied to 'newer' survivor space

    <img src="images/copy_new_survivor.png" center="ture" width="1500">

    *  Objects from 'older' survivor space also copied to 'newer' survivor space
    
    <img src="images/old_survivor_to_new_survivor.png" center="ture" width="1500">
    
    *  Survivor spaces are swapped
    *  New objects allocated into Eden

    <img src="images/free_space.png" center="ture" width="1500">

    ### Note: Numbers in the images represents number of garbage collections

# Major Garbage Collection

*   Triggered when the tenured/old space is full
    *   Collects old and young generations
    *   Although this is really a 'Full GC'
  
## Copying to Old Generation

* JVM will eventually promote live objects to old generation
  * After a certain number of garbage collects
  * If survivor space is full
  * If JVM has been told to alwasy create objects in old space
  
  **` java -XX:+AlwasyTenure ` flag to JVM**

    <img src="images/Promotion-1.png" center="ture" width="1500"> <br>

    <img src="images/Promotion-2.png" center="ture" width="1500"> <br>

### Allocating Objects to Old Space

*   Objects over a certain size will be allocated directly in old space
    *   No JVM option to force objects to old space
    *   Option ** `java -XX:PretenureSizeThreshold=<n>`**
    *   All objects larger than <n> bytes should be allocated directly in old space
    *   However if object size fits TLAB, JVM will allocate it in TLAB (Thread Local Allocation Buffer)

# Memory Allocation

*   Want memory allocation to be as quick as possible
    *   Can simply increment a pointer
    *   Young always uses this, old may use it
    *   However, have to be aware of multi-threading issues
    *   Java use Thread Local Allocation Buffers (TLABS)
    *   Each thread gets it's own buffer in the Eden space
    *   No locking required

# What Does Live Mean ?

* Live Roots :
  * From Stack frames (Root Set)
  * Static Variables (Metaspace/permanent Gen)
  * Others such as JNI (Java Native Interface) and synchronization 'monitors'
  * References from live rooted objects are followed to other objects

### What about references from old Generation to Young ?

<img src="images/references_from_old_to_young.png" center="ture" width="1500"> <br>

*   This is an issue -> Young GC has to scan 'old' space
*   Sort of defeats the purpose
*   Introduced **CardTable**
  
# CardTable

* Each write to a reference to a young object from old space goes through a write barrier
* This write barrier updates a card table entry
* One entry per 512 bytes of memory
* Minor GC scans CardTable looking for the areas that contain references instead of looking whole old space
* Load that memory and follow the reference

<img src="images/cardTable.png" center="ture" width="1500"> <br>

<img src="images/cardtable-1.png" center="ture" width="1500"> <br>