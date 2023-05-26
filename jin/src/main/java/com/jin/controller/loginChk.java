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
		MemberDTO dto = new MemberDTO(inputEmail, inputPw);
		MemberDTO memberChk = dao.loginChk(dto);
		if(memberChk !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
			System.out.println("로그인 성공");
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("로그인 실패");
			System.out.println(memberChk);
			response.sendRedirect("login1.jsp");
		}
	}

}
