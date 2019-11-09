package com.enjoy.cache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoy.cache.service.CodRegionService;
import com.enjoy.dao.CodRegionDao;
import com.enjoy.domain.CodRegion;
//—原始实现
@Service("CodRegionService01")
public class CodRegionServiceImpl01 implements CodRegionService {
	
	@Autowired
	private CodRegionDao codRegionDao;

	@Override
	public List<CodRegion> getByUpCode(int upcode) {
		
		System.out.println("查询数据库。。。。。。"+System.currentTimeMillis());
		List<CodRegion> codRegionList = this.codRegionDao.findRegionByUpcode(upcode);
		return codRegionList;
	}

	@Override
	public CodRegion getByCode(int code) {
		System.out.println("查询数据库。。。。。。"+System.currentTimeMillis());
		CodRegion region = this.codRegionDao.findReionByCode(code);
		return region;
	}

}
