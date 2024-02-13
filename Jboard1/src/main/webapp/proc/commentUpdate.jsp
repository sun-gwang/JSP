<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String parent = request.getParameter("parent");
	String no = request.getParameter("no");	
	String content = request.getParameter("content");
	
	ArticleDTO comment = new ArticleDTO();
	comment.setContent(content);
	comment.setNo(no);
	
	ArticleDAO.getInstance().updateComment(comment);
	
	response.sendRedirect("/Jboard1/view.jsp?no="+parent);
%>
