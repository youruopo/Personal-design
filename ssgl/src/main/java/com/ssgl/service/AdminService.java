package com.ssgl.service;

import com.ssgl.entity.Admin;
import com.ssgl.entity.Message;
import com.ssgl.entity.Student;

public interface AdminService {

    Message login(Admin admin);

    Message edit(Admin admin);

    Message setClock();

    Message doFix(Integer did);

    Message doLeave(Integer lid);

    Message selectHostel(Student student);
}
