<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

<c:if test="${empty login}">
  <c:redirect url="/index"/>
</c:if>

	ようこそ${login}さん！！
<p>
	<a href="select">検索</a>
</p>
<p>
	<a href="insert">登録</a>
</p>
<p>
	<a href="update">更新</a>
</p>
<p>
	<a href="delete">削除</a>
</p>
<form:form action="logout" modelAttribute = "form">
  <form:button>ログアウト</form:button>
</form:form>
</body>
</html>
