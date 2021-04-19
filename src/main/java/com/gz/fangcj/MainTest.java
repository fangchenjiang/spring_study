package com.gz.fangcj;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description MAin
 * @Author Fangchenjiang
 * @Date 2021/3/22 17:04
 */
@Slf4j
public class MainTest {
    public static void main(String[] args) {

//        String  phone="160000551211";
//        System.out.println(phone.substring(0,7));


        List<String> list = new ArrayList<String>(1);
        list.add("公众号：捡田螺的小男孩");
        String[] array1 = list.toArray(new String[0]);



    }
}
