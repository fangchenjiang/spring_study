package com.gz.fangcj.controller;

import com.gz.fangcj.entity.Student;
import com.gz.fangcj.service.impl.StudentService;
import com.gz.fangcj.util.EasyExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 数据导出
 * 阿里EasyExcel使用
 *
 * @author Fang chenjiang
 * @create 2021-01-06-16:21
 */
@Api(tags = "ExportController", value = "数据导出接口")
@RequestMapping("/export")
@RestController
public class ExportController {

    @ApiOperation("导出所有学生数据")
    @RequestMapping(value = "/studentData", method = RequestMethod.GET)
    public void exportData(HttpServletResponse response) throws Exception {
        List<Student> studentList = StudentService.studentList;
        EasyExcelUtil.exportExcel(response, studentList);
    }

}
