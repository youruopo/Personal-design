package com.ssgl.service;

import com.ssgl.entity.Message;
import com.ssgl.entity.Page;

public interface LeaveService {

    Message deleteLeave(Integer id);

    Message findAll(Page page);

    Message findByStatus(Page page, Integer status);

    Integer total();

    Message findByStudentID(Integer sid);
}
