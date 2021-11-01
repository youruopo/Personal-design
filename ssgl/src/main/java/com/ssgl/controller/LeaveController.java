package com.ssgl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssgl.entity.Page;
import com.ssgl.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return JSON.toJSONString(leaveService.deleteLeave(id));
    }

    @PostMapping("/findAll")
    public String findAll(@RequestBody Page page) {
        return JSON.toJSONString(leaveService.findAll(page), SerializerFeature.DisableCircularReferenceDetect);
    }

    @PostMapping("/findByStatus")
    public String findByStatus(@RequestBody Page page) {
        return JSON.toJSONString(leaveService.findByStatus(page, page.getStatus()), SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/total")
    public Integer total() {
        return leaveService.total();
    }

    @GetMapping("/findBySId/{id}")
    public String findBySId(@PathVariable Integer id) {
        return JSON.toJSONString(leaveService.findByStudentID(id));
    }
}
