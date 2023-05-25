package com.jin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jin.model.MemberDAO;
import com.jin.model.MemberDTO;


public class loginChk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		String inputPw = request.getParameter("inputPw");

		MemberDAO dao = new MemberDAO();
		MemberDTO member2 = dao.loginChk(inputEmail, inputPw);
		
		if(member2 != null) {
			System.out.println("로그인 성공");
			response.sendRedirect("index.html");
		} else {
			System.out.println("로그인 실패");
			System.out.println(member2);
			response.sendRedirect("login1.jsp");
		}
	}

}
