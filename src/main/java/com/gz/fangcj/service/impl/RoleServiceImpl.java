package com.gz.fangcj.service.impl;

import com.github.pagehelper.Page;
import com.gz.fangcj.dto.PageDTO;
import com.gz.fangcj.entity.Role;
import com.gz.fangcj.mapper.RoleMapper;
import com.gz.fangcj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Fang chenjiang
 * @Date 2021/1/20
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Override
    public PageDTO<Role> getRoleListPage(Integer currentPage, Integer pageSize) {

        Integer begin = PageDTO.countBegin(pageSize, currentPage);
        List<Role> roleListPage=roleMapper.getRoleListPage(begin,pageSize);
        Long roleListCount = Long.valueOf(roleMapper.getRoleListCount());
        return new PageDTO<>(currentPage,roleListCount,pageSize,roleListPage);

    }
}
