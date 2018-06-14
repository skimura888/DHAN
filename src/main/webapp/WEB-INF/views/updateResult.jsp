<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>実行者：</p>
<p>正常に更新されました</p>
<form:form action="select" method="get" modelAttribute = "form">
  <form:button>検索</form:button>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
