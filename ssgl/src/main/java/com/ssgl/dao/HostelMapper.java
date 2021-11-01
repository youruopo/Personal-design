package com.ssgl.dao;

import com.ssgl.entity.Hostel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HostelMapper {

    int insertSelective(Hostel record);

    int updateByPrimaryKeySelective(Hostel record);

    Hostel selectByKey(Integer id);

    List<Hostel> findAll();

    Integer total();
}
