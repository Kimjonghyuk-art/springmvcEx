package com.example.demo.emp.mapper;

import java.util.List;

import com.example.demo.emp.vo.DepartmentVO;
import com.example.demo.emp.vo.EmpReqVO;
import com.example.demo.emp.vo.EmpVO;
import com.example.demo.emp.vo.JobVO;

public interface EmpMapper {
	EmpVO getEmp(String employeeId);

	List<EmpVO> getEmpList(EmpReqVO vo);

	int empInsert(EmpVO vo);

	int empUpdate(EmpVO vo);

	void empDelete(String employeeId);
	
	List<DepartmentVO> getDepartments();
	
	List<JobVO> getJobs();
}
