package com.ssgl.service;

import com.ssgl.entity.Message;
import com.ssgl.entity.Page;

public interface DeclareService {

    Message deleteDeclare(Integer id);

    Message findAll(Page page);

    Integer total();

    Message findByStatus(Page page, Integer status);

    Message findByHId(Integer hid);
}
