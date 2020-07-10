package com.example.demo.service;

import com.example.demo.javaBean.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private Set<Student> students = new HashSet<>();

    public void init() {
        if(students.size() > 0) return;
        students.add(new Student(1,1,"小明", "男", 1,80));
        students.add(new Student(2,1,"小明", "男", 2,70));
        students.add(new Student(3,1,"小明", "男", 3,60));
        students.add(new Student(4,2,"小红", "女", 1,90));
        students.add(new Student(5,2,"小红", "女", 2,70));
        students.add(new Student(6,2,"小红", "女", 3,90));
        students.add(new Student(7,3,"小花", "女", 1,100));
        students.add(new Student(8,3,"小花", "女", 2,100));
        students.add(new Student(9,3,"小花", "女", 3,100));
    }

    public Set<Student> getStudents(){
        return students;
    }

    public String deleteStudent(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                students.remove(student);
                return "删除成功";
            }
        }
        return "删除失败";
    }

    public List<Integer> getClassId(){
        Set<Integer> set = new HashSet<>();
        for(Student student : students) {
            set.add(student.getClass_id());
        }
        return new ArrayList<>(set);
    }

    public String addStudent(Student student){
        student.setId(students.size()+1);
        students.add(student);
        return "添加信息成功";
    }

    public String updateStudent(Student student){
        for(Student stu : students) {
            if(stu.getId() == student.getId()) {
                BeanUtils.copyProperties(student, stu);
            }
        }
        return "修改信息成功";
    }

    public Student getStudent(int id) {
        for(Student student : students) {
            if(student.getId() == id) return student;
        }
        return null;
    }
}
