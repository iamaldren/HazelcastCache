package com.aldren.service;

import com.aldren.model.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames={"student"})
public class StudentService {

    @CacheEvict(allEntries = true)
    @Scheduled(cron = "0 0 0,12 * * ?")
    public void evictAllCacheValues() {}

    @Cacheable
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
