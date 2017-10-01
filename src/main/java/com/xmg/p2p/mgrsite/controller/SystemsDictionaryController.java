package com.xmg.p2p.mgrsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.SystemDictionary;
import com.xmg.p2p.base.domain.SystemDictionaryItem;
import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.base.query.SystemDictionaryQueryObject;
import com.xmg.p2p.base.service.ISystemDictionaryService;
import com.xmg.p2p.base.util.JSONResult;
/*
 * 数据字典
 */
@Controller
public class SystemsDictionaryController {
	
	@Autowired
	private ISystemDictionaryService systemDictionaryService;
	

	
	@RequestMapping("/systemDictionary_list")
	public String systemDictionaryList(@ModelAttribute("qo") SystemDictionaryQueryObject qo,
								Model model) {
		PageResult pageResult = this.systemDictionaryService.queryDics(qo);
		model.addAttribute("pageResult", pageResult);
		return "systemdic/systemDictionary_list";
	}
	
	@RequestMapping("/systemDictionary_update")
	@ResponseBody
	public JSONResult saveOrUpdate(SystemDictionary sd) {
		JSONResult result=new JSONResult();
		try {
			this.systemDictionaryService.saveOrUpdate(sd);
			result.setMsg("保存成功");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg("保存或者更新失败");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 数据字典明细
	 */
	@RequestMapping("/systemDictionaryItem_list")
	public String systemDictionaryItems(
				@ModelAttribute("qo")SystemDictionaryQueryObject qo,Model model) {
		model.addAttribute("pageResult", this.systemDictionaryService.queryItems(qo));
		model.addAttribute("systemDictionaryGroups", this.systemDictionaryService.listDis());
		return"systemdic/systemDictionaryItem_list";
	}
	
	

	@RequestMapping("/systemDictionaryItem_update")
	@ResponseBody
	public JSONResult saveOrUpdateItems(SystemDictionaryItem systemDictionaryItem) {
		JSONResult result=new JSONResult();
		try {
			this.systemDictionaryService.saveOrUpdateItems(systemDictionaryItem);
			result.setMsg("保存成功");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg("保存或者更新失败");
			e.printStackTrace();
		}
		return result;
	}
	
}
