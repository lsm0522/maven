package chap02;

import java.time.LocalDateTime;
import java.util.List;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail()); //받아온 이메일이 맵 객체에 들어 있으면 중복
		if(member != null) {
			throw new DuplicateMemberException("이메일 중복:" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(),LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
	
}
