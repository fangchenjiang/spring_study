package com.gz.fangcj.service.impl;

import com.gz.fangcj.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生数据
 *
 * @author Fang chenjiang
 * @create 2021-01-06-16:29
 */
@Component
public class StudentService {

    public static List<Student>studentList=new ArrayList<>();

    static {
        initStudentData();
    }


    public  static void initStudentData(){
        studentList.add(new Student(1,"xf","12345"));
        studentList.add(new Student(2,"xf","12345"));
        studentList.add(new Student(3,"xf","12345"));
        studentList.add(new Student(4,"xf","12345"));
        studentList.add(new Student(5,"xf","12345"));
        studentList.add(new Student(6,"xf","12345"));
        studentList.add(new Student(7,"xf","12345"));




    }
}
