package com.ssgl.service.impl;

import com.ssgl.dao.*;
import com.ssgl.entity.*;
import com.ssgl.service.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DeclareMapper declareMapper;

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private HostelMapper hostelMapper;

    /***
     * 管理员登录 BCrypt 加密方式  不对称加密
     * @param admin
     * @return
     */
    @Override
    public Message login(Admin admin) {
        Admin real = adminMapper.selectByUsername(admin.getUsername());
        if (real == null || !BCrypt.checkpw(admin.getPassword(), real.getPassword())) {//检查未加密的密码是否与以前哈希过的密码匹配
            return Message.builder().status(404).message("用户名密码错误").build();
        }
        real.setPassword("");
        return Message.builder().status(200).data(real).message("登录成功").build();
    }

    /***
     * 管理员修改密码、个人信息
     * @param admin
     * @return
     */
    @Override
    public Message edit(Admin admin) {
        if (!"".equals(admin.getPassword()) || admin.getPassword() != null) {
            admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));
        }
        int result = adminMapper.updateByPrimaryKeySelective(admin);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /**
     * 设置门禁
     *
     * @return
     */
    @Override
    public Message setClock() {
        List<Student> list = studentMapper.findAll();
        list.forEach(s -> studentMapper.updateByPrimaryKeySelective(Student.builder().id(s.getId()).clockInStatus(1).build()));
        return Message.builder().status(200).message("操作成功").build();
    }

    /**
     * 处理维修
     *
     * @param did
     * @return
     */
    @Override
    public Message doFix(Integer did) {
        Declare build = Declare.builder().id(did).status(2).build();
        int result = declareMapper.updateStatus(build);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /**
     * 批准假条
     *
     * @param lid
     * @return
     */
    @Override
    public Message doLeave(Integer lid) {
        Leave build = Leave.builder().id(lid).status(2).build();
        int result = leaveMapper.updateByPrimaryKeySelective(build);
        if (result > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

    /**
     * 给学生分配宿舍
     *
     * @param student
     * @return
     */
    @Override
    @Transactional
    public Message selectHostel(Student student) {
        Student s1 = studentMapper.selectByUsername(student.getUsername());
        Hostel oldHostel = s1.getHostel();
        if (oldHostel != null) {
            oldHostel.setAmount(oldHostel.getAmount() - 1);
            hostelMapper.updateByPrimaryKeySelective(oldHostel);
        }
        Hostel h = hostelMapper.selectByKey(student.getHostel().getId());
        h.setAmount(h.getAmount() + 1);
        int i1 = hostelMapper.updateByPrimaryKeySelective(h);
        int i = studentMapper.updateByPrimaryKeySelective(Student.builder().id(student.getId()).hostel(h).build());
        if (i > 0 && i1 > 0) {
            return Message.builder().status(200).message("操作成功").build();
        }
        return Message.builder().status(500).message("操作失败").build();
    }

}
