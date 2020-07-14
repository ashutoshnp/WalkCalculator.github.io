package com.WalkCalculator.demo.service;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WalkCalculator.demo.entity.PersonInfoDto;
import com.WalkCalculator.demo.entity.WalkDetail;
import com.WalkCalculator.demo.entity.WalkDetailDto;
import com.WalkCalculator.demo.repo.WalkCalculatorRepo;

@Service
public class WalkCalculatorServiceImpl implements WalkCalculatorService{

	@Autowired
	WalkCalculatorRepo repo;
	
	
	//Mtehod  to save walking related details
	@Override
	public long saveWalkDetail(WalkDetailDto walkDto) {
		try {
		Date date1=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(walkDto.getDateTime());  
		Timestamp sqlDate=new Timestamp(date1.getTime());  
	
		WalkDetail ob=new WalkDetail();
		ob.setDatetime(sqlDate);
		ob.setDistance(walkDto.getDistance());
		ob.setPersonId(walkDto.getPersonId());
		
		return repo.save(ob).getId();
		
		}catch (Exception e) {
			// TODO: handle exception
			//Exception will be handeled here
		}
		return 0;
	}

	//method to create 
	@Override
	public int getPersonwalkDetail(PersonInfoDto infoDto) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy hh:mm:ss");
		try {
			Date parsedDate = dateFormat.parse(infoDto.getFromDate());
			Date parsedDate1 = dateFormat.parse(infoDto.getToDate());

			Timestamp fromDate = new java.sql.Timestamp(parsedDate.getTime());
			Timestamp toDate = new java.sql.Timestamp(parsedDate1.getTime());

			List<WalkDetail> objList = repo.findByPersonId(infoDto.getId());
			int coveredDistance = 0;
			for (WalkDetail wd : objList) {
				int from = fromDate.compareTo(wd.getDatetime());
				int to = toDate.compareTo(wd.getDatetime());
				
				//comparing the from and to date with stored dat timestamp
				if (from < 0 && to > 0 || from ==0 || to==0) {
					coveredDistance = coveredDistance + wd.getDistance();
				}
			}
			return coveredDistance;
		
		} catch (Exception ex) {
			// here we can handle the exceptions
		}
		return 0;
	}
}