package com.newlecture.jspprj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspprj.dao.NoticeFileDao;
import com.newlecture.jspprj.model.NoticeFile;

public class JdbcNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
		
		String sql="SELECT * NoticeFiles WHERE NoticeCode = ?";
		
		String url="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeCode);
		
			ResultSet rs = st.executeQuery();
			
			List<NoticeFile> list = new ArrayList<NoticeFile>();
			
			while(rs.next()){

			NoticeFile n = new NoticeFile();
			
			n.setCode(rs.getString("code"));
			n.setSrc(rs.getString("src"));
			n.setRegdate(rs.getDate("regdate"));
			n.setDescription(rs.getString("description"));
			n.setNoticeCode("noticeCode");
			
			list.add(n);
			}
			
			rs.close();
			st.close();
			con.close();

			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int instert(NoticeFile file) {
		String sqlCode ="SELECT ISNULL(MAX(CAST(CODE AS INT)),0) CODE FROM NOTICES";
		String sql = "INSERT INTO NOTICEFILES(Code,Src,RegDate,Description,NoticeCode) VALUES(?,?,getDate(),?,?)";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection con;

		con = DriverManager.getConnection(url, "sist", "newlec");
		
		Statement stCode = con.createStatement();
		ResultSet rs = stCode.executeQuery(sqlCode);
		
		rs.next();
		
		String code = rs.getString("CODE");
		
		stCode.close();
		rs.close();
		
		PreparedStatement st = con.prepareStatement(sql); //value 자리에 미리 ?를 넣어두고 후에 값을 집어 넣을수 있음
		st.setString(1, code);
		st.setString(2, file.getSrc());
		st.setString(3, file.getDescription());
		st.setString(4, file.getNoticeCode());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}


}
