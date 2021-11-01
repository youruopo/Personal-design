package com.ssgl.dao;

import com.ssgl.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin selectByUsername(String username);

    int updateByPrimaryKeySelective(Admin record);

}
