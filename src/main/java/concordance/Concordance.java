package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
    public static final Pattern WORD_BOUNDARY = Pattern.compile("\\W+");
    public static final Comparator<Map.Entry<String, Long>> byValue = Map.Entry.comparingByValue();
    public static final Comparator<Map.Entry<String, Long>> byValueReversed = byValue.reversed();
    
    public static void main(String[] args) throws Throwable {
        try (Stream<String> input = 
                Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
            input
                    .map(String::toLowerCase)
//                    .map(s->s.toLowerCase())
                    .flatMap(WORD_BOUNDARY::splitAsStream)
//                    .flatMap(s->WORD_BOUNDARY.splitAsStream(s))
                    .filter(s->s.length() > 0)
                    .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.counting()))
                    .entrySet().stream()
//                    .sorted(byValueReversed)
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(200)
                    .forEachOrdered(e->System.out.printf(
                            "%20s : %6d\n", e.getKey(), e.getValue()));
                    ;
        }
    }
}
