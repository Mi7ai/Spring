package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	@Pointcut("execution(* com.demo.aspect..*.*(..))")
	public void login() {}
	
	@Pointcut("execution(* com.demo.service..*.*(..))")
	public void loginService() {}
	
	@Pointcut("execution(* com.demo.dao..*.*(..))")
	public void loginDao() {}
	 
	@Pointcut("login() || loginService() || loginDao()")
	public void loginAll() {}
	
	@Before("loginAll()")
	public void beforeLogin(JoinPoint theJP) {
		String method = theJP.getSignature().toShortString();
		System.out.println("Executing @Before on method: "+method);
		
		Object[] args = theJP.getArgs();
		
		for (Object arg : args) {
			System.out.println("Argument: " +arg);
		}
	}
	
	@AfterReturning(pointcut = "loginAll()",returning = "result")
	public void afterLogin(JoinPoint theJP, Object result) {
		String method = theJP.getSignature().toShortString();
		System.out.println("Executing @AfterReturning on method: "+method);
		
		System.out.println("Result: "+result);
	}
}
