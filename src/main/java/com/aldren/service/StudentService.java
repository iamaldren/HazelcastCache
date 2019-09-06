package com.aldren.service;

import com.aldren.exception.RecordNotFoundException;
import com.aldren.model.Student;
import com.aldren.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames={"student"})
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @CacheEvict(allEntries = true)
    @Scheduled(cron = "0 0 0,12 * * ?")
    public void evictAllCacheValues() {}

    @Cacheable
    public List<Student> getStudentList() {
        System.out.println("Retrieving student list from the database...");
        return repo.findAll();
    }

    @Cacheable(key = "#id")
    public Student getStudent(Long id) throws RecordNotFoundException {
        System.out.println("Retrieving student from the database...");
        Optional<Student> student = repo.findById(id);
        if(!student.isPresent()) {
            throw new RecordNotFoundException("Student with id " + id + " is not found.");
        }
        return student.get();
    }

    @CachePut(key = "#student.id")
    public Student addOrUpdateStudent(Student student) {
        System.out.println("Adding/Updating student in the database...");
        return repo.saveAndFlush(student);
    }

    @CacheEvict(key = "#id")
    public void deleteStudent(Long id) {
        System.out.println("Deleting student in the database...");
        repo.deleteById(id);
    }

}
