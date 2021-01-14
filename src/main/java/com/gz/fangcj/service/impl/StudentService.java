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

    public static List<Student> studentList = new ArrayList<>();

    static {
        initStudentData();
    }


    public static void initStudentData() {
        studentList.add(new Student(1,"Kobe","18385525996"));
        studentList.add(new Student(2,"Lebron","18385525995"));
        studentList.add(new Student(3,"Green","18385025996"));
        studentList.add(new Student(4,"Dan","18985525996"));
        studentList.add(new Student(5,"Chenc","13785525996"));

    }
}
