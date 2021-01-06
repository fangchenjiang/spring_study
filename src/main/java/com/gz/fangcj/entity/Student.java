package com.gz.fangcj.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生
 *
 * @author Fang chenjiang
 * @create 2021-01-06-16:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @ExcelProperty(value = {"主键ID"}, index = 0)
    private Integer id;
    @ExcelProperty(value = {"用户姓名"}, index = 1)
    private String name;
    @ExcelProperty(value = {"用户手机号"}, index = 2)
    private String phone;


}
