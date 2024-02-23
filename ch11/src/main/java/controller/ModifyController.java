package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/member/modify.do")

public class ModifyController extends HttpServlet{
	MemberDAO dao = MemberDAO.getInstance();
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		MemberDTO member = dao.selectMember(uid);
		
		req.setAttribute("member", member);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		
		MemberDTO member = new MemberDTO();
		member.setUid(uid);
		member.setName(name);
		member.setHp(hp);
		
		dao.updateMember(member);
		
		resp.sendRedirect("/ch11/member/list.do");
		
	}
	
	
}
