<%@ include file="/resources/common/include.jsp" %>

<html>
  <head>
  	<title><fmt:message key="title"/> - Product List</title>
  	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  </head>
  <body>
  	<%@ include file="/resources/common/products/header.jsp" %>
  	<main class="content">
	    <h3 class="content-title">Products</h3>
	    <a class="add-product-icon" href="<c:url value="create.htm"/>">+</a>
	    <c:forEach items="${model.products}" var="prod">
	    	<div class="product">
	    		<span><c:out value="${prod.description}"/></span>
	    		<span class="product-price"><fmt:formatNumber value="${prod.price}" maxFractionDigits="2"/>$</span>
	    	</div>
	    </c:forEach>
	</main>
	<%@ include file="/resources/common/footer.jsp" %>
  </body>
</html>