import java.lang.management.ManagementFactory;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;
import java.util.Arrays;

public class GCMXBean {

    public static void main(String... args) {
        List<GarbageCollectorMXBean> collectors = ManagementFactory.getGarbageCollectorMXBeans();
        collectors.forEach(collector -> {
            System.out.println("Name : "+ collector.getName());
            System.out.println("Number of Collections : "+ collector.getCollectionCount());
            System.out.println("Collection Time : "+ collector.getCollectionTime() +" ms");
            System.out.println("Pool Names : ");
            Arrays.asList(collector.getMemoryPoolNames()).forEach(pool -> System.out.print("\t" + pool));
            System.out.println();
        });
    }
    
}
