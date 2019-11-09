package com.enjoy.cache.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enjoy.cache.service.CodRegionService;
import com.enjoy.domain.CodRegion;

@Controller
@RequestMapping("/cache")
public class CacheController {
	
	
	
	
	//==================================第一种，不查询缓存每次都直接查询数据库=========================================================
	
	@Resource(name="CodRegionService01")
	private CodRegionService codRegionServiceImpl01;
	
	@RequestMapping("/list01")
	@ResponseBody
	public List<CodRegion> getListBy01(@RequestParam("upcode")int upcode) {
		List<CodRegion> list = codRegionServiceImpl01.getByUpCode(upcode);
		return list;
		
	}
	
	@RequestMapping("/one01")
	@ResponseBody
	public CodRegion getOneBy01(@RequestParam("code")int code) {
		CodRegion one = codRegionServiceImpl01.getByCode(code);
		return one;
	}
	
	//=======================================================================================================================
	
	
	

	
	
	//==================================第二种，使用jdk内置缓存=========================================================
	
	
	@Resource(name="CodRegionService02")
	private CodRegionService codRegionServiceImpl02;
	
	
	
	@RequestMapping("/list02")
	@ResponseBody
	public List<CodRegion> getListBy02(@RequestParam("upcode")int upcode) {
		List<CodRegion> list = codRegionServiceImpl02.getByUpCode(upcode);
		return list;
		
	}
	
	@RequestMapping("/one02")
	@ResponseBody
	public CodRegion getOneBy02(@RequestParam("code")int code) {
		CodRegion one = codRegionServiceImpl02.getByCode(code);
		return one;
	}
	
	//==================================================================================================================
	
	
	
	
	
	
	
	
	
}
