package com.ssgl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssgl.entity.Declare;
import com.ssgl.entity.Leave;
import com.ssgl.entity.Page;
import com.ssgl.entity.Student;
import com.ssgl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        return JSON.toJSONString(studentService.login(student));
    }

    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        return JSON.toJSONString(studentService.register(student));
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Student student) {
        return JSON.toJSONString(studentService.edit(student));
    }


    @GetMapping("/setClock/{id}")
    public String setClock(@PathVariable Integer id) {
        return JSON.toJSONString(studentService.setClock(id));
    }

    @PostMapping("/fix")
    public String fix(@RequestBody Declare declare) {
        return JSON.toJSONString(studentService.fix(declare));
    }

    @PostMapping("/leave")
    public String leave(@RequestBody Leave leave) {
        return JSON.toJSONString(studentService.leave(leave));
    }

    @PostMapping("/findAll")
    public String findAll(@RequestBody Page page) {
        return JSON.toJSONString(studentService.findAll(page), SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/total")
    public Integer total() {
        return studentService.total();
    }

    @PostMapping("/findByClockInStatus")
    public String findByClockInStatus(@RequestBody Page page) {
        return JSON.toJSONString(studentService.findByClockInStatus(page, page.getStatus()), SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return JSON.toJSONString(studentService.deleteStudent(id));
    }

    @GetMapping("/checkUsername/{username}")
    public String checkName(@PathVariable String username) {
        return JSON.toJSONString(studentService.checkName(username));
    }

}
