package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//this code runs either of succes or failure of method
@Aspect
@Component
public class AfterFinallyAspect {
	@After("execution(* aopdemo..*.findAccounts(..))")
	public void afterFinallyFindAccountsAspect(JoinPoint theJP) {
		String method = theJP.getSignature().toShortString();
		
		System.out.println("Executing @AfterFinally on method: "+method);
		
 
	}
	
	@AfterThrowing(pointcut = ("aopdemo.aspect.AopExpressions.findAccounts()"),throwing = "ex")
	public void afterThrowingFindAccountsAspect(JoinPoint theJP, Throwable ex) {
		String method = theJP.getSignature().toShortString();
		
		System.out.println("Executing @AfterThrowing on method: "+method);
		
		System.out.println("Exception is: "+ex);
	}
}
