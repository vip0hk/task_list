package com.hk.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.task.model.SysColor;
import com.hk.task.service.SysColorService;

@RestController
@RequestMapping("/colors")
public class SysColorController {

    @Autowired
    private SysColorService sysColorService;

    @RequestMapping()
    public List<SysColor> getAll(String userAccount, String password) {
    	List<SysColor> colors = sysColorService.getAll();
        return colors;
    }
}
