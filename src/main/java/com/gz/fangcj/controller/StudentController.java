package com.gz.fangcj.controller;

import com.gz.fangcj.annotation.PhoneHideAnnotation;
import com.gz.fangcj.common.CommonResult;
import com.gz.fangcj.entity.Student;
import com.gz.fangcj.service.impl.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生功能接口
 *
 * @author Fang chenjiang
 * @create 2021-01-14-15:08
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @PhoneHideAnnotation
    public CommonResult<List<Student>> getStudentList() throws Exception {

        List<Student> studentList = StudentService.studentList;
        CommonResult<List<Student>> result = CommonResult.success(studentList);
        return result;
    }
}
