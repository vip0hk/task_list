package com.hk.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.task.mapper.SysUserMapper;
import com.hk.task.model.SysUser;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser getByAccount(String userAccount) {
        return sysUserMapper.selectSysUserByAccount(userAccount);
    }

}
