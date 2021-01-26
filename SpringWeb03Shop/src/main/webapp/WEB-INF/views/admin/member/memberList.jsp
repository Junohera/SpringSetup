<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/resources/admin/header.jsp"%>
<%@ include file="/resources/admin/sub_menu.jsp"%>
<script>
    function go_search() {
        if (document.frm.key === "") return;
        document.frm.action = "adminMemberList?page=1";
        document.frm.submit();
    }
    function go_total() {
        document.frm.key.value = "";
        document.frm.action = "adminMemberList?page=1";
        document.frm.submit();
    }
</script>
<article>
    <h1>회원리스트</h1>    
    <form name="frm" method="POST">
        <table style="float:right;">
            <tr>
                <td>
                    회원이름
                    <input type="text" name="key" id="key" value="${key}">
                    <input type="button" value="검색" class="btn" onclick="go_search();">
                    <input type="button" name="btn_total" value="전체보기" class="btn" onclick="go_total();">
                </td>
            </tr>
        </table>
        <br>
        <table id="orderList">
            <tr>
                <th>아이디(탈퇴여부)</th>
                <th>이름</th>
                <th>이메일</th>
                <th>우편번호</th>
                <th>주소</th>
                <th>전화</th>
                <th>가입일</th>
            </tr>
            <c:forEach var="m" items="${memberList}" varStatus="status">
                <tr>
                    <td>
                        ${p.id}
                        <c:choose>
                            <c:when test="${m.useyn == 'y'}">
                                <input type="checkbox" name="useyn" disabled="disabled">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="useyn" checked="checked" disabled="disabled">
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${m.name}</td>
                    <td>${m.email}</td>
                    <td>${m.zip_num}</td>
                    <td>${m.address}</td>
                    <td>${m.phone}</td>
                </tr>
            </c:forEach>
        </table>

        <jsp:include page="/resources/util/paging.jsp">
            <jsp:param name="page" value="${paging.page}"/>
            <jsp:param name="beginPage" value="${paging.beginPage}" />
            <jsp:param name="endPage" value="${paging.endPage}" />
            <jsp:param name="prev" value="${paging.prev}" />
            <jsp:param name="next" value="${paging.next}"/>
            <jsp:param name="command" value="/adminMemberList"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/resources/admin/footer.jsp"%>