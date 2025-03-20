package Generics;

import java.util.ArrayList;
import java.util.List;

// Abstract Course Type
abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    @Override
    public String toString() {
        return "Evaluation Method: " + evaluationMethod;
    }
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Department: " + department + ", " + courseType;
    }
}

// Course Management System
class UniversityCourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        // Creating Courses
        Course<ExamCourse> math = new Course<>("Mathematics", "Science", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("History", "Arts", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Quantum Physics", "Research", new ResearchCourse());

        // Storing Courses in a List
        List<Course<?>> courses = new ArrayList<>();
        courses.add(math);
        courses.add(history);
        courses.add(physics);

        // Display Courses
        System.out.println("University Courses:");
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }
}

