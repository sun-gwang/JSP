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

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = new MemberDTO();
		
		String uid   = req.getParameter("uid");
		String name  = req.getParameter("name");
		String hp    = req.getParameter("hp");
		String pos   = req.getParameter("pos");
		String dep   = req.getParameter("dep");
		String rdate = req.getParameter("rdate");
		
		member.setUid(uid);
		member.setName(name);
		member.setHp(hp);
		member.setPos(pos);
		member.setDep(dep);
		member.setRdate(rdate);
		
		dao.insertMember(member);
		
		resp.sendRedirect("/ch11/member/list.do");
	}
}
