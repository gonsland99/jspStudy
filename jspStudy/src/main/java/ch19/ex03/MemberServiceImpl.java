package ch19.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	//member.xml의 memberDAO id의 데이터를 주입
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}
