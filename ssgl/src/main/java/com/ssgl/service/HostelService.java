package com.ssgl.service;

import com.ssgl.entity.Hostel;
import com.ssgl.entity.Message;
import com.ssgl.entity.Page;

public interface HostelService {

    Message findAll(Page page);

    Integer total();

    Message edit(Hostel hostel);

    Message insert(Hostel hostel);
}
