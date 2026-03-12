package services;

import models.Student;
import models.Teacher;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private List<Student> students;
    private List<Teacher> teachers;
    
    public EnrollmentService() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    // Student operations
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("📝 Student registered: " + student.getName());
    }
    
    public boolean enrollStudent(String studentId, String courseName) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student.enrollCourse(courseName);
            }
        }
        return false;
    }
    
    public boolean assignGrade(String studentId, String courseName, double grade) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student.assignGrade(courseName, grade);
            }
        }
        return false;
    }
    
    public Double calculateStudentGPA(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student.getGPA();
            }
        }
        return null;
    }
    
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("📭 No students registered yet.");
            return;
        }
        
        System.out.println("\n🎓 ===== ALL STUDENTS ===== 🎓");
        System.out.println("Total Students: " + students.size());
        System.out.println("──────────────────────────────");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println("──────────────────────────────");
    }
    
    // Teacher operations
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("👨‍🏫 Teacher registered: " + teacher.getName());
    }
    
    public void displayAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("📭 No teachers registered yet.");
            return;
        }
        
        System.out.println("\n👨‍🏫 ===== ALL TEACHERS ===== 👩‍🏫");
        System.out.println("Total Teachers: " + teachers.size());
        System.out.println("──────────────────────────────");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i));
        }
        System.out.println("──────────────────────────────");
    }
    
    // Search operations
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    public Teacher findTeacherById(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }
    
    // Statistics
    public void showStatistics() {
        System.out.println("\n📊 ===== SYSTEM STATISTICS ===== 📊");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Teachers: " + teachers.size());
        
        int totalEnrollments = 0;
        for (Student student : students) {
            totalEnrollments += student.getEnrolledCourses().size();
        }
        System.out.println("Total Course Enrollments: " + totalEnrollments);
        System.out.println("──────────────────────────────");
    }
}
