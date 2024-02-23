package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/member/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	MemberDAO dao = MemberDAO.getInstance();
	
	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		dao.deleteMember(uid);
		resp.sendRedirect("/ch11/member/list.do");
	}
	
}
