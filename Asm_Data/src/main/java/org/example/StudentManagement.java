package org.example;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StudentManagement {
    private Stack<Student> students;

    public StudentManagement() {
        this.students = new Stack<>();
    }
    public void addStudent(Student student) {
        students.push(student);
    }

    public void updateStudent(int id, String newName, String newContactNumber, String address, String marks, String rank) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                // Create a new Student object with the updated values
                tempStack.push(new Student(id, newName, newContactNumber, address, marks, rank));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack<>();
        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }
        // Restore the original stack without the deleted student
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    public void sortStudentsByMarksDescending() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        // Transfer stack elements to a list for sorting
        List<Student> studentList = new ArrayList<>(students);
        students.clear(); // Clear the stack

        // Sort the list by marks in descending order
        studentList.sort((s1, s2) -> Double.compare(Double.parseDouble(s2.getMarks()), Double.parseDouble(s1.getMarks())));

        // Push the sorted students back into the stack
        for (Student student : studentList) {
            students.push(student);
        }

        System.out.println("Students sorted by Marks (Descending):");
        displayStudents(); // Reuse display logic
    }





    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }

        System.out.println("Students in Stack:");
        for (Student student : students) {
            System.out.println(student);
        }
    }


    public void searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Found student: " + student.getName() +
                        ", Contact: " + student.getContactNumber() +
                        ", Address: " + student.getAddress() +
                        ", Marks: " + student.getMarks() +
                        ", Rank: " + student.getRank());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Found student: ID: " + student.getId() +
                        ", Contact: " + student.getContactNumber() +
                        ", Address: " + student.getAddress() +
                        ", Marks: " + student.getMarks() +
                        ", Rank: " + student.getRank());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student with name " + name + " not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("Current student list:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

