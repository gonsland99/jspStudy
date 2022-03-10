package ch7;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	/*
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "gon";
	private static final String pwd = "1234";
	*/
	private Statement stmt;
//	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println(query);
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
//			pstmt = con.prepareStatement(query);
//			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
//			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connect 성공");
			stmt = con.createStatement();
			System.out.println("statement create 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
