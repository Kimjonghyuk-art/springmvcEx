package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {
	
	//Returning은 정상실행 시 작동
	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning = "ret")
	public void afterLog(JoinPoint jp, Object ret) {
		System.out.println("-----------[After] 로그-----------");
		System.out.println(ret);
		System.out.println("-----------[After] 로그-----------");
		
	}
	
}
