package sub1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting.do")
public class GreetingServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get 요청이 들어올 때
				System.out.println("GreetingServlet doGet()...");
				
				// HTML 출력
				resp.setContentType("text/html;charset=UTF-8");
				
				PrintWriter writer = resp.getWriter();
				writer.print("<html>");
				writer.print("<head>");
				writer.print("<meta charset='UTF-8'>");
				writer.print("<title>GreetingServlet</title>");
				writer.print("</head>");
				writer.print("<body>");
				writer.print("<h3>GreetingServlet</h3>");
				writer.print("<a href='./1.ServletTest.jsp'>Servlet메인</a>");
				writer.print("<a href='./hello.do'>HelloServlet</a>");
				writer.print("<a href='./welcome.do'>WelcomeServlet</a>");
				writer.print("<a href='./greeting.do'>GreetingServlet</a>");
				writer.print("</body>");
				writer.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	public void destroy() {

	}
}
