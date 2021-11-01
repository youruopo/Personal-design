package com.ssgl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssgl.dao.HostelMapper;
import com.ssgl.entity.Hostel;
import com.ssgl.entity.Message;
import com.ssgl.entity.Page;
import com.ssgl.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelMapper hostelMapper;

    @Override
    public Message findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Hostel> pageInfo = new PageInfo<>(hostelMapper.findAll());
        List<Hostel> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Integer total() {
        return hostelMapper.total();
    }

    @Override
    public Message edit(Hostel hostel) {
        int result = hostelMapper.updateByPrimaryKeySelective(hostel);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    @Override
    public Message insert(Hostel hostel) {
        int result = hostelMapper.insertSelective(hostel);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }
}
