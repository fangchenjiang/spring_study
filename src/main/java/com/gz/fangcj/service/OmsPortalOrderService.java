package com.gz.fangcj.service;

import com.gz.fangcj.common.CommonResult;
import com.gz.fangcj.common.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Fang chenjiang
 * @Date 2021/1/22
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
