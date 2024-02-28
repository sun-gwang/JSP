package kr.co.jboard2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.dto.ArticleDTO;
import kr.co.jboard2.dto.FileDTO;
import kr.co.jboard2.service.ArticleService;
import kr.co.jboard2.service.FileService;

@WebServlet("/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService articleservice = ArticleService.getInstance();
	private FileService fileService = FileService.getInstance();
	
	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int ano = Integer.parseInt(req.getParameter("no"));
		req.setAttribute("no", ano);
		
		// 수정할 파일
		FileDTO fileDTO = fileService.selectFile(ano);
		req.setAttribute("fileDTO", fileDTO);
		
		// 수정할 글
		ArticleDTO articleDTO = articleservice.selectArticle(ano);
		req.setAttribute("articleDTO", articleDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파일 업로드
		ArticleDTO articleDTO = new ArticleDTO(); 
		articleDTO = articleservice.fileUpload(req);
		
		logger.debug(""+articleDTO);
		
		// 원글 수정
		articleservice.updateArticle(articleDTO);
		
		//파일 등록
		List<FileDTO> files = articleDTO.getFileDTOs();
		
		for(FileDTO fileDTO : files) {
			fileDTO.setAno(articleDTO.getNo());
			logger.debug("" + fileDTO);
			
			fileService.insertFile(fileDTO);
		}
		
		
		resp.sendRedirect("/jboard2/view.do?no="+articleDTO.getNo());
	}
	

}
