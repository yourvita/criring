package com.jin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.model.MemberDAO;
import com.jin.model.MemberDTO;
import com.jin.model.StoreDAO;
import com.jin.model.StoreDTO;


public class loginChk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		String inputPw = request.getParameter("inputPw");
		String inputName = null;
		String inputAddr = null;

		MemberDAO dao = new MemberDAO();
<<<<<<< HEAD
		MemberDTO mdto = new MemberDTO(inputEmail, inputPw, inputName, inputAddr);
		MemberDTO member = dao.loginCheck(mdto);
		if(member != null) {
=======
		StoreDAO sdao = new StoreDAO();
		MemberDTO dto = new MemberDTO(inputEmail, inputPw);
		StoreDTO sdto = new StoreDTO(inputEmail, inputPw);
		MemberDTO memberChk = dao.loginChk(dto);
		StoreDTO storeChk = sdao.loginChk(sdto);
//		사업자로그인 만들어야함 TODO
		
		if(memberChk !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberChk);
>>>>>>> branch 'master' of https://github.com/yourvita/criring.git
			System.out.println("로그인 성공");
			response.sendRedirect("index.jsp");
		} else if(storeChk !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("storemember", storeChk);
			System.out.println("로그인 성공");
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("로그인 실패");
<<<<<<< HEAD
			System.out.println(member);
=======
			System.out.println("스토어 체크" + storeChk);
			System.out.println("멤버 체크" +memberChk);
>>>>>>> branch 'master' of https://github.com/yourvita/criring.git
			response.sendRedirect("login1.jsp");
		}
	}
}
