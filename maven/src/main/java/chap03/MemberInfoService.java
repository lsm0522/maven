package chap03;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoService {
	@Autowired
	@Qualifier("dao")
	private MemberDao memberDao;
	
//	public MemberInfoService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	public Member selectOne(String email){
		return memberDao.selectByEmail(email);
	}
	
}
