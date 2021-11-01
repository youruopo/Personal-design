package com.ssgl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssgl.dao.DeclareMapper;
import com.ssgl.dao.HostelMapper;
import com.ssgl.dao.LeaveMapper;
import com.ssgl.dao.StudentMapper;
import com.ssgl.entity.*;
import com.ssgl.service.StudentService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DeclareMapper declareMapper;

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private HostelMapper hostelMapper;

    /***
     * 学生登陆
     * @param student
     * @return
     */
    @Override
    public Message login(Student student) {
        Student real = studentMapper.selectByUsername(student.getUsername());
        if (real == null || !BCrypt.checkpw(student.getPassword(), real.getPassword())) {
            return Message.builder().status(404).message("用户名密码错误").build();
        }
        real.setPassword("");
        return Message.builder().status(200).data(real).message("操作成功").build();
    }

    /**
     * 学生注册
     *
     * @param student
     * @return
     */
    @Override
    public Message register(Student student) {
        student.setPassword(BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
        int result = studentMapper.insertSelective(student);
        if (result > 0) {
            return Message.builder().status(200).message("注册成功").build();
        }
        return Message.builder().status(500).message("注册失败").build();
    }

    /***
     * 修改个人信息
     * @param student
     * @return
     */
    @Override
    public Message edit(Student student) {
        if (!"".equals(student.getPassword()) || student.getPassword() != null) {
            student.setPassword(BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
        }
        int result = studentMapper.updateByPrimaryKeySelective(student);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /***
     * 学生打卡
     * @param id
     * @return
     */
    @Override
    public Message setClock(Integer id) {
        Student build = Student.builder().id(id).clockInStatus(2).build();
        int result = studentMapper.updateByPrimaryKeySelective(build);
        if (result > 0) {
            return Message.builder().status(200).message("打卡成功").build();
        }
        return Message.builder().status(500).message("打卡失败").build();
    }

    /***
     * 学生维修
     * @param declare
     * @return
     */
    @Override
    public Message fix(Declare declare) {
        int result = declareMapper.insertSelective(declare);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /**
     * 学生请假
     *
     * @param leave
     * @return
     */
    @Override
    public Message leave(Leave leave) {
        int result = leaveMapper.insertSelective(leave);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /**
     * 显示所有学生信息
     *
     * @param page
     * @return
     */
    @Override
    public Message findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Student> pageInfo = new PageInfo<>(studentMapper.findAll());
        List<Student> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    @Override
    public Integer total() {
        return studentMapper.total();
    }

    /**
     * 根据 打卡情况 查询学生信息
     *
     * @param page
     * @param clockInStatus
     * @return
     */
    @Override
    public Message findByClockInStatus(Page page, Integer clockInStatus) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        PageInfo<Student> pageInfo = new PageInfo<>(studentMapper.findByClockInStatus(clockInStatus));
        List<Student> list = pageInfo.getList();
        return Message.builder().status(200).message(list.size() > 0 ? "查询成功" : "暂无数据").data(list).build();
    }

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    @Override
    public Message deleteStudent(Integer id) {
        int result = studentMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    @Override
    public Message checkName(String username) {
        Student student = studentMapper.selectByUsername(username);
        if (student == null){
            return Message.builder().status(200).message("用户名可用").build();
        }
        return Message.builder().status(400).message("用户名不可用").build();
    }
}
