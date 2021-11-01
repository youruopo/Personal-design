package com.ssgl.service;

import com.ssgl.entity.*;

public interface StudentService {
    Message login(Student student);

    Message register(Student student);

    Message edit(Student student);

    Message setClock(Integer id);

    Message fix(Declare declare);

    Message leave(Leave leave);

    Message findAll(Page page);

    Integer total();

    Message findByClockInStatus(Page page, Integer clockInStatus);

    Message deleteStudent(Integer id);

    Message checkName(String username);

}
