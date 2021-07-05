package chap03;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListService {
	@Autowired
	@Qualifier("dao")
	private MemberDao memberDao;
	
//	public MemberListService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	public Map<String, Member> selectList() {
		return memberDao.selectList();
	}
	
}
