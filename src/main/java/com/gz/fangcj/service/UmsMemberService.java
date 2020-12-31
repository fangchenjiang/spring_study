package com.gz.fangcj.service;

import com.gz.fangcj.common.CommonResult;


/**
 * @Author Fang chenjiang
 * @Date 2020/12/31
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
