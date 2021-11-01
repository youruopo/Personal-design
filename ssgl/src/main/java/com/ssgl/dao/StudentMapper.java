package com.ssgl.dao;

import com.ssgl.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    Student selectByUsername(@Param("username") String username);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    List<Student> findAll();

    Integer total();

    List<Student> findByClockInStatus(@Param("clockInStatus") Integer clockInStatus);

}
