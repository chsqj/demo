package com.example.demo.javaBean;

public class Student {
    private int id;
    private int num;
    private String name;
    private String gender;
    private int class_id;
    private int score;

    public Student() {

    }

    public Student(int id, int num, String name, String gender, int class_id, int score) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.gender = gender;
        this.class_id = class_id;
        this.score = score;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", class_id=" + class_id +
                ", score=" + score +
                '}';
    }
}
