package aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//this code runs either of succes or failure of method
@Aspect
@Component
public class AroundAspect {
	@Around("execution(* aopdemo.service.*.getFortune(..))")
	public Object aroundAspect(ProceedingJoinPoint theJP) throws Throwable {
		String method = theJP.getSignature().toShortString();
		
		System.out.println("Executing @Around on method: "+method);
		
		long start = System.currentTimeMillis();
		Object result = null;
		
		try {
			result = theJP.proceed();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000.0);
		
		return result;
	}
	
	 
}
