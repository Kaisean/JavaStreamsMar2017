package school;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Grading {
    public static String grade(Student s) {
        float grade = s.getGpa();
        if (grade > 3.8F) return "A";
        if (grade > 3.6F) return "B";
        if (grade > 3.0F) return "C";
        if (grade > 2.5F) return "D";
        return "E";
    }
    
    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                new Student("Fred", 2.7F, "Art", "History", "Journalism"),
                new Student("Alice", 3.3F, "Journalism", "Literature"),
                new Student("Freda", 3.8F, "Art", "Art History", "Ceramics"),
                new Student("Wendy", 3.2F, "Art", "History", "Journalism"),
                new Student("Jim", 3.7F, "Math", "Physics"),
                new Student("Sheila", 3.9F, "Engineering", "Tribology", "Statistics", "Astronomy")
        );

        Map<String, List<Student>> grades = school.stream()
                .collect(Collectors.groupingBy(s->Grading.grade(s)));
        
        grades.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e->System.out.println(
                        "Students with grade " + e.getKey()
                        + ": " + e.getValue()));

        System.out.println("----------------------------------------");
        Map<String, Long> gradeCounts = school.stream()
                .collect(Collectors.groupingBy(s->Grading.grade(s), Collectors.counting()));
        
        gradeCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e->System.out.println(
                        "Students with grade " + e.getKey()
                        + ": " + e.getValue()));

    }
}
