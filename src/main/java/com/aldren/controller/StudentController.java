package com.aldren.controller;

import com.aldren.model.Student;
import com.aldren.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{studentNo}")
    public Student findStudentById(@PathVariable String studentNo)
    {
        System.out.println("Searching by ID  : " + studentNo);

        return studentService.getByStudentNo(studentNo);
    }

}
