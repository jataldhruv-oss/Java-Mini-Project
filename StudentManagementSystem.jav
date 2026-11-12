import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        students.add(new Student(id, name, course));
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            for (Student s : students) {
                                s.display();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to search: ");
                        int searchId = sc.nextInt();
                        boolean found = false;
                        for (Student s : students) {
                            if (s.id == searchId) {
                                s.display();
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Student not found.");
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
            }
        } while (choice != 4);
        sc.close();
    }
}