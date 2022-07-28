package com.example.demo.emp.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class EmpReqVO {
	
	private String employeeId;
	private String[] depts;
	private String jobId;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date sdt;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date edt;
	
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date hireDate;
	private String salary;
	private String departmentId;

}
