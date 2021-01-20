package com.gz.fangcj.mapper;

import com.github.pagehelper.Page;
import com.gz.fangcj.entity.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {


    Page<Role> getRoleListPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    int getRoleListCount();
}
