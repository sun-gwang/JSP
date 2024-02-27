<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./_header.jsp" %>
        <main id="board">
            <section class="list">                
                <form action="#" class="search">
                    <select name="searchType">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="title_content">제목+내용</option>
                        <option value="writer">작성자</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색 키워드 입력">
                    <input type="submit" value="검색">
                </form>
                
                <table border="0">
                    <caption>글목록</caption>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>    
                    <c:forEach var="article" items="${articles}" >
                    <tr>
                        <td></td>
                        <td><a href="/jboard2/view.do?no=${article.no}&fno=">${article.title}</a></td>
                        <td>${article.nick}</td>
                        <td>${article.rdate}</td>
                        <td>${article.hit}</td>
                    </tr>
                    </c:forEach>
                </table>

                <div class="page">
                    <a href="#" class="prev">이전</a>
                    <a href="#" class="num current">1</a>
                    <a href="#" class="num">2</a>
                    <a href="#" class="num">3</a>
                    <a href="#" class="next">다음</a>
                </div>

                <a href="/jboard2/write.do" class="btn btnWrite">글쓰기</a>
                
            </section>
        </main>
<%@ include file="./_footer.jsp" %>
        