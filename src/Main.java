import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== STUDENT RECORD SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch(choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    
                    Student s = new Student(name, roll, grade);
                    school.addStudent(s);
                    break;
                    
                case 2:
                    school.displayAllStudents();
                    break;
                    
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    school.searchStudent(searchRoll);
                    break;
                    
                case 4:
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
