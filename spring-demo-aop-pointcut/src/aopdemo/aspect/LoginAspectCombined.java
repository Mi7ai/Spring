package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoginAspectCombined {
	 
	@Pointcut("execution(* aopdemo..*.*(..))")
	private void login() {}
	
	@Pointcut("execution(* aopdemo..*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* aopdemo..*.set*(..))")
	private void setter() {}
	
	@Pointcut("login() && !(getter() || setter())")
	private void noGetterSetter() {}
	
	@Before("noGetterSetter()")
	public void beforeLoginAspect() {
		System.out.println("Login aspect 2");
	}

}
