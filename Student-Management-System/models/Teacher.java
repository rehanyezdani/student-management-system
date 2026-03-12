package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private String department;
    private List<String> teachingCourses;
    private double salary;
    
    public Teacher(String name, int age, String teacherId, String department) {
        super(name, age, teacherId);
        this.department = department;
        this.teachingCourses = new ArrayList<>();
        this.salary = 50000.0; // Base salary
    }
    
    @Override
    public String getRole() {
        return "Teacher";
    }
    
    public void assignCourse(String courseName) {
        teachingCourses.add(courseName);
    }
    
    // Method overloading - polymorphism
    public void assignCourse(String courseName, String schedule) {
        teachingCourses.add(courseName + " (" + schedule + ")");
    }
    
    // Getters
    public String getDepartment() { 
        return department; 
    }
    
    public List<String> getTeachingCourses() { 
        return teachingCourses; 
    }
    
    public double getSalary() { 
        return salary; 
    }
    
    public void setSalary(double salary) { 
        this.salary = salary; 
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Role: %s | Dept: %s | Courses: %s", 
               getRole(), department, 
               teachingCourses.isEmpty() ? "None" : teachingCourses);
    }
}
