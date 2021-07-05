package aop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy; //어노테이션 Aspect연결

import chap05.Calculator;
import chap05.ExeAspect;
import chap05.ImplCalculator;

@Configuration //설정파일
@EnableAspectJAutoProxy
public class AppCtx {
	@Bean
	public ExeAspect exeAspect() {
		return new ExeAspect();
	}
	@Bean
	public Calculator calculator() {
		return new ImplCalculator();
	}

}
