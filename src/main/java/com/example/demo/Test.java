package com.example.demo;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testID;
    private String subject;
    private String date;
    private int score;

    @ManyToOne()
    private Student student;

    public Test() {
    }

    public Test(String subject, String date, int score, Student student) {
        this.subject = subject;
        this.date = date;
        this.score = score;
        this.student = student;
    }

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
