package sub1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 실행될 때 실행되는 메서드 (초기화 작업 처리)
		System.out.println("WelcomeServlet init()...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get 요청이 들어올 때
		System.out.println("WelcomeServlet doGet()...");
		
		// HTML 출력
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<meta charset='UTF-8'>");
		writer.print("<title>WelcomeServlet</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h3>WelcomeServlet</h3>");
		writer.print("<a href='./1.ServletTest.jsp'>Servlet메인</a>");
		writer.print("<a href='./hello.do'>HelloServlet</a>");
		writer.print("<a href='./welcome.do'>WelcomeServlet</a>");
		writer.print("<a href='./greeting.do'>GreetingServlet</a>");
		writer.print("</body>");
		writer.print("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post 요청이 들어올 때
		System.out.println("WelcomeServlet doPost()...");
	}
	
	@Override
	public void destroy() {
		// 서블릿이 종료될 때
		System.out.println("WelcomeServlet destroy()...");
	}
}
