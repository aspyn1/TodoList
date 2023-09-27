package edu.kh.todo.model.service;

import static edu.kh.todo.common.JDBCTemplete.getConnection;

import java.sql.Connection;
import java.util.List;

import static edu.kh.todo.common.JDBCTemplete.*;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO();
	
	public List<Todo> selectAll(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> tdList = dao.selectAll(conn, memberNo);
		
		close(conn);	
		
		return tdList;
	}

}