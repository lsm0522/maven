package chap05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeAspect {
	                 // public인 타입 상관X chap05의 (하위포함)모든 클래스의 모든 메서드
	@Pointcut("execution(public * chap05..*(..))") //실제 Advice가 적용되는 부분
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		System.out.println("메서드 실행전");
		try {
			Object result = joinPoint.proceed();//proceed 호출이 되는 전후를 봐야함 이 부분은 spring이 알아서 함?
			return result;
		}finally {
			System.out.println("메서드 실행끝");
			long end = System.nanoTime();
			System.out.println("AOP: " + (end-start));
		}
	}
}
