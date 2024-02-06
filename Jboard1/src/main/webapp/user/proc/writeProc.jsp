<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String file = request.getParameter("file");
	String regip = request.getRemoteAddr();
	String writer = request.getParameter("writer");
	
	ArticleDTO article = new ArticleDTO();
	article.setTitle(title);
	article.setContent(content);
	article.setWriter(writer);
	article.setRegip(regip);
	
	ArticleDAO.getInstance().insertArticle(article);
	
	response.sendRedirect("/Jboard1/list.jsp");
%>