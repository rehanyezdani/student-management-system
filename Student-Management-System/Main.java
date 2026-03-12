import models.Student;
import models.Teacher;
import services.EnrollmentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnrollmentService enrollmentService = new EnrollmentService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║  STUDENT MANAGEMENT SYSTEM    ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Add Student                 ║");
            System.out.println("║ 2. Add Teacher                 ║");
            System.out.println("║ 3. Enroll Student in Course    ║");
            System.out.println("║ 4. Assign Grade                ║");
            System.out.println("║ 5. Display All Students        ║");
            System.out.println("║ 6. Display All Teachers        ║");
            System.out.println("║ 7. Calculate Student GPA       ║");
            System.out.println("║ 8. Exit                        ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Choose option (1-8): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int sAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String sId = scanner.nextLine();
                    
                    Student student = new Student(sName, sAge, sId);
                    enrollmentService.addStudent(student);
                    System.out.println("✅ Student added successfully!");
                    break;
                    
                case 2:
                    // Add Teacher
                    System.out.print("Enter teacher name: ");
                    String tName = scanner.nextLine();
                    System.out.print("Enter teacher age: ");
                    int tAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter teacher ID: ");
                    String tId = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    
                    Teacher teacher = new Teacher(tName, tAge, tId, dept);
                    enrollmentService.addTeacher(teacher);
                    System.out.println("✅ Teacher added successfully!");
                    break;
                    
                case 3:
                    // Enroll Student
                    System.out.print("Enter student ID: ");
                    String enrollId = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String course = scanner.nextLine();
                    
                    if (enrollmentService.enrollStudent(enrollId, course)) {
                        System.out.println("✅ Student enrolled successfully!");
                    } else {
                        System.out.println("❌ Student not found!");
                    }
                    break;
                    
                case 4:
                    // Assign Grade
                    System.out.print("Enter student ID: ");
                    String gradeStudentId = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String gradeCourse = scanner.nextLine();
                    System.out.print("Enter grade (0-100): ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (enrollmentService.assignGrade(gradeStudentId, gradeCourse, grade)) {
                        System.out.println("✅ Grade assigned successfully!");
                    } else {
                        System.out.println("❌ Student or course not found!");
                    }
                    break;
                    
                case 5:
                    // Display all students
                    enrollmentService.displayAllStudents();
                    break;
                    
                case 6:
                    // Display all teachers
                    enrollmentService.displayAllTeachers();
                    break;
                    
                case 7:
                    // Calculate GPA
                    System.out.print("Enter student ID: ");
                    String gpaId = scanner.nextLine();
                    Double gpa = enrollmentService.calculateStudentGPA(gpaId);
                    if (gpa != null) {
                        System.out.printf("📊 Student GPA: %.2f\n", gpa);
                    } else {
                        System.out.println("❌ Student not found!");
                    }
                    break;
                    
                case 8:
                    System.out.println("👋 Thank you for using Student Management System!");
                    System.out.println("   Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("❌ Invalid option! Please choose 1-8");
            }
        }
    }
}
