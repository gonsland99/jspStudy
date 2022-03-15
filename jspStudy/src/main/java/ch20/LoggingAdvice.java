package ch20;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("method 호출 전: LogginAdvice");
		System.out.println(invocation.getMethod() + "method 호출 전");

		Object object = invocation.proceed();

		System.out.println("method 호출 후: loggingAdvice");
		System.out.println(invocation.getMethod() + "method 호출 후");
		return object;
	}
}
