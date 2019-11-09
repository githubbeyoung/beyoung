package com.enjoy.cache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.enjoy.cache.service.CodRegionService;
import com.enjoy.dao.CodRegionDao;
import com.enjoy.domain.CodRegion;
//—springCache优雅实现缓存
@Service("CodRegionService02")
public class CodRegionServiceImpl02 implements CodRegionService {
	
	@Autowired
	private CodRegionDao codRegionDao;

	@Override
	@Cacheable(value="CodRegionService02")//—指定使用哪个缓存器
	public List<CodRegion> getByUpCode(int upcode) {
		
		System.out.println("查询数据库。。。。。。"+System.currentTimeMillis());
		List<CodRegion> codRegionList = this.codRegionDao.findRegionByUpcode(upcode);
		return codRegionList;
	}

	@Override
	@Cacheable(value="CodRegionService02")
	public CodRegion getByCode(int code) {
		System.out.println("查询数据库。。。。。。"+System.currentTimeMillis());
		CodRegion region = this.codRegionDao.findReionByCode(code);
		return region;
	}

}
