package pro22.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MemberService {
	public List listMembers() throws DataAccessException;
}
