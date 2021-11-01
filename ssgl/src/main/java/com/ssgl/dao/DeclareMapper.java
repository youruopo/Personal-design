package com.ssgl.dao;

import com.ssgl.entity.Declare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeclareMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Declare record);

    int updateStatus(Declare record);

    List<Declare> findAll();

    Integer total();

    List<Declare> findByStatus(@Param("status") Integer status);

    List<Declare> findByHId(@Param("hid") Integer hid);

}
