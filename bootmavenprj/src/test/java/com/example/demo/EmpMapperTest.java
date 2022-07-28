package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {

	
	@Autowired EmpMapper mapper;
	
	@Test
	public void getEmp() {
		System.out.println(mapper.getEmpList(null));
	}
}
