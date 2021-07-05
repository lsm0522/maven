package chap08;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MemberService {
	List<MemberVo> selectList();
	MemberVo login(MemberVo vo);
	//MemberVo mypage(int mno);
	String mypage(Model model, HttpSession sess);
	int update(MemberVo vo);
}
