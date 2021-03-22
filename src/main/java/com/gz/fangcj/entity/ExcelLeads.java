package com.gz.fangcj.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description ExcelLeads文档数据
 * @Author Fangchenjiang
 * @Date 2021/3/22 16:18
 */
@Data
public class ExcelLeads {

    @ExcelProperty("手机号码")
    private String phone;

    @ExcelProperty("父母姓名")
    private String parentName;

    @ExcelProperty("孩子姓名")
    private String childName;

    @ExcelProperty("孩子性别")
    private String sex;

    @ExcelProperty("孩子年纪")
    private Integer age;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("渠道")
    private String channelCode;

    @ExcelProperty("年级")
    private String grade;

}
