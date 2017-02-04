package com.rmal.javaOOP.students;

 /*     1.Усовершенствуйте класс Group добавив возможность
        интерактивного добавления объекта.
        2. Реализуйте возможность сортировки списка студентов
        по фамилии.
        3. Реализуйте возможность сортировки по параметру
        (Фамилия, успеваемость и т. д.).*/

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


class Group implements Voenkom {

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

    /*Усовершенствуйте класс описывающий группу студентов
    добавив возможность сохранения группы в файл.*/

    public void safeGroupInFile(String pathname) {
        try (PrintWriter pw = new PrintWriter(pathname)) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    pw.print(students[i].getName() + " ,");
                    pw.println(students[i].getSurname() + " ,");
                    pw.print(students[i].getGender() + " ,");
                    pw.println(students[i].getAge() + " ,");
                    pw.print(students[i].getFaculty() + " ,");
                    pw.println(students[i].getNumberOfTestBook() + " ,");
                    pw.println(" ");
                } else {
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not founded!");
        }
    }

    /*Реализовать обратный процесс — т.е. считать данные о
    группе из файла и на их основе создать объект типа группа.*/

    public Group getGroupFromFile(String pathname) {
        Group fromFile = new Group();
        Student[] students = new Student[10];
        String s1 = "";
        try (BufferedReader bf = new BufferedReader(new FileReader(pathname))) {
            for (;(s1 = bf.readLine()) != null; ) {
               String[] array = s1.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile(String pathname) {
        String s1 = "";
        String str = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(pathname))) {
            for (; (s1 = bf.readLine()) != null; ) {
                str = s1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String[] splitingString(String str) {
        String[] array = str.split(",");
        return array;
    }


    public void interactiveAddStudent() {
        for (int i = 0; i < students.length; i++) {
            try {
                while (true) {
                    Student interStudent = new Student();
                    String name = String.valueOf(JOptionPane.showInputDialog(null, "Enter student name"));
                    interStudent.setName(name);
                    String surname = String.valueOf(JOptionPane.showInputDialog(null, "Enter student surname"));
                    interStudent.setSurname(surname);
                    String gender = String.valueOf(JOptionPane.showInputDialog(null, "Enter student gender"));
                    interStudent.setGender(gender);
                    int age = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter student age"));
                    interStudent.setAge(age);
                    String faculty = String.valueOf(JOptionPane.showInputDialog(null, "Enter student faculty"));
                    interStudent.setFaculty(faculty);
                    int numberOfTestBook = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter student number of test book"));
                    interStudent.setNumberOfTestBook(numberOfTestBook);
                    int position = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter student position"));
                    checkPosition(interStudent, position);
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wrong format of data!!!");
                continue;
            }
            String ask = String.valueOf(JOptionPane.showInputDialog(null, "Do you want add more student? Y/n?"));
            if (ask.equalsIgnoreCase("y")) {
                continue;
            } else if (ask.equalsIgnoreCase("n") || i == students.length - 1) {
                break;
            }
        }
    }

    private void checkPosition(Student interStudent, int position) {
        if (students[position - 1] == null) {
            students[position - 1] = interStudent;
            System.out.println("Student with surname " + interStudent.getSurname() + " added to position № " + position);
        } else {
            while (true) {
                int altposition = Integer.valueOf(JOptionPane.showInputDialog(null, "Position is occupied! Please,choose another one!"));
                if (students[altposition - 1] == null) {
                    students[altposition - 1] = interStudent;
                    System.out.println("Student with surname " + interStudent.getSurname() + " added to position № " + altposition);
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    public Student[] sortedByAge(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null && o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1 != null && o2 != null && o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return students;
    }

    public Student[] sortedBySurname(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return o1.getSurname().compareTo(o2.getSurname());
                } else if (o1 == null && o2 != null) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return students;
    }

    public Student[] sortedByName(Student[] students) {
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
    public Student[] getStudentForArmy(Group group) {
        Student[] forArmy = new Student[getStudents().length];
        int i = 0;
        for (int j = 0; j < students.length; j++) {
            if (group.students[j] != null && group.students[j].getGender().equals("male") && group.students[j].getAge() > 18) {
                forArmy[i] = group.students[j];
                i++;
            } else {
                continue;
            }
        }
        return forArmy;
    }

    public void addStudent(Student student, int position) {
        try {
            if (position > students.length || position < 0) {
                throw new MyArrayOutOfBoundException("Group contain " + students.length +
                        " students, you can not add more student !!!Or check student position(1.." + students.length + ")");
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

    public Student searchBySurname(String surname) {
        Student student = new Student();
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null || !surname.equals(students[i].getSurname())) {
                continue;
            }
            if (surname.equals(students[i].getSurname())) {
                student = students[i];
                break;
            } else {
                return null;
            }
        }
        return student;
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

    @Override
    public String toString() {
        return "Group{" + Arrays.toString(sortedByName(students)) + '}' + "\n";
    }
}


