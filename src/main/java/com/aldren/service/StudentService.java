package com.aldren.service;

import com.aldren.model.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Cacheable("student")
    public Student getByStudentNo(String studentNo)
    {
        try
        {
            System.out.println("Simulating back-end call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return new Student(studentNo, "Aldren", "Reevers", 20);
    }

}
