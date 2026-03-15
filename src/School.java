import java.util.ArrayList;

public class School {
    private String schoolName;
    private ArrayList<Student> students;
    
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }
    
    public void displayAllStudents() {
        System.out.println("\n=== " + schoolName + " Students ===");
        if (students.isEmpty()) {
            System.out.println("No students yet.");
        } else {
            for (Student s : students) {
                s.display();
            }
        }
    }
    
    public void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                System.out.print("Found: ");
                s.display();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
    
    public String getSchoolName() {
        return schoolName;
    }
}
