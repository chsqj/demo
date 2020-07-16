package com.example.demo.controller;

import com.example.demo.javaBean.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseBody
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @ResponseBody
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @ResponseBody
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @ResponseBody
    @PutMapping("/student")
    public String updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @ResponseBody
    @GetMapping("/classId")
    public List<Integer> getClassId(){
        return studentService.getClassId();
    }

    @ResponseBody
    @PostMapping("/student")
    public String addStudent(Student student){
        return studentService.addStudent(student);
    }
}
