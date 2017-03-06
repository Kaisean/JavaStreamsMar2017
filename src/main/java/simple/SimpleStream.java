package simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//class StringLongerThanThree implements Predicate<String> {
//    @Override
//    public boolean test(String s) {
//        return s.length() > 3;
//    }
//}

public class SimpleStream {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Fred", "Jim", "Sheila");
        ls.stream()
//                .filter(new StringLongerThanThree())
                .filter(s->s.length() > 3)
                .filter(s->s.length() < 6)
                .forEach(s->System.out.println("> " + s));
    }
}
