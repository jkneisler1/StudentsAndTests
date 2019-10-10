package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TestRepository testRepository;

    @Override
    public void run(String... strings) {
        Student student;
        Test test;

        // First Student and their tests
        student = new Student("John", "Doe", "Chemistry");
        studentRepository.save(student);

        test = new Test("Chemistry", "10/10/19", 90, student);
        testRepository.save(test);

        test = new Test("Chemistry", "11/11/19", 92, student);
        testRepository.save(test);

        test = new Test("Chemistry", "12/12/19", 87, student);
        testRepository.save(test);


        // Second Student and their tests
        student = new Student("Mary", "Smith", "English");
        studentRepository.save(student);

        test = new Test("English", "10/11/19", 89, student);
        testRepository.save(test);

        test = new Test("English", "11/12/19", 93, student);
        testRepository.save(test);

        test = new Test("English", "12/13/19", 92, student);
        testRepository.save(test);


        // Third Student and their tests
        student = new Student("Jim", "Brown", "History");
        studentRepository.save(student);

        test = new Test("History", "10/12/19", 91, student);
        testRepository.save(test);

        test = new Test("History", "11/13/19", 87, student);
        testRepository.save(test);

        test = new Test("History", "12/14/19", 98, student);
        testRepository.save(test);



        // Fourth Student and their tests
        student = new Student("Sarah", "Jones", "Math");
        studentRepository.save(student);

        test = new Test("Math", "10/13/19", 86, student);
        testRepository.save(test);

        test = new Test("Math", "11/14/19", 97, student);
        testRepository.save(test);

        test = new Test("Math", "12/15/19", 92, student);
        testRepository.save(test);
    }

}
