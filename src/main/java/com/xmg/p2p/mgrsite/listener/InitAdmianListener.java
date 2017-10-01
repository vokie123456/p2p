package com.xmg.p2p.mgrsite.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.xmg.p2p.base.service.ILogininfoService;
/*
 * 监听spring的启动流程，在spring启动完成的时候判断是否有一个超级管理员，没有就创建一个，
 */
@Component//不好定义是那一层的时候，用Component
public class InitAdmianListener implements ApplicationListener<ContextRefreshedEvent>  {
	
	@Autowired
	private ILogininfoService logininfoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("监听spring完成初始化");
		this.logininfoService.initAdmin();
	}

}
