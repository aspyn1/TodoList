package edu.kh.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.member.model.dto.Member;
import edu.kh.todo.model.dto.Todo;

import static edu.kh.todo.common.JDBCTemplete.*;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	private Properties prop;	
	
	public MemberDAO() {
		try {
			
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/todo/sql/member-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Member login(Connection conn, String inputId, String inputPw) throws Exception{
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberNickname(rs.getString(2));				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return loginMember;
	}

}