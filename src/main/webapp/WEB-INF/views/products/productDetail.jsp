<%@ include file="/resources/common/include.jsp" %>

<html>
  <head>
  	<title><fmt:message key="title"/> - Product List</title>
  	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  </head>
  <body>
  	<%@ include file="/resources/common/products/header.jsp" %>
  	<main class="content">
	    <h3 class="content-title">Product Detail</h3>
    	<div class="product full-image">
    		<img src='${model.product.getPhotoURL()}'>
    	</div>
    	<div class="product-desc">
    		<span><c:out value="${model.product.description}"/></span>
    		<span class="product-price"><fmt:formatNumber value="${model.product.price}" maxFractionDigits="2"/>$</span>
    	</div>
	</main>
	<%@ include file="/resources/common/footer.jsp" %>
  </body>
</html>