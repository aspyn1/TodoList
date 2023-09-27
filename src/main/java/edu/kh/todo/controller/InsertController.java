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

@WebServlet("/memo/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			
			String inputTitle = req.getParameter("inputTitle");		
			String inputContent = req.getParameter("inputContent");
			
			Member member = (Member) session.getAttribute("loginMember");
			
			TodoService tdService = new TodoService();
			
			int memberNumber = member.getMemberNo();
			
			int result = tdService.todoInsert(inputTitle, inputContent, memberNumber);			
			
			List<Todo> tdList = tdService.selectAll(memberNumber);
					
			session.setAttribute("tdList", tdList);			
			
			resp.sendRedirect("/");
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
