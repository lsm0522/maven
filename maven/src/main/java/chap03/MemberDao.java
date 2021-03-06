package chap03;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	public void insert(Member member) {
		member.setId(++nextId); //고유번호인 아이디를 1 증가시킴
		map.put(member.getEmail(), member);
	}
	public void update(Member member ) {
		map.put(member.getEmail(), member);
	}
	public Map<String, Member> selectList() {
		return map;
	}
}
