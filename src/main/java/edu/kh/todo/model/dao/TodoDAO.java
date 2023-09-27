package edu.kh.todo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.member.model.dao.MemberDAO;
import static edu.kh.todo.common.JDBCTemplete.*;
import edu.kh.todo.model.dto.Todo;

public class TodoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	private Properties prop;
	
	public TodoDAO() {
		
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/todo/sql/todo-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Todo> selectAll(Connection conn, int memberNo) throws Exception{
		
		List<Todo> tdList = new ArrayList<Todo>();
		
		try {
			
			String sql = prop.getProperty("todoList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Todo todo = new Todo();
				
				todo.setTodoNo(rs.getInt(1));
				todo.setTodoTitle(rs.getString(2));
				todo.setTodoMemo(rs.getString(3));
				todo.setTodoDate(rs.getString(4));
				todo.setTodoDeleteFlag(rs.getString(5));
				
				tdList.add(todo);
			}
						
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return tdList;
	}

}
