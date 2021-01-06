package com.gz.fangcj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.gz.fangcj.mapper")
@EnableScheduling
public class SpringStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }

//    @Value("${server.port}")
//    private String appport;  //站点端口号
//    /*当端口启动后，直接跳转界面*/
//    @EventListener({ApplicationReadyEvent.class})
//    void applicationReadyEvent() {
//        String url = "http://localhost:" + appport+"/doc.html";
//        //url可以直接写死,如 http://localhost:8080
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
