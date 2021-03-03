package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAspectOrdered {
	
	@Before("aopdemo.aspect.AopExpressions.login()")
	public void beforeLoginAspect() {
		System.out.println("Calling API Analytics 3");
	}
}
