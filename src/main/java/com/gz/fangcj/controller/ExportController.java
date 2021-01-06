package com.gz.fangcj.controller;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.gz.fangcj.common.CommonResult;
import com.gz.fangcj.entity.PmsBrand;
import com.gz.fangcj.entity.Student;
import com.gz.fangcj.service.impl.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据导出
 * 阿里EasyExcel使用
 * @author Fang chenjiang
 * @create 2021-01-06-16:21
 */
@Api(tags = "ExportController", value = "数据导出接口")
@RequestMapping("/export")
@Controller
public class ExportController {

    @ApiOperation("导出所有学生数据")
    @RequestMapping(value = "/studentData", method = RequestMethod.GET)
    @ResponseBody
    public void exportData(HttpServletResponse response)throws  Exception {
        List<Student> studentList = StudentService.studentList;
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), Student.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                    .doWrite(studentList);

        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSONUtil.toJsonStr(map));

        }
    }

}
