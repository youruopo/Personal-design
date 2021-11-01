package com.ssgl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssgl.dao.DeclareMapper;
import com.ssgl.entity.Declare;
import com.ssgl.entity.Message;
import com.ssgl.entity.Page;
import com.ssgl.service.DeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclareServiceImpl implements DeclareService {

    @Autowired
    private DeclareMapper declareMapper;

    @Override
    public Message deleteDeclare(Integer id) {
        int result = declareMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    @Override
    public Message findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Declare> pageInfo = new PageInfo<>(declareMapper.findAll());
        List<Declare> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Integer total() {
        return declareMapper.total();
    }

    @Override
    public Message findByStatus(Page page, Integer status) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Declare> pageInfo = new PageInfo<>(declareMapper.findByStatus(status));
        List<Declare> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Message findByHId(Integer hid) {
        List<Declare> list = declareMapper.findByHId(hid);
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }
}
