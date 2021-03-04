package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterThrowingAspect {
	@AfterThrowing(pointcut = ("aopdemo.aspect.AopExpressions.findAccounts()"),throwing = "ex")
	public void afterThrowingFindAccountsAspect(JoinPoint theJP, Throwable ex) {
		String method = theJP.getSignature().toShortString();
		
		System.out.println("Executing @AfterThrowing on method: "+method);
		
		System.out.println("Exception is: "+ex);
	}
	
}
