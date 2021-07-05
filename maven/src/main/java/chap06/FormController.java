package chap06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //Component로 써도 무방, 하지만 역할을 구분하기 위해 이렇게 사용
//@RequestMapping("/member") //이렇게 사용하면 member하위의 메서드들이 실행
public class FormController {
	
//	@RequestMapping("/index.do")
//	public String index() {
//		return "index";
//	}
	//리턴이 없으면 매핑된 url과 동일한 경로 jsp를 포워딩
	//서블릿으로 응답 가능
	@RequestMapping("/test.do")
	public void test(HttpServletResponse res) throws IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<script>alert('정상적으로 저장되었습니다');</script>");
		
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:index.do"; //index.do로 새로운 요청이 일어남 (다른 요청이라 이해)
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "form"; //화면에 jsp만 출력되도록 포워딩
	}
	@RequestMapping("/send.do")
	public String send(Model model, HttpServletRequest req, @RequestParam(value="name", required = false) String name2, @RequestParam(value="email", required = false) String email2,@RequestParam(value="no", required = false, defaultValue = "0") int no, MemberVo vo) {
		//파라미터를 받는 방법
		// 1. HttpServletRequest
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		//2. @RequestParam
		//	 @RequestParam("파라미터명"): 매개변수에 지정
		//3. 커맨드 객체
		
		System.out.println(vo.getHobby().length);
		for (int v : vo.getHobby()) {
			System.out.println(v);
		}
		
		model.addAttribute("name1", name);
		model.addAttribute("email1", email);
		model.addAttribute("name2", name);
		model.addAttribute("email2", email);
		model.addAttribute("no", no);
		model.addAttribute("vo", vo);
		
		req.setAttribute("id", "hong");
		
		if(email == null || "".equals(email)) {
			return "form"; //포워딩된 jsp가 변경되는 것, send.do에서도 form.do가 화면에 출력되는 이유
		}
		return "send";
	}
	//ModelAndView 객체 리턴
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "홍길동");
		mav.setViewName("main");
		return mav;
	}

}
