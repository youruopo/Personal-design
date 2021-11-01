package com.ssgl.controller;

import com.alibaba.fastjson.JSON;
import com.ssgl.entity.Admin;
import com.ssgl.entity.Student;
import com.ssgl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        return JSON.toJSONString(adminService.login(admin));
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Admin admin) {
        return JSON.toJSONString(adminService.edit(admin));
    }

    @GetMapping("/setClock")
    public String setClock() {
        return JSON.toJSONString(adminService.setClock());
    }

    @GetMapping("/doFix/{id}")
    public String doFix(@PathVariable Integer id) {
        return JSON.toJSONString(adminService.doFix(id));
    }

    @GetMapping("/doLeave/{id}")
    public String doLeave(@PathVariable Integer id) {
        return JSON.toJSONString(adminService.doLeave(id));
    }

    @PostMapping("/selectHostel")
    public String selectHostel(@RequestBody Student student) {
        return JSON.toJSONString(adminService.selectHostel(student));
    }

}
