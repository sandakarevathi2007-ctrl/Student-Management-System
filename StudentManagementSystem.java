
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;
                    for (Student s : students) {
                        if (s.rollNo == roll) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Roll number already exists!");
                        break;
                    }

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks (0-100): ");
                    double marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    students.add(new Student(roll, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;
                    for (Student s : students) {
                        if (s.rollNo == updateRoll) {
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter new marks: ");
                            double newMarks = sc.nextDouble();

                            if (newMarks >= 0 && newMarks <= 100) {
                                s.marks = newMarks;
                                System.out.println("Student updated successfully!");
                            } else {
                                System.out.println("Invalid marks!");
                            }

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = sc.nextInt();

                    boolean deleted = students.removeIf(
                        s -> s.rollNo == deleteRoll
                    );

                    if (deleted) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
