package com.enjoy.dao;

import java.util.List;

import com.enjoy.domain.CodRegion;

public interface CodRegionDao {
	
	public List<CodRegion> findRegionByUpcode(int upcode);

	public CodRegion findReionByCode(int upcode);

}
