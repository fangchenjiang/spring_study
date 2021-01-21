package com.gz.fangcj;

import com.alibaba.druid.pool.DruidAbstractDataSource.PhysicalConnectionInfo;
import com.gz.fangcj.entity.UmsPermission;
import com.gz.fangcj.mapper.UmsAdminRoleRelationMapper;
import com.gz.fangcj.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SpringBootTest(classes =SpringStudyApplication.class)
@Slf4j
@Transactional
class SpringStudyApplicationTests {
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    @Test
    void contextLoads() {

        //数据源
        List<UmsPermission> permissionList = adminRoleRelationMapper.getPermissionByType();

        //聚合操作
        List<UmsPermission> collect1 = permissionList.stream().filter(umsPermission ->
                umsPermission.getType() == 2).collect(Collectors.toList());

        System.out.println("====="+collect1);
        List<UmsPermission> collect2 = permissionList.stream().filter(umsPermission -> umsPermission.getType() == 1).collect(Collectors.toList());
        System.out.println("====="+collect2);

        List<String> stringList = permissionList.stream().map(UmsPermission::getName).collect(Collectors.toList());


        Map<Long, UmsPermission> collect = permissionList.stream().collect(Collectors.toMap(UmsPermission::getId,UmsPermission->UmsPermission));
        System.out.println(collect);

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
