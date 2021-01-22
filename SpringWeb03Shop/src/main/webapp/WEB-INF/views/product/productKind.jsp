<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter01/header.jsp" %>
<%@ include file="/resources/sub01/sub_image.html" %>
<%@ include file="/resources/sub01/sub_menu.html" %>

<article>
    <h2> Item</h2>
    <c:forEach var="p" items="${productKindList}" varStatus="status">
        <div id="item">
            <a href="productDetail?pseq=${p.pseq}">
                <img src="<c:url value="/resources/product_images/${p.image}"/>">
                <h3>${p.name}</h3><p>${p.price2}</p>
            </a>
        </div>
    </c:forEach>
    <div class="clear"></div>
</article>

<%@ include file="/resources/headerfooter01/footer.jsp" %>
