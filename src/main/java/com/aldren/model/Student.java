package com.aldren.model;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter
    @Setter
    private String studentNo;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private int age;

    public Student(String studentNo, String firstName, String lastName, int age) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
