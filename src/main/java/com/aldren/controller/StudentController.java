package com.aldren.controller;

import com.aldren.exception.RecordNotFoundException;
import com.aldren.model.Response;
import com.aldren.model.Student;
import com.aldren.service.StudentService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public @ResponseBody List<Student> getStudentList() {
        System.out.println("Get student list.");
        return studentService.getStudentList();
    }

    @GetMapping("/students/{id}")
    public @ResponseBody Student getStudentById(@PathVariable Long id) throws RecordNotFoundException {
        System.out.println("Get student with id::" + id);
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public @ResponseBody Response addStudent(@RequestBody Student student) {
        studentService.addOrUpdateStudent(student);
        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.OK.value())
                .description(HttpStatus.OK.name())
                .message("Student successfully added.")
                .path("/student")
                .build();
    }

    @PutMapping("/students")
    public @ResponseBody Response updateStudent(@RequestBody Student student) {
        studentService.addOrUpdateStudent(student);
        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.OK.value())
                .description(HttpStatus.OK.name())
                .message("Student successfully updated.")
                .path("/student")
                .build();
    }

    @DeleteMapping("/students")
    public @ResponseBody Response deleteStudent(Long id) {
        studentService.deleteStudent(id);
        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.OK.value())
                .description(HttpStatus.OK.name())
                .message("Student successfully deleted.")
                .path("/student/" + id)
                .build();
    }

}
