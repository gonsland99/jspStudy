package ch17_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch17_1.MemberVO;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> membersList = new ArrayList<>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO(id,pwd,name,email,joinDate);
				membersList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return membersList;
	}
	
	public void addMember(MemberVO m) {
		try {
			con = dataFactory.getConnection();
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			Date joinDate = m.getJoinDate();
			
			String query = "insert into t_member(id,pwd,name,email) values(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeQuery();
			pstmt.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
