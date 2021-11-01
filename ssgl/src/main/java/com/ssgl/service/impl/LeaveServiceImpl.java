package com.ssgl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssgl.dao.LeaveMapper;
import com.ssgl.entity.Leave;
import com.ssgl.entity.Message;
import com.ssgl.entity.Page;
import com.ssgl.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public Message deleteLeave(Integer id) {
        int result = leaveMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    @Override
    public Message findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Leave> pageInfo = new PageInfo<>(leaveMapper.findAll());
        List<Leave> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Message findByStatus(Page page, Integer status) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Leave> pageInfo = new PageInfo<>(leaveMapper.findByStatus(status));
        List<Leave> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Integer total() {
        return leaveMapper.total();
    }

    @Override
    public Message findByStudentID(Integer sid) {
        List<Leave> list = leaveMapper.findByStudentID(sid);
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }
}
