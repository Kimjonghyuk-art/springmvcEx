package com.company.app.emp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.emp.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*.xml")
public class EmpMapperTest {

	
	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
		
//		System.out.println("Test 매퍼 테스트 >>>>>>>>"+mapper.test());
		
	};
	
}
