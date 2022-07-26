package com.company.app.emp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;


@Controller
public class EmpController {
	
private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

@Autowired EmpService service;
	
	//단건 조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model) {
		logger.info("파라미터 >>"+vo.toString());
		model.addAttribute("emp", service.getEmp(vo));
		
		return "emp/emp";
	}
	
	//목록
	@RequestMapping("/empList")
	public String getempList(EmpReqVO vo,Model model) {
		model.addAttribute("empList", service.getEmpList(vo));
		
		return "emp/empList";
	}
	
	//등록페이지 이동 //겟일떄 실행
	@RequestMapping("/empInsert")
	public String empInsert() {
		
		return "emp/empInsert";
	}
	
	//등록 처리 //포스트방식 요청일 떄 실행
	//@RequestMapping(value = "/empInsert", method = RequestMethod.POST )
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug("form으로 받은 데이터 >> " + vo.toString());
		
		System.out.println(vo);
		service.empInsert(vo);
		System.out.println(vo.getEmployeeId() + "사번 등록");
		return "redirect:empList";
	}
	
	
	//수정페이지 이동
	@RequestMapping("/empupdate/{employeeId}")
	public String empUpdateForm(Model model, EmpVO vo,
								@PathVariable String employeeId) {
		vo.setEmployeeId(employeeId);
		model.addAttribute("emp", service.getEmp(vo));
		return "emp/empupdate";
	};

	//수정처리
	@PostMapping("/empupdate")
	public String empUpdateProc(EmpVO vo) {
		service.empUpdate(vo);
		return "redirect:empList";
	};
	
	
	//삭제처리
	
	@GetMapping("/empDelete")
	public String empDeleteProc(String employeeId) {
		service.empDelete(employeeId);
		return "redirect:empList";
	}
	
	
	
}
