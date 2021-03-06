package chap09;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVo> selectList() {
		return sqlSessionTemplate.selectList("member.selectList"); //매개변수 첫번째는 위치, 두번째는 파라미터 타입
		                         //selectList selectOne insert update delete
	}
	public MemberVo login(MemberVo vo) {
		return sqlSessionTemplate.selectOne("member.login", vo);
	}
	
	public MemberVo selectOne(int mno) {
		return sqlSessionTemplate.selectOne("member.selectOne", mno);
	}
	public int update(MemberVo vo) {
		return sqlSessionTemplate.update("member.update",vo);
	}
	
	public int insert(MemberVo vo) {
		return sqlSessionTemplate.insert("member.insert",vo);
	}
	
	public int insertSchool(Map map) {
		return sqlSessionTemplate.insert("member.insertSchool",map);
	}
	
}
