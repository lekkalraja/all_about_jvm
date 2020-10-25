# Tools to monitor JVM Garbage Collector
*   MXBeans
*   Monitoring GC
    *   Jstat
    *   VisualVM and Visual GC
  
# MXBeans

*   Running on Java - 11
    *   `javac GCMXBean.java`
    *   `java GCMXBean`
  
    ```
    Name : G1 Young Generation
    Number of Collections : 0
    Collection Time : 0 ms
    Pool Names : 
        G1 Eden Space   G1 Survivor Space       G1 Old Gen
    Name : G1 Old Generation
    Number of Collections : 0
    Collection Time : 0 ms
    Pool Names : 
        G1 Eden Space   G1 Survivor Space       G1 Old Gen
    ```

    * `java -XX:+UseConcMarkSweepGC GCMXBean`
    
    ```
    Java HotSpot(TM) 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
    
    Name : ParNew
    Number of Collections : 0
    Collection Time : 0 ms
    Pool Names : 
        Par Eden Space  Par Survivor Space
    Name : ConcurrentMarkSweep
    Number of Collections : 0
    Collection Time : 0 ms
    Pool Names : 
        Par Eden Space  Par Survivor Space      CMS Old Gen **
    ```