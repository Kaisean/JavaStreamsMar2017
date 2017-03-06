package simplereduce;

import java.util.stream.Stream;

public class AddUp {
    public static void main(String[] args) {
        Stream.iterate(1, x->x+1)
                .limit(10)
                .reduce((a,b)->a+b)
                .ifPresent(x->System.out.println("Sum is " + x));

        System.out.println("Sum is "  
                + Stream.iterate(1, x->x+1)
                .limit(10)
                .reduce(0, (a,b)->a+b));
    }
}
