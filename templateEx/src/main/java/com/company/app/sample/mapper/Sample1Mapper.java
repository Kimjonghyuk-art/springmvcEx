package com.company.app.sample.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {

	@Insert("INSERT INTO tbl_sample1 (col1) VALUES (#{data})")
	public int insert(String data);
	
}
