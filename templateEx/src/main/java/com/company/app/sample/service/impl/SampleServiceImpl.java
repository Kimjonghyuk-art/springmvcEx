package com.company.app.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.mapper.Sample1Mapper;
import com.company.app.sample.mapper.Sample2Mapper;
import com.company.app.sample.service.SampleService;
@Service
public class SampleServiceImpl implements SampleService{

	@Autowired 
	Sample1Mapper s1mapper;
	@Autowired 
	Sample2Mapper s2mapper;
	
	@Override
	//@Transactional // 트랜잭션 처리
	public void insert(String data) {
		s1mapper.insert(data);
		s2mapper.insert(data);
		
	}

}
