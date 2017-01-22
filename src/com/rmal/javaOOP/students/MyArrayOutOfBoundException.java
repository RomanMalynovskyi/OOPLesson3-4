package com.rmal.javaOOP.students;

class MyArrayOutOfBoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Group contain 10 students, you can not add more student!!! Or check student position(1..10)";
    }
}
