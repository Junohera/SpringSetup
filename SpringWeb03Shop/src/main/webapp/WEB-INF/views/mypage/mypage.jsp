<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter01/header.jsp" %>
<%@ include file="/resources/sub03/sub_image.html" %>
<%@ include file="/resources/sub03/sub_menu.html" %>

<article>
    <h2>${title}</h2>
    <form name="formm" method="POST">
        <table id="cartList">
            <tr>
                <th>주문일자</th>
                <th>주문번호</th>
                <th>상품명</th>
                <th>결제 금액</th>
                <th>주문 상세</th>
                <th>처리상태</th>
            </tr>
            <c:forEach var="o" items="${orderList}" varStatus="status">
                <tr>
                    <td><fmt:formatDate value="${o.indate}"></fmt:formatDate></td>
                    <td>${o.oseq}</td>
                    <td>${o.pname}</td>
                    <td><fmt:formatNumber value="${o.price2}" type="currency"></fmt:formatNumber></td>
                    <td><a href="orderDetail?oseq=${o.oseq}">조회</a></td>
                    <td>
                        <c:if test="${o.result == '1'}">미처리</c:if>
                        <c:if test="${o.result == '2'}">완료</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='/shop/'">
        </div>
    </form>
</article>

<%@ include file="/resources/headerfooter01/footer.jsp" %>
