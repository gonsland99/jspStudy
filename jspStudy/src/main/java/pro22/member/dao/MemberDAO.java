package pro22.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pro22.member.vo.MemberVO;


public interface MemberDAO {
	public List selectAllMembers() throws DataAccessException ;
	public int addMember(MemberVO memberVO) throws DataAccessException ;

}
