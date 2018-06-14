<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="${pageContext.request.contextPath}/css/commons.css" rel="stylesheet">
</head>
<body>
  <c:if test="${not empty msg}">
    <p class="message">${msg}</p>
  </c:if>
	<p>
		１箇所以上の項目を変更してください<br> ※IDは変更できません
	</p>
	<form:form action="updateInput" modelAttribute ="form">
		<fieldset>
			<div>
				<label>ID</label><form:input path="id"
					value="${fn:escapeXml(beforeUser.userId)}" readonly="true" />
			</div>
			<div>
				<label>名前</label><form:input path="name"
					value="${fn:escapeXml(beforeUser.userName)}"/>
			</div>
			<div>
				<label>TEL</label><form:input path="tel"
					value="${fn:escapeXml(beforeUser.telephone)}"/>
			</div>
			<div>
				<label>PASS</label><form:password path="pass"
					value="${fn:escapeXml(beforeUser.password)}"/>
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="確認">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
