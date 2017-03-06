package school;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private float gpa;
    private List<String> courses;

    public Student(String name, float gpa, String ... courses) {
        this.name = name;
        this.gpa = gpa;
        this.courses = Arrays.asList(courses);
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }
}
