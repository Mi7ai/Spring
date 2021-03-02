package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoginAspect {
	 
	@Pointcut("execution(* dao.*.*(..))")
	private void login() {
		
	}
	
//	this uses the declaration defines in login method
	@Before("login()")
	public void beforeLoginAspect() {
		System.out.println("Login aspect 1: before addAcount");
	}
	
	@Before("login()")
	public void apiAnalytics() {
		System.out.println("Calling API Analytics 1");
	}
	
	

}
