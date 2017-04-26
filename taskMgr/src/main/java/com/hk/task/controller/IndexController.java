package com.hk.task.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.task.model.SysUser;
import com.hk.task.service.SysUserService;

@RestController
@RequestMapping
public class IndexController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("loginUser")
	public SysUser getLoginUser(HttpSession session) {
			return (SysUser) session.getAttribute("loginUser");
	}
	
	@RequestMapping("login")
	public SysUser login(String username, String password, HttpSession session) {
		SysUser sysUser = sysUserService.getByAccount(username);
		if (sysUser != null && sysUser.getUserPassword().equals(password)) {
			session.setAttribute("loginUser", sysUser);
		} else {
			sysUser = null;
		}
		return sysUser;
	}

	@RequestMapping("logout")
	public Map<String, String> loginout(HttpSession session) {
		session.invalidate();
		Map<String, String> result = new HashMap<>();
		result.put("result", "logout");
		return result;
	}

}
