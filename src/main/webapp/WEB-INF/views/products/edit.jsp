<%@ include file="/resources/common/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	  <title><fmt:message key="title"/> - Product Creation</title>
	  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/resources/common/products/header.jsp" %>
		<script>
			function removePhoto() {
				document.getElementById("selectedPhoto").style.display = "none";
				document.getElementById("selectPhoto").style.display = "block";
				document.getElementById("removedPhoto").value = "true";
			}
		</script>
		<main class="content">
			<form:form class="create-product-form" enctype="multipart/form-data" method="post" commandName="productValidator">
			  <h3 class="content-title">Create a product</h3>
			  <ul class="form-content">
			    <li>
			        <form:input path="description" placeholder="Description" required="required"/>
			        <form:errors path="description" cssClass="error"/>
			    </li>
			    <li>
			      	<p>Price:</p>
			        <form:input path="price" type="number" step="any" min="0" required="required"/>
			        <form:errors path="price" cssClass="error"/>
			    </li>
			    <li class="important">
			    	<span>Important </span>
			        <form:checkbox path="important"/>
			    </li>
			    <li>
			    	<p>Photo:</p>
			    	<c:choose>
				    	<c:when test="${productValidator.existPhoto()}">
				    		<div id="selectedPhoto" class="image-preview">
				    			<img src='/myshop/image?id=${productValidator.getExistingProductId()}'>
				    			<i class="remove-image-icon" onclick="removePhoto();">X</i>
				    		</div>
				    		<form:input id="selectPhoto" path="photo" type="file" style="display: none;"/>
				    	</c:when>
				    	<c:otherwise>
				    		<form:input path="photo" type="file"/>
				    	</c:otherwise>
				    </c:choose>
				    <form:input id="removedPhoto" type="hidden" path="removedPhoto" value="false"/>
			    </li>
			    <li>
			    	<input type="submit" value="Edit">
			    </li>
			  </ul>
			</form:form>
		</main>
	</body>
</html>