package org.example;

public class StudentStackArray {
    private Student[] stack;
    private int top;
    private int capacity;

    // Constructor
    public StudentStackArray(int capacity) {
        this.capacity = capacity;
        stack = new Student[capacity];
        top = -1;  // Stack is initially empty
    }

    // Push a student onto the stack
    public void push(Student student) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot add more students.");
            return;
        }
        stack[++top] = student;  // Increment top and add student
        System.out.println("Inserted: " + student);
    }

    // Pop a student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        }
        Student poppedStudent = stack[top];  // Get the student from the top
        stack[top--] = null;  // Remove the student and decrement top
        return poppedStudent;
    }

    // Peek at the top student
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top];  // Return the student at the top
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;  // Stack is empty if top is -1
    }

    // Get the size of the stack
    public int size() {
        return top + 1;  // The size is top + 1
    }

    // Display all students in the stack
    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }

        System.out.println("Students in Stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
