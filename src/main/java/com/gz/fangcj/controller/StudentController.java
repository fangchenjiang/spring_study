package com.gz.fangcj.controller;

import com.gz.fangcj.annotation.PhoneHideAnnotation;
import com.gz.fangcj.common.CommonResult;
import com.gz.fangcj.entity.Student;
import com.gz.fangcj.service.impl.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "RoleController", value = "角色管理")
@RestController
@RequestMapping("/student")
public class StudentController {

    @ApiOperation("学生列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @PhoneHideAnnotation
    public CommonResult<List<Student>> getStudentList() throws Exception {

        List<Student> studentList = StudentService.studentList;
        CommonResult<List<Student>> result = CommonResult.success(studentList);
        return result;
    }
}
