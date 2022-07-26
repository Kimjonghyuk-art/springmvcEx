package com.company.app.emp.service;

import java.util.List;

public interface EmpService {
	EmpVO getEmp(EmpVO vo);

	List<EmpVO> getEmpList(EmpReqVO vo);

	int empInsert(EmpVO vo);

	int empUpdate(EmpVO vo);

	void empDelete(String employeeId);
}
