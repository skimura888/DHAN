<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP画面</title>
</head>
<body>
	<form:form action="login" method="get" modelAttribute ="loginForm">
		<form:button>通常ログイン</form:button>
	</form:form>
</body>
</html>
