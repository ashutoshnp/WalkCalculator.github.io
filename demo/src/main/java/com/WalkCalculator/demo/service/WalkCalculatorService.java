package com.WalkCalculator.demo.service;

import com.WalkCalculator.demo.entity.PersonInfoDto;
import com.WalkCalculator.demo.entity.WalkDetailDto;

public interface WalkCalculatorService {

	public long saveWalkDetail(WalkDetailDto walkDto);
	
	public int getPersonwalkDetail(PersonInfoDto infoDto);

}
