package com.ssgl.dao;

import com.ssgl.entity.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Leave record);

    int updateByPrimaryKeySelective(Leave record);

    List<Leave> findAll();

    Integer total();

    List<Leave> findByStatus(@Param("status") Integer status);

    List<Leave> findByStudentID(@Param("sid") Integer sid);

}
