package pro07.sec01.ex02;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "gon";
	private static final String pwd = "1234";
	private PreparedStatement pstmt;
	private Connection con;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("oracle 드라이버 로딩 성공!");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connect !");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
