package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.vo.DepartmentVO;
import com.example.demo.emp.vo.EmpVO;
import com.example.demo.emp.vo.JobVO;

@Controller
public class EmpController {

	@Autowired EmpMapper mapper;
	
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList(null));
		return "empList";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("str1","<u>유태그유태그</u>");
		return "test";
	}
	
	
	//등록페이지이동
	@GetMapping("/insertemp")
	public String insertemp(Model model) {
		return "insertemp";
	}
	
	@ModelAttribute("jobs")
	public List<JobVO> getJobs() {
		return mapper.getJobs();
	}
	
	@ModelAttribute("depts")
	public List<DepartmentVO> getdepartment() {
		return mapper.getDepartments();	
	}
	//등록 실행
	@PostMapping("/insertemp")
	public String insertempProc(Model model,EmpVO vo) {
		mapper.empInsert(vo);
		return "redirect:empList";
	}
	
	//수정페이지
	@GetMapping("/empupdate")
	public String empUpdateform(Model model, @RequestParam String employeeId) {
		model.addAttribute("emp",mapper.getEmp(employeeId));
		return "empupdate";
	}
	
	//수정 실행
	@PostMapping("/empupdate")
	public String empUpdateproc(EmpVO vo) {
		mapper.empUpdate(vo);
		return "redirect:empList";
	}
	
}
