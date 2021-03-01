package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	 
		@Pointcut("execution(* aopdemo..*.*(..))")
		public void login() {}
		
		@Pointcut("execution(* aopdemo..*.get*(..))")
		public void getter() {}
		
		@Pointcut("execution(* aopdemo..*.set*(..))")
		public void setter() {}
		
		@Pointcut("login() && !(getter() || setter())")
		public void noGetterSetter() {}
}
