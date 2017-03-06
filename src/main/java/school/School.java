package school;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n->System.out.println(n));
        
        List<Student> school = Arrays.asList(
                new Student("Fred", 2.7F, "Art", "History", "Journalism"),
                new Student("Jim", 3.7F, "Math", "Physics"),
                new Student("Sheila", 3.9F, "Engineering", "Tribology", "Statistics", "Astronomy")
        );

        school.stream()
                .map(s -> s.getName())
                .forEach(s -> System.out.println(s));

        System.out.println("------------------------------");
        Stream<Student> ss = school.stream();
        Stream<String> sName = ss.map(s -> {return s.getName();});
        sName.forEach(s -> System.out.println(s));

//        System.out.println("------------------------------");
//        STREAMS RUN ONCE ONLY! Make a new one if you need to
//        ss.forEach(s -> System.out.println(s));

        System.out.println("------------------------------");
        school.stream()
                .flatMap(s->s.getCourses().stream())
                .forEach(s->System.out.println(s));

        System.out.println("------------------------------");
        System.out.println("Stats: " + school.stream()
                .mapToDouble(s->s.getGpa())
//                .peek(s->System.out.println("Looking at " + s + " which is " + s.getClass().getName()))
                .summaryStatistics());

        System.out.println("------------------------------");
        List<String> courses = school.stream()
                .flatMap(s->s.getCourses().stream())
                .collect(Collectors.toList());
        
        System.out.println("All courses: " + courses);
    }
}
