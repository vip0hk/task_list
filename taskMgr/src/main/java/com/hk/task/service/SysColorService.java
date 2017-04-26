package com.hk.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.task.mapper.SysColorMapper;
import com.hk.task.model.SysColor;

@Service
public class SysColorService {

    @Autowired
    private SysColorMapper sysColorMapper;

    public List<SysColor> getAll() {
        return sysColorMapper.selectAll();
    }

}
