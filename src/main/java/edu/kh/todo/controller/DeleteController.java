package edu.kh.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/memo/delete")
public class DeleteController extends HttpServlet{
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {			
			
			HttpSession session = req.getSession();			
			Member member = (Member) session.getAttribute("loginMember");
			int memberNumber = member.getMemberNo();
			
			String deleteNo = req.getParameter("no");
			
			TodoService tdService = new TodoService();
						
			int result = tdService.todoDelete(deleteNo);
			
			List<Todo> tdList = tdService.selectAll(memberNumber);
					
			session.setAttribute("tdList", tdList);			
			
			resp.sendRedirect("/");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

}
