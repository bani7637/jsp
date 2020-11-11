package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);
	
	// pointCut 설정을 위한 의미없는 메소드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
		// signature()-> 함수의 대한 이름이나, 접근제어자를 알 수 있음
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("beforeMethod 메서드 이름 : {}", methodName);
		logger.debug("beforeMethod 클래스 이름 : {}", className);
	}
	
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint p_JoinPoint) throws Throwable {
		// 메소드 실행 전 공통 관심사항
		long start = System.currentTimeMillis();
		
		// 메소드
		Object obj = p_JoinPoint.proceed(p_JoinPoint.getArgs());
		
		// 메소드 실행 후 공통 관심사항 
		long end = System.currentTimeMillis();
		String t1 = p_JoinPoint.getSignature().getDeclaringTypeName();
		String t2 = p_JoinPoint.getSignature().getName();
		
		logger.debug("aroundMethod : {}{}->{}",t1,t2, end-start+"ms");
		return obj;
	}
}
