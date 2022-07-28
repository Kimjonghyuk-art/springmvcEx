package com.company.app.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.service.SampleService;

import lombok.extern.log4j.Log4j;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*.xml")
@Log4j
public class SampleServiceTest {
	
	@Autowired SampleService service;
	
	@Test
	//@Transactional
	public void insert() {
		service.insert("트랜잭션 어노테이션없이 입력 ");
	}
	
}
