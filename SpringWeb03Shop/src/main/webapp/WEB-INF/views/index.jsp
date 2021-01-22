<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/resources/headerfooter01/header.jsp" %>

    <!-- main image -->
    <div id="main_img">
        <img src="<c:url value='/resources/images/main_img.jsp' />" style="border-radius: 20px 20px 20px 20px; border:2px solid white;">
    </div>

    <!-- new -->
    <div id="front">
        <h2>New Item</h2>
        <div id="bestProduct">
            <c:forEach var="p" items="${newProductList}" varStatus="status">
                <div id="item">
                    <a href="productDetail?pseq=${p.pseq}">
                        <img src="<c:url value="/resources/product_images/${p.image}"/>">
                        <h3>${p.name} - 
                            <fmt:formatNumber value="${p.price2}" type="currency"></fmt:formatNumber>
                        </h3>
                    </a>
                </div>
                <div class="clear"></div>
            </c:forEach>
        </div>
    </div>

    <!-- best -->
    <div id="front">
        <h2>Best Item</h2>
        <div id="bestProduct">
            <c:forEach var="p" items="${bestProductList}" varStatus="status">
                <div id="item">
                    <a href="productDetail?pseq=${p.pseq}">
                        <img src="<c:url value="/resources/product_images/${p.image}"/>">
                        <h3>${p.name} - 
                            <fmt:formatNumber value="${p.price2}" type="currency"></fmt:formatNumber>
                        </h3>
                    </a>
                </div>
                <div class="clear"></div>
            </c:forEach>
        </div>
    </div>

    


<%@ include file="/resources/headerfooter01/footer.jsp" %>