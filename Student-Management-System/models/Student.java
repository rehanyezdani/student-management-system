package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private List<String> enrolledCourses;
    private Map<String, Double> grades;
    private double gpa;
    
    public Student(String name, int age, String studentId) {
        super(name, age, studentId);
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
        this.gpa = 0.0;
    }
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    public boolean enrollCourse(String courseName) {
        if (!enrolledCourses.contains(courseName)) {
            enrolledCourses.add(courseName);
            return true;
        }
        return false;
    }
    
    public boolean assignGrade(String courseName, double grade) {
        if (enrolledCourses.contains(courseName)) {
            grades.put(courseName, grade);
            calculateGPA();
            return true;
        }
        return false;
    }
    
    private void calculateGPA() {
        if (grades.isEmpty()) {
            gpa = 0.0;
            return;
        }
        
        double total = 0.0;
        for (double grade : grades.values()) {
            total += grade;
        }
        gpa = total / grades.size();
    }
    
    public double getGPA() { 
        return gpa; 
    }
    
    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }
    
    public Map<String, Double> getGrades() {
        return grades;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString())
               .append(String.format(" | Role: %s | GPA: %.2f\n", getRole(), gpa));
        result.append("   📚 Enrolled Courses: ");
        
        if (enrolledCourses.isEmpty()) {
            result.append("None");
        } else {
            result.append(String.join(", ", enrolledCourses));
        }
        
        if (!grades.isEmpty()) {
            result.append("\n   📊 Grades: ");
            for (Map.Entry<String, Double> entry : grades.entrySet()) {
                result.append(String.format("%s: %.1f ", entry.getKey(), entry.getValue()));
            }
        }
        
        return result.toString();
    }
}

