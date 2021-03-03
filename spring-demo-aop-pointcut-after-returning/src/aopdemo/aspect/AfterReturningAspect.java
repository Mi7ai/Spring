package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import aopdemo.Account;

@Aspect
@Component
public class AfterReturningAspect {
	
	@AfterReturning(pointcut = ("aopdemo.aspect.AopExpressions.findAccounts()"),returning = "result")
	public void afterFindAccountsAspect(JoinPoint theJP, List<Account> result) {
		String method = theJP.getSignature().toShortString();
		
		System.out.println("Executing after returning method: "+method);

		System.out.println("Result is: "+result);
		
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
		System.out.println("Result is: "+result);
	}
}
