package com.hk.task.mapper;

import com.hk.task.model.SysUser;
import com.hk.task.util.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {
	
	SysUser selectSysUserByAccount(String userAccount);
}