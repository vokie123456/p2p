package com.xmg.p2p.mgrsite.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.service.ILogininfoService;
import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.UserContext;
/**
 * 后台登录系统
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private ILogininfoService logininfoservice;
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONResult login(String username,String password,HttpServletRequest request) {
		JSONResult result=new JSONResult();
		String ip = request.getRemoteAddr();
		Logininfo login = this.logininfoservice.login(username, password, ip, Logininfo.USER_MANAGER);
		if(login!=null) {
			result.setSuccess(true);
			result.setMsg("登录成功");
			UserContext.putCurrent(login);
		}else{
			result.setSuccess(true);
			result.setMsg("用户名或者密码错误");
		}
		return result;
	}

	/*
	 * 后台的首页
	 */
	@RequestMapping("index")
	
	public String index() {
		return "main";
	}
}
