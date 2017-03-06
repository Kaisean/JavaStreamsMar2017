package collect;

import java.util.stream.Stream;

public class TextCollector {
    public static void main(String[] args) {
    StringBuilder sentence = 
            Stream.of("Hello", "world", "it", "is", "cold")
                .collect(()->new StringBuilder(),
                        (sb, s) -> sb.append(s).append(" "),
                        (sb, sb2) -> sb.append(sb2));
        System.out.println("Sentence is " + sentence);
    }
        
}
