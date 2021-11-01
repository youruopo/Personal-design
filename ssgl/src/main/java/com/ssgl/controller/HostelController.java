package com.ssgl.controller;

import com.alibaba.fastjson.JSON;
import com.ssgl.entity.Hostel;
import com.ssgl.entity.Page;
import com.ssgl.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hostel")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("/findAll")
    public String findAll(@RequestBody Page page) {
        return JSON.toJSONString(hostelService.findAll(page));
    }

    @GetMapping("/total")
    public Integer total() {
        return hostelService.total();
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Hostel hostel) {
        return JSON.toJSONString(hostelService.edit(hostel));
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Hostel hostel) {
        return JSON.toJSONString(hostelService.insert(hostel));
    }
}
