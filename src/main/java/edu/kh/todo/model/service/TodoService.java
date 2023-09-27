package edu.kh.todo.model.service;

import static edu.kh.todo.common.JDBCTemplete.getConnection;

import java.sql.Connection;
import java.util.List;

import static edu.kh.todo.common.JDBCTemplete.*;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO();
	
	/** todo List Service
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Todo> selectAll(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> tdList = dao.selectAll(conn, memberNo);
		
		close(conn);	
		
		return tdList;
	}

	
	/** todo insert Service
	 * @param inputTitle
	 * @param inputContent
	 * @param memberNumber
	 * @return
	 */
	public int todoInsert(String inputTitle, String inputContent, int memberNumber) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.todoInsert(conn, inputTitle, inputContent, memberNumber);
		
		close(conn);
		
		return result;
	}


	/** todo Delete Service
	 * @param todoNo
	 * @param memberNumber
	 * @return
	 */
	public int todoDelete(String deleteNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.todoDelete(conn, deleteNo);
		
		close(conn);
		
		return result;
	}


	/** List 조회 Service
	 * @param updateNo
	 * @return
	 */
	public List<Todo> search(String updateNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.search(conn, updateNo);
		
		close(conn);	
		
		return todoList;
	}

	
}