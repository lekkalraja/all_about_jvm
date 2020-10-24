# Agenda
    * Understanding JVM Memory Management
    * Understanding Various aspects of Garbage Collection
        * How GC Works
        * Interaction With Garbage Collection
## Why GC ?
   * To Avoid Memory Leaks
   * create and forget: No need to remember to delete
     ` Employee emp = new Employee`
   * use and forget : no need to ask "Should i delete" (neither provider nor receiver)
      ` Employee emp = getEmployee()`
   * use with confidence: Objects will not vanish or become corrupt behind your back
      ` emp.incSalary(amount)`
   
   * Garbage collector promises that it will never claim live objects but no promises about dead objects

    
   
# Note:
    * Used Java-11 for Demo's
    * Things changed in Java 7
      * G1 garbage collector introduced
    * Things changed in Java 9
      * CMS garbage collector deprecated
      * Finalizers deprecated
      * Cleaner introduced

# Types of Garbage Collector's
    * Do Nothing
    * Reference Counting
    * Mark and Sweep
    * Copying
    * Generational
    * Incremental


# Refernce Counting Garbage Collector:
   
   <img src="images/reference_counting_gc.png" center="ture" width="1500">

    ## Onus on client to call methods when allocating/freeing memory
      * COM for example had AddRef and Release calls for objects
      * When count hit's zero, object can be freed
      * Problems with circular references

# Mark And Sweep Garbage Collector:

  * Mark Phase that identifies the objects that are still in use (Rootset -> Stack (Per Thread))
    <img src="images/Mark_Phase.png" center="ture" width="1500">
    
  * Sweep Phase to remove unused objects
    
    <img src="images/Sweep_Phase.png" center="ture" width="1500">

  * Compact Phase to compact the memory (Physical memory will change internally)
  
    <img src="images/Compact_Phase.png" center="ture" width="1500">

# Copying Garbage Collector:

  * Uses different spaces to manage memory
  
    * Allocates memory in `fromspace` and may follow mark&sweep to identify dead objects
  
    <img src="images/Copying_GC_1.png" center="ture" width="1500">

    * Copy all the live objects from `fromspace to Tospace`

    <img src="images/Copying_GC_2.png" center="ture" width="1500">

    * Remove Dead objects from fromspace and allocate objects in freed-fromspace

    <img src="images/Copying_GC_3.png" center="ture" width="1500">