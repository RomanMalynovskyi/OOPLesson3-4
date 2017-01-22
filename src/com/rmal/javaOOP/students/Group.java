package com.rmal.javaOOP.students;

/*3)Создайте класс группа — который содержит массив из 10
        объектов класса студент. Реализуйте методы добавления,
        удаления студента и метод поиска студента по фамилии. В
        случае попытки добавления 11 студента создайте
        собственное исключение и обработайте его. Определите
        метод toString() для группы так, что бы он выводил список
        студентов в алфавитном порядке.*/

import java.util.Arrays;
import java.util.Comparator;


class Group {

    private Student[] students = new Student[10];

    public Group(Student[] students) {
        this.students = students;
    }

    public Group() {
        super();
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student, int position) {
        try {
            if (position > students.length || position < 0) {
                throw new MyArrayOutOfBoundException();
            }
            if (isStudentInGroup(student)) {
                System.out.println("Student " + student.getName() + " " + student.getSurname() +
                        " already in this group, please,add another student!");
                System.out.println("---------------------------------------------");
            } else if (students[position - 1] == null) {
                students[position - 1] = student;
                System.out.println("Student " + student.getName() + " " + student.getSurname() + " added to group on position № "
                        + position);
                System.out.println("----------------------------------------------");
            } else {
                System.out.println("Position № " + position + " is occupied. Please choose other position!");
                System.out.println("----------------------------------------------");
            }
        } catch (MyArrayOutOfBoundException myException) {
            System.out.println(myException.getMessage());
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (!isStudentInGroup(student)) {
                System.out.println(student.toString() + " not founded in this group, enter correct data of student!");
                System.out.println("----------------------------------------------");
                break;
            } else if (students[i] == null || !students[i].equals(student)) {
                continue;
            } else if (students[i].equals(student)) {
                students[i] = null;
                System.out.println("Student " + student.getName() + " " + student.getSurname() + " removed from group!");
                System.out.println("----------------------------------------------");
                break;
            }
        }
    }

    public void searchBySurname(String surname) {
        try {
            for (int i = 0; i < students.length; i++) {
                if (i == students.length - 1 && !surname.equalsIgnoreCase(students[i].getSurname())) {
                    System.out.println("Student with surname " + surname + " not founded! Enter correct surname!");
                } else if (students[i] == null || !surname.equalsIgnoreCase(students[i].getSurname())) {
                    continue;
                } else if (surname.equalsIgnoreCase(students[i].getSurname())) {
                    System.out.println(students[i].toString() + " In this group!");
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Student with surname " + surname + " not in this group!");
        }
    }

    public boolean isStudentInGroup(Student student) {
        boolean isStudentInGroup = false;
        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
                isStudentInGroup = true;
            }
        }
        return isStudentInGroup;
    }

    public Student[] sortedGroup(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1 == null && o2 != null) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return students;
    }

    @Override
    public String toString() {
        return "Group{" + Arrays.toString(sortedGroup(students)) + '}' + "\n";
    }
}


