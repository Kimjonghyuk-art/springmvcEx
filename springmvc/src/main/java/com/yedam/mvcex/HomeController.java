package com.yedam.mvcex;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.mvcex.emp.EmpMapper;
import com.yedam.mvcex.emp.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller //POJO . @Component상속, 빈등록, servlet 호출할 수 있도록 command화 시켜줌 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//여러개 설정 가능
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	@RequestMapping("/ajax")
//	@ResponseBody
//	public EmpVO ajax(EmpVO vo) {
//		vo.setFirst_name("hong");
//		vo.setLast_name("gildong");
//		return vo;
//	}
	
	
}
