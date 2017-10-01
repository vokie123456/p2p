package com.xmg.p2p.mgrsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmg.p2p.base.query.IplogQuery;
import com.xmg.p2p.base.service.IplogService;

@Controller
public class IplogController {

	@Autowired
	private IplogService iplogService;
	
	@RequestMapping("/ipLog")
	public String iplog(@ModelAttribute("qo")IplogQuery qo,Model model) {
		model.addAttribute("pageResult", this.iplogService.query(qo));
		return "ipLog/list";
	}
}
