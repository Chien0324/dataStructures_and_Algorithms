package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        studentManagement.addStudent(new Student(1, "Alice", "0329912507", "HaNoi", "7.5", "Good"));
        studentManagement.addStudent(new Student(2, "Bob", "0974645356", "HaNoi", "8.0", "Very Good"));
        studentManagement.addStudent(new Student(3, "Charlie", "0326457356", "HaNoi", "6.5", "Medium"));
        studentManagement.addStudent(new Student(4, "Diana", "0943635464", "HaNoi", "9.0", "Excellent"));
        studentManagement.addStudent(new Student(5, "Edward", "0327363434", "HaNoi", "5.0", "Fall"));
        studentManagement.addStudent(new Student(6, "Fiona", "0983635353", "HaNoi", "7.0", "Good"));
        studentManagement.addStudent(new Student(7, "George", "0321736353", "HaNoi", "8.5", "Very Good"));
        studentManagement.addStudent(new Student(8, "Hannah", "0973635353", "HaNoi", "6.0", "Medium"));
        studentManagement.addStudent(new Student(9, "Ian", "0323733436", "HaNoi", "7.2", "Good"));
        studentManagement.addStudent(new Student(10, "Jessica", "0903735332", "HaNoi", "8.1", "Very Good"));
        studentManagement.addStudent(new Student(11, "Kevin", "0327773936", "HaNoi", "5.8", "Medium"));
        studentManagement.addStudent(new Student(12, "Laura", "0909060603", "HaNoi", "9.5", "Excellent"));
        // Menu chính
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Sort and display Students by Marks (Descending)");
            System.out.println("6. Search student by ID");
            System.out.println("7. Search student by Name");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentManagement.displayAllStudents();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    String marks = scanner.nextLine();
                    System.out.print("Enter Rank: ");
                    String rank = scanner.nextLine();
                    studentManagement.addStudent(new Student(id, name, contactNumber, address, marks, rank));
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = readInteger(scanner);
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String newContactNumber = scanner.nextLine();
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    String newMarks = scanner.nextLine();
                    System.out.print("Enter new Rank: ");
                    String newRank = scanner.nextLine();
                    studentManagement.updateStudent(updateId, newName, newContactNumber, newAddress, newMarks, newRank);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;
                case 5:
                    studentManagement.sortStudentsByMarksDescending();
                    break;
                case 6:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = readInteger(scanner);
                    studentManagement.searchStudentById(searchId);
                    break;
                case 7:
                    System.out.print("Enter Student Name to search: ");
                    String searchName = scanner.nextLine();
                    studentManagement.searchStudentByName(searchName);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static int readInteger(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next();
            }
        }
    }
}

