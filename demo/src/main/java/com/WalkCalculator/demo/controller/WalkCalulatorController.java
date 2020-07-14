package com.WalkCalculator.demo.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.WalkCalculator.demo.entity.PersonInfoDto;
import com.WalkCalculator.demo.entity.WalkDetailDto;
import com.WalkCalculator.demo.service.WalkCalculatorService;

@RestController
@RequestMapping("")
public class WalkCalulatorController {

	@Autowired
	public WalkCalculatorService walkService;
	
	@PostMapping(path="/saveDetail")
	public String saveTraveledDistance(@RequestBody WalkDetailDto walkDto, HttpServletResponse response ){
		
		System.out.println("walked distance: " + walkDto.getDistance());
		
		long id = walkService.saveWalkDetail(walkDto);
		if(id>0)
		{
			return "saved successfully";
		}
		return "exception occured";
		
	}
	
	@GetMapping(path="/PersonDetail")
	public int getPersonDetail(@RequestBody PersonInfoDto infoDto)
	{		
		System.out.println(""+infoDto.getId() );
		return walkService.getPersonwalkDetail(infoDto);
		 
		
	}
}
