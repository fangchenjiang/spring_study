package com.gz.fangcj.mapper;

import com.gz.fangcj.entity.Roleresource;

public interface RoleresourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Roleresource record);

    int insertSelective(Roleresource record);

    Roleresource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Roleresource record);

    int updateByPrimaryKey(Roleresource record);
}