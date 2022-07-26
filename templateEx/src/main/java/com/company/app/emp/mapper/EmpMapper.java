package com.company.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpVO;

public interface EmpMapper {
	EmpVO getEmp(EmpVO vo);

	List<EmpVO> getEmpList(EmpReqVO vo);

	int empInsert(EmpVO vo);

	int empUpdate(EmpVO vo);

	void empDelete(String employeeId);
}
