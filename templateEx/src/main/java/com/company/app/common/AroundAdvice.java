package com.company.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice { //어라운드는 실행전, 후 모두 실행

	@Around("LogAdvice.allpointcut()")
	public Object afterLog(ProceedingJoinPoint pjp) { //다음 After 로그에 값을 넘겨줘야 함
		Object obj = null;
		
		try {
			System.out.println("----[Around] 로그 ----");	
			//서비스 실행 전
			long startTime = System.currentTimeMillis();
			//서비스 메서드 실행
			obj = pjp.proceed();
			
			//서비스 실행후
			long endTime = System.currentTimeMillis();
			System.out.println("경과시간 "+(endTime-startTime));
			System.out.println("----[Around] 로그 ----");
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		return obj;
		
	}
	
	
}
