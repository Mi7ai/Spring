package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
//	matches all classes that have addAccount method
//	@Before("execution(public void addAccount())")
	
//	matches only the package with specific class
	/*
	@Before("execution(public void dao.AccountDAO.addAccount())")
	public void beforeLoginAspect() {
		System.out.println("Fuck you from login aspect before addAcount");
	}*/
	
//	matches any method that starts with add in any class
	/*
	@Before("execution(public void add*())")
	public void beforeLoginAspect() {
		System.out.println("Fuck you from login aspect before addAcount");
	}*/
	
//	matches any method that starts with add in any class with return type *(any)
	@Before("execution(* add*())")
	public void beforeLoginAspect() {
		System.out.println("Fuck you from login aspect before addAcount");
	}

}
