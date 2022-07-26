package com.company.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;
@Service //component-scan 등록 해줘야함
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper mapper;
	
	@Override
	public EmpVO getEmp(EmpVO vo) {
		return mapper.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpReqVO vo) {
		return mapper.getEmpList(vo);
	}

	@Override
	public int empInsert(EmpVO vo) {
		return mapper.empInsert(vo);
	}

	@Override
	public int empUpdate(EmpVO vo) {
		return mapper.empUpdate(vo);
	}

	@Override
	public void empDelete(String employeeId) {
		mapper.empDelete(employeeId);
	}

}
