package com.enjoy.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.enjoy.dao.CodRegionDao;
import com.enjoy.domain.CodRegion;
import com.enjoy.utils.JedisUtils;

@Controller
@RequestMapping(value="/")
public class IndexController {
	
	@Autowired
	private CodRegionDao codRegionDao;
	
	@ResponseBody
	@RequestMapping("/upcode")
	public List<CodRegion> getCodRegion(@RequestParam("upcode")int upcode) {
		
		String JEDIS_KEY = "com.enjoy.utils.upcode:"+upcode;
		
		//去redis中查询是否有数据
		JedisUtils jedis = new JedisUtils();
		String json = jedis.get(JEDIS_KEY);
		if(json == null || json.equals("")) {
			List<CodRegion> list = codRegionDao.findRegionByUpcode(upcode);
			System.out.println("从数据库中查询数据");
			json = JSON.toJSONString(list);
			jedis.set(JEDIS_KEY, json);
			System.out.println(json);
		}else {
			System.out.println("从缓存查询数据");
		}
		
		jedis.sadd("123",new String[]{"1","2","3"});
		Set<String> set = jedis.sdiff("123");
		Set<String> set2 = jedis.smembers("123");
		System.out.println(set2);
		
		
		List<CodRegion> list = JSON.parseArray(json, CodRegion.class);
		System.out.println(list);
		return list;
		
	}
	
	
	@ResponseBody
	@RequestMapping("/code")
	public CodRegion getCodRegionbyCode(@RequestParam("code")int code) {
		
		String JEDIS_KEY = "com.enjoy.utils.code:"+code;
		
		//去redis中查询是否有数据
		JedisUtils jedis = new JedisUtils();
		String json = jedis.get(JEDIS_KEY);
		if(json == null || json.equals("")) {
			CodRegion reion = codRegionDao.findReionByCode(code);
			System.out.println("从数据库中查询数据");
			json = JSON.toJSONString(reion);
			jedis.set(JEDIS_KEY, json);
			System.out.println(json);
		}else {
			System.out.println("从缓存查询数据");
		}
		
		jedis.sadd("123",new String[]{"1","2","3"});
		Set<String> set = jedis.sdiff("123");
		Set<String> set2 = jedis.smembers("123");
		System.out.println(set2);
		CodRegion region = JSON.parseObject(json, CodRegion.class);
		
		System.out.println(region);
		return region;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired
	private RedisTemplate<String,Object> temp;
	
	
	@RequestMapping("/temp")
	@ResponseBody
	public String useRedisTemplate(@RequestParam("upcode")int upcode) {
		
		String TEMP_KEY = "com.enjoy.utils.upcode:"+upcode;
		
		String str = (String) temp.opsForValue().get(TEMP_KEY);
		
		if(str == null) {
			List<CodRegion> list = codRegionDao.findRegionByUpcode(upcode);
			System.out.println("从数据库中查询数据");
			str = JSON.toJSONString(list);
			temp.opsForValue().set(TEMP_KEY, str);
		}else {
			System.out.println("查缓存数据");
		}
		return str;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
