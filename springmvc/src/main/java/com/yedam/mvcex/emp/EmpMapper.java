package com.yedam.mvcex.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	EmpVO getEmp(EmpVO vo);

	List<EmpVO> getEmpList(EmpReqVO vo);

	int empInsert(EmpVO vo);

	int empUpdate(EmpVO vo);

	void empDelete(String employeeId);
}
