<%@page import="kr.co.jboard1.dao.TermsDAO"%>
<%@page import="kr.co.jboard1.dto.TermsDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	TermsDTO dto = TermsDAO.getInstance().selectTerms();
%>
<%@include file="./header.jsp" %> 
        <main>
            <section class="terms">
                <table>
                    <caption>사이트 이용약관</caption>
                    <tr>
                        <td>
                            <textarea readonly><%=dto.getTerms() %></textarea>
                            <p>
                                <label><input type="checkbox" name="chk1"/>동의합니다.</label>
                            </p>
                        </td>
                    </tr>
                </table>
                <table>
                    <caption>개인정보 취급방침</caption>
                    <tr>
                        <td>
                            <textarea readonly><%=dto.getPrivacy() %></textarea>
                            <p>
                                <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                            </p>
                        </td>
                    </tr>
                </table>
                 <table>
                    <caption>마켓팅 수신동의(선택)</caption>
                    <tr>
                        <td>
                            <textarea readonly><%=dto.getSms() %></textarea>
                            <p>
                                <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                            </p>
                        </td>
                    </tr>
                </table>
                <div>
                    <a href="/Myjboard1/user/login.jsp" class="btnCancel">취소</a>
                    <a href="/Myjboard1/user/register.jsp" class="btnNext">다음</a>
                </div>
            </section>
        </main>
<%@include file="./footer.jsp" %> 