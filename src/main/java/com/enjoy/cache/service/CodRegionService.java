package com.enjoy.cache.service;

import java.util.List;

import com.enjoy.domain.CodRegion;

/**
 * 
 * @author myPC
       接口方法，根据upcode查，根据codecha
 */

public interface CodRegionService {
	
	public List<CodRegion> getByUpCode(int upcode);
	
	public CodRegion getByCode(int code);
	
	

}
