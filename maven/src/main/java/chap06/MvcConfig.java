package chap06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"chap06"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
		conf.enable();
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg) {
		//(jsp가 있는 경로[시작경로],확장자) ex) return "member/MemberList" --> 경로 /WEB-INF/view/member/MemberList.jsp
		reg.jsp("/WEB-INF/view/", ".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		//비지니스로직이 필요없는(디자인만 있는 페이지, 굳이 컨트롤러 만들 필요X) url과 jsp 매핑
		reg.addViewController("/index.do").setViewName("index"); //index.do로 요청이 들어오면 /WEB-INF/view/index.jsp로 연결 (메서드 체이닝)
	}
}
