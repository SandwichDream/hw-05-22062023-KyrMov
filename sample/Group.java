package sample;

import java.util.Arrays;
import java.util.Comparator;

import sample.exceptions.GroupOverflowException;
import sample.exceptions.StudentNotFoundException;
import sample.exceptions.SameIdException;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];
    private int size = 0;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {

    }

    public void addStudent(Student student) throws GroupOverflowException, SameIdException {
        if (size >= students.length) {
            throw new GroupOverflowException("Group is full. Cannot add more students.");
        } else {
            for (int i = 0; i < size; i++) {
                if (this.students[i] != null && students[i].getId() == student.getId()) {
                    throw new SameIdException("ID " + student.getId() + " is already taken");
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                size++;
                break;
            }
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("Student with last name '" + lastName + "' not found.");
    }

    public boolean removeStudentByID(int id) throws StudentNotFoundException {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                size--;
                return true;
            }
        }
        throw new StudentNotFoundException("Student with id '" + id + "' not found.");
    }

    public void sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new StudentLastNameComparator()));
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].setGroupName(groupName);
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        String students = "";
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                students += System.lineSeparator() + this.students[i];
            }
        }
        return groupName + ": " + students;
    }
}