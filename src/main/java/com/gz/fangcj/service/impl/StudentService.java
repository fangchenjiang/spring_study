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
        for (int i = 0; i <7 ; i++) {
            studentList.add((new Student(1, "xf", "12345")));
        }
    }
}
