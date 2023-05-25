package com.jin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.model.MemberDAO;
import com.jin.model.MemberDTO;


public class joinMember extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String joinEmail = request.getParameter("joinEmail");
		String joinPw = request.getParameter("joinPw");
		String joinName = request.getParameter("joinName");
		String joinAddr = request.getParameter("joinAddr");
		
		MemberDTO dto = new MemberDTO(joinEmail, joinPw, joinName, joinAddr,null,null,null);
		MemberDAO dao = new MemberDAO();
		int result = dao.joinMember(dto);
		if(result >0 ) {
			System.out.println("등록 성공");
			response.sendRedirect("login1.jsp");
		} else {
			System.out.println("등록 실패");
			response.sendRedirect("page-404.html");
		}
	}

}
