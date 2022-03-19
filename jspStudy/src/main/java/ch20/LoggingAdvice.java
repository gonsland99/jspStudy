package ch20;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("전 로깅 : LogginAdvice");
		System.out.println(invocation.getMethod() + "전 로깅");

		Object object = invocation.proceed();

		System.out.println("후 로깅: loggingAdvice");
		System.out.println(invocation.getMethod() + "후 로깅");
		return object;
	}
}
