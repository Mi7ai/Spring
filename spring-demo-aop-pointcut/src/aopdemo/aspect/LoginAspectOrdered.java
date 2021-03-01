package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LoginAspectOrdered {
	
	@Before("aopdemo.aspect.AopExpressions.login()")
	public void beforeLoginAspect() {
		System.out.println("Login aspect 3: ordered");
	}
}
