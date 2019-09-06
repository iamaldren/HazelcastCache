package com.aldren.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {

    private String studentNo;

    private String firstName;

    private String lastName;

    private int age;

    public Student(String studentNo, String firstName, String lastName, int age) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
