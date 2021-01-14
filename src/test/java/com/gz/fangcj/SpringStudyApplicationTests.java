package com.gz.fangcj;

import com.alibaba.druid.pool.DruidAbstractDataSource.PhysicalConnectionInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;


@Slf4j
@Transactional
class SpringStudyApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void testTX() {

        //组装消息
        String message = packageMsg();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    sendMQ(message);
                }});
        }
        //发送消息
        public void sendMQ (String message){
            System.out.println("消息发送到Rabbit MQ:" + message);
        }

        @Transactional
        public  String  packageMsg(){
            String message = "";
            try {
                Thread.sleep(3000);
                message = "hello,xf";
                log.info("消息收集成功:{}", message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return message;
        }




    }
