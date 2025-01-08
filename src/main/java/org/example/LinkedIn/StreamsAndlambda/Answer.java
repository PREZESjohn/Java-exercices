package org.example.LinkedIn.StreamsAndlambda;

import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// Write your answer here, and then test your code.
// Your job is to implement the findAnswer() method.

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Return the highest grade for the students with a specific major
    static int findAnswer(List<Student> students, String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .flatMap(student -> student.getGrades().values().stream())
                .max(Integer::compareTo)
                .orElse(0);
    }

}

class Student {
    private String firstname;
    private String lastname;
    private String major;
    private Map<String, Integer> grades;

    public Student(String firstname, String lastname, String major, Map<String, Integer> grades) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
        this.grades = grades;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMajor() {
        return major;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}



