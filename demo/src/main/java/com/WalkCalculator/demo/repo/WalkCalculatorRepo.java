package com.WalkCalculator.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WalkCalculator.demo.entity.WalkDetail;

@Repository
public interface WalkCalculatorRepo extends JpaRepository<WalkDetail, Integer>{
	
	public List<WalkDetail> findByPersonId(int personId);

}
