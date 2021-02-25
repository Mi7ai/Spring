package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	@Before("execution(public void addAccount())")
	public void beforeLoginAspect() {
		System.out.println("Fuck you from login aspect before addAcount");
	}

}
