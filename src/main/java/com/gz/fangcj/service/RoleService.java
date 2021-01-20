package com.gz.fangcj.service;

import com.github.pagehelper.Page;
import com.gz.fangcj.dto.PageDTO;
import com.gz.fangcj.entity.Role;

/**
 * @Author Fang chenjiang
 * @Date 2021/1/20
 */
public interface RoleService {
    PageDTO<Role> getRoleListPage(Integer currentPage, Integer pageSize);
}
