package collect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class Averager {
    private double sum = 0.0;
    private long count = 0;
    
    public void include(double d) {
        sum += d;
        count++;
    }
    
    public double getAverage() {
        return sum / count;
    }
    
    public void merge(Averager other) {
        System.out.println("Merging!!!");
        sum += other.sum;
        count += other.count;
    }
}
public class CollectAverage {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("Average is " 
                + Stream.generate(() -> ThreadLocalRandom.current().nextDouble(0, Math.PI * 2))
//                        .parallel()
//                        .sequential()
//                + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(100_000_000)
                .map(x -> Math.sin(x))
                .collect(Averager::new,
                        Averager::include,
                        Averager::merge)
//                .collect(() -> new Averager(),
//                        (a, x) -> a.include(x),
//                        (a, a1) -> a.merge(a1))
                .getAverage());
        long end = System.nanoTime();
        System.out.printf("Time is %,14.9f\n", (end - start)/ 1_000_000_000.0);
                
    }
}
