package com.newlecture.jspprj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.newlecture.jspprj.dao.MemberDao;
import com.newlecture.jspprj.model.Member;

public class JdbcMemberDao implements MemberDao{

	@Override
	public Member getMember(String mid) {
		String sql = "SELECT * FROM MEMBERS WHERE MID =" + "'" +mid+ "'";
		String url="jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();

			Member m = new Member();
			m.setName(rs.getString("Name"));
			m.setPwd(rs.getString("Pwd"));
			m.setMid(rs.getString("Mid"));
			
			rs.close();
			st.close();
			con.close();

			return m;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
