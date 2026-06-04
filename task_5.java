import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int no;
    String name;
    double marks;

    public Student(int no, String name, double marks) {
        this.no = no;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll No: " + no);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("-------------------");
    }
}

class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully!");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public void searchStudent(int no) {

        boolean found = false;

        for (Student s : students) {

            if (s.no == no) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void removeStudent(int no) {

        students.removeIf(student -> student.no == no);

        System.out.println("Student removed if existed.");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagementSystem sms = new StudentManagementSystem();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll No: ");
                    int no = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    sms.addStudent(new Student(no, name, marks));
                    break;

                case 2:
                    sms.displayStudents();
                    break;

                case 3:

                    System.out.print("Enter Roll No to Search: ");
                    int searchno = sc.nextInt();

                    sms.searchStudent(searchno);
                    break;

                case 4:

                    System.out.print("Enter Roll No to Remove: ");
                    int removeno = sc.nextInt();

                    sms.removeStudent(removeno);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
