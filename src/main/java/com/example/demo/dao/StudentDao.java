package com.example.demo.dao;

import com.example.demo.javaBean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {
    public List<Student> getStudents();

    public int deleteStudent(int id);

    public Student getStudent(int id);

    public List<Integer> getClassId();

    public int updateStudent(Student student);

    public int addStudent(Student student);
}
