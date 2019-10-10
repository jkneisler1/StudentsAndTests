package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TestRepository testRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("tests", testRepository.findAll());
        return "index";
    }

    @GetMapping("/addstudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @PostMapping("/process_student")
    public String processStudentForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "studentform";
        }
        studentRepository.save(student);
        return "redirect:/studentlist";
    }

    @RequestMapping("/studentlist")
    public String studentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "studentlist";
    }

    @GetMapping("/addtest")
    public String testform(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("test", new Test());
        return "testform";
    }

    @PostMapping("/process_test")
    public String processTestForm(@Valid Test test, BindingResult result) {
        if (result.hasErrors()) {
            return "testform";
        }
        testRepository.save(test);

        return "redirect:/testlist";
    }

    @RequestMapping("/testlist")
    public String testList(Model model) {
        model.addAttribute("tests", testRepository.findAll());
        return "testlist";
    }

    @RequestMapping("/detail_student/{id}")
    public String showStudent(@PathVariable("id") long id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).get());
        return "showstudent";
    }

    @RequestMapping("/update_student/{id}")
    public String updateStudent(@PathVariable("id") long id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).get());
        return "studentform";
    }

    @RequestMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return "index";
    }

    @RequestMapping("/detail_test/{id}")
    public String showTest(@PathVariable("id") long id, Model model) {
        model.addAttribute("test", testRepository.findById(id).get());
        return "showtest";
    }

    @RequestMapping("/update_test/{id}")
    public String updateTest(@PathVariable("id") long id, Model model) {
        model.addAttribute("test", testRepository.findById(id).get());
        model.addAttribute("students", studentRepository.findAll());
        return "testform";
    }

    @RequestMapping("/delete_test/{id}")
    public String deleteTest(@PathVariable("id") long id) {
        testRepository.deleteById(id);
        return "index";
    }
}
