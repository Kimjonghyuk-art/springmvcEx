package com.yedam.mvcex;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.mvcex.emp.ListReqVO;
import com.yedam.mvcex.emp.ReqVO;

@Controller
public class TestController {
	
	//parameter페이지 이동1
	@RequestMapping("/parameter")
	public String parameter() {
		//views/paramter.jsp
		return "parameter";
	}
	
	//parameter페이지 이동2
		@RequestMapping("/parameter2")
		public ModelAndView parameter2() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("parameter");
			return mv;
		}
	//parameter 페이지 이동3
		
		@RequestMapping("/parametest")
		public String parameter3(Model model) {
			model.addAttribute("param1","test");
			return "parameter";
		}
		
		
	@RequestMapping("/req1")
	public void req1(HttpServletResponse response, @RequestParam(required = false, defaultValue = "0") String id) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/req2") // List<String> or String []
	public void req1(HttpServletResponse response, @RequestParam List<String> ids) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(ids);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/req3") // List<String> or String []
	public void req1(HttpServletResponse response, @RequestParam Map<String, Object> map) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/req4") // List<String> or String []
	public void req1(HttpServletResponse response, ReqVO vo) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/req5")
	public void req1(HttpServletResponse response, ListReqVO vo) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일처리

	@RequestMapping("/req6")
	public void req1(HttpServletResponse response, ReqVO vo, @RequestPart MultipartFile[] pic) {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			// 첨부파일 업로드
			for (MultipartFile temp : pic) {
				if (temp != null && temp.getSize() > 0) {
					File file = new File("c:/upload", temp.getOriginalFilename());
					temp.transferTo(file);
					out.print(temp.getOriginalFilename() + "<br>");
					out.print(temp.getSize());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping("/req7/{id}/{age}")
	public void req1(HttpServletResponse response,
					@PathVariable String id,
					@PathVariable int age) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(id);
			out.print(age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	// String[] request.getParameterValues()

	@GetMapping("/arr")
	public void arr(@RequestParam String id, @RequestParam List<String> ids, HttpServletResponse response)
			throws IOException {
		System.out.println(id);
		System.out.println(ids);
		PrintWriter out = response.getWriter();
		out.print("<h1>" + id + "</h1>");

		out.print(ids);
	}

}
