<%@ include file="/resources/common/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	  <title><fmt:message key="title"/> - Product Creation</title>
	  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/resources/common/products/header.jsp" %>
		<main class="content">
			<form:form class="create-product-form" method="post" commandName="productValidator">
			  <h3 class="content-title">Create a product</h3>
			  <ul class="form-content">
			    <li>
			        <form:input path="description" placeholder="Description" required="required"/>
			        <form:errors path="description" cssClass="error"/>
			    </li>
			    <li>
			      	<p>Price:</p>
			        <form:input path="price" type="number" min="0" step="any" required="required"/>
			        <form:errors path="price" cssClass="error"/>
			    </li>
			    <li class="important">
			    	<span>Important </span>
			        <form:checkbox path="important"/>
			    </li>
			    <li>
			    	<input type="submit" value="Create">
			    </li>
			  </ul>
			</form:form>
		</main>
	</body>
</html>