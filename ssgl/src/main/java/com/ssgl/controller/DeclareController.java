package com.ssgl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssgl.entity.Page;
import com.ssgl.service.DeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/declare")
public class DeclareController {

    @Autowired
    private DeclareService declareService;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return JSON.toJSONString(declareService.deleteDeclare(id));
    }

    @PostMapping("/findAll")
    public String findAll(@RequestBody Page page) {
        return JSON.toJSONString(declareService.findAll(page), SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/total")
    public Integer total() {
        return declareService.total();
    }

    @PostMapping("/findByStatus")
    public String findByStatus(@RequestBody Page page) {
        return JSON.toJSONString(declareService.findByStatus(page, page.getStatus()), SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/findByHId/{id}")
    public String findByHId(@PathVariable Integer id) {
        return JSON.toJSONString(declareService.findByHId(id));
    }
}
