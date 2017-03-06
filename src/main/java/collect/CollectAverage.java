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
        sum += other.sum;
        count += other.count;
    }
}
public class CollectAverage {
    public static void main(String[] args) {
        System.out.println("Average is " 
//                + Stream.generate(() -> ThreadLocalRandom.current().nextDouble(-1.0, 1.0))
                + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(10_000_000)
                .collect(Averager::new,
                        Averager::include,
                        Averager::merge)
//                .collect(() -> new Averager(),
//                        (a, x) -> a.include(x),
//                        (a, a1) -> a.merge(a1))
                .getAverage());
    }
}
