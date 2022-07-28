package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	//모든 Impl로 끝나는 메소드 안의 모든 파라미터값들 읽음
	@Pointcut("execution(* com.company.app..*Impl.*(..))")
	public void allpointcut() {
		
	}
	
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) { //JoinPoint -> 실행되는 메소드
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs(); //파라미터 값들은 배열로 담김
		System.out.println("-----------[before] 로그-----------");
		if(args.length > 0) {
			System.out.println("메소드=> " + name);
			for(int i = 0; i < args.length; i++) {
				System.out.println("파라미터=> "+args[i].toString());				
			}
		}
		System.out.println("-----------[before] 로그-----------");
		
		
	}
	
}
