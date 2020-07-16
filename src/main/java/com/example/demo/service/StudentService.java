package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.UserDao;
import com.example.demo.javaBean.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public List<Student> getStudents(){
        return studentDao.getStudents();
    }

    public String deleteStudent(int id) {
        return studentDao.deleteStudent(id)==0?"删除失败":"删除成功";
    }

    public List<Integer> getClassId(){
        return studentDao.getClassId();
    }

    public String addStudent(Student student){
        return studentDao.addStudent(student)==0?"添加信息失败":"添加信息成功";
    }

    public String updateStudent(Student student){
        return studentDao.updateStudent(student)==0?"修改信息失败":"修改信息成功";
    }

    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }
}
