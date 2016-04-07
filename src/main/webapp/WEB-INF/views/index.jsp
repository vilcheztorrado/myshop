<%@ include file="/resources/common/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><fmt:message key="title"/></title>
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/resources/common/header.jsp" %>
		<main class="content">
			<h3 class="content-title">Most Popular Products</h3>
			<c:forEach items="${model.products}" var="prod">
		    	<div class="product">
		    		<img src='${prod.getPhotoURL()}'>
		    		<span><c:out value="${prod.description}"/></span>
		    		<span class="product-price"><fmt:formatNumber value="${prod.price}" maxFractionDigits="2"/>$</span>
		    	</div>
		    </c:forEach>
		</main>
		<%@ include file="/resources/common/footer.jsp" %>
	</body>
</html>