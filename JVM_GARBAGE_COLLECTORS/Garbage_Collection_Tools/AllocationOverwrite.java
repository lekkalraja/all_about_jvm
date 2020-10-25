import java.util.Random;

public class AllocationOverwrite {

    public static void main(String... args) throws Exception {

        int arraySize = 1000000;
        GCMe[] gcmes = new GCMe[arraySize];

        int count = 0;
        Random rnd = new Random();
        while (true) {
            gcmes[rnd.nextInt(arraySize)] = new GCMe();
            if (count % 1000000 == 0) {
                System.out.print(".");
                Thread.sleep(1);
            }
            count++;
        }
    }
}

class GCMe {
    long a;
    long aa;
    long aaa;
    long aaaa;
    long aaaaa;
    long aaaaaa;
    long aaaaaaa;
    long aaaaaaaa;
    long aaaaaaaaa;
    long aaaaaaaaaa;
    long aaaaaaaaaaa;
    long aaaaaaaaaaaa;
    long aaaaaaaaaaaaa;
    long aaaaaaaaaaaaaa;
}

