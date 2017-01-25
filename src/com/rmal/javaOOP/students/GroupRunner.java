package com.rmal.javaOOP.students;

public class GroupRunner {

    public static void main(String[] args) {
        // Create group
        Group group = new Group();

        // Create students
        Student student1 = new Student("Ivan", "Ivanov", "male", 18, "Economy faculty", 1234567);
        Student student2 = new Student("Petya", "Petrov", "male", 17, "Mechanical faculty", 3334567);
        Student student3 = new Student("Vasya", "Pypkin", "male", 20, "Biology faculty", 6879309);
        Student student4 = new Student("Kristina", "Sidorova", "female", 21, "Energetic faculty", 7879509);
        Student student5 = new Student("Albina", "Ederbekova", "female", 19, "Fashion faculty", 7879255);
        Student student6 = new Student("Andrey", "Belik", "male", 19, "Finance faculty", 7580509);
        Student student7 = new Student("Maksim", "Shalimov", "male", 22, "Energetic faculty", 5555345);
        Student student8 = new Student("Roman", "Romanov", "male", 21, "Electrical faculty", 5234345);
        Student student9 = new Student("Alexandra", "Romanenko", "female", 16, "Psyhological faculty", 9294300);
        Student student10 = new Student("Sergey", "Kostenko", "male", 18, "Mechanical faculty", 9094333);
        Student student11 = new Student("Natalia", "Syslova", "female", 20, "Physical faculty", 9000307);

        // Add students to the group
        group.addStudent(student1, 1);
        group.addStudent(student2, 3);
        group.addStudent(student3, 5);
        group.addStudent(student4, 2);
        group.addStudent(student5, 8);
        group.addStudent(student6, 7);
        group.addStudent(student7, 10);
        group.addStudent(student8, 4);
        group.addStudent(student9, 6);
        group.addStudent(student10, 9);

        // Trying to add 11th student
        group.addStudent(student11, 11);

        // Print out group
        System.out.println(group);

        // Remove some students from group
        group.removeStudent(student9);
        group.removeStudent(student4);
        group.removeStudent(student5);
        group.removeStudent(student7);

        // Print out group
        System.out.println(group);

        // Search students by surname
        System.out.println(group.searchBySurname("Belik"));
        System.out.println(group.searchBySurname("dsgsdgsdg"));
        System.out.println(group.searchBySurname("Shalimov"));
        System.out.println(group.searchBySurname("Pypkin"));
        System.out.println(group.searchBySurname("Kostenko"));
        System.out.println(group.searchBySurname("gfhgh"));
        System.out.println(group.searchBySurname("Ivanov"));
    }
}
