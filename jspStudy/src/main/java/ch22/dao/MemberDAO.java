package ch22.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ch22.vo.MemberVO;


public interface MemberDAO {
	public List selectAllMembers() throws DataAccessException ;
	public int addMember(MemberVO memberVO) throws DataAccessException ;

}
