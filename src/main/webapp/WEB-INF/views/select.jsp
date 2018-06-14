<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

    <p class="message">${msg}</p>

<p>検索したいデータ情報を入力してください<br>
※全て空白の場合は全検索を行います</p>

<form:form action="list" modelAttribute="form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="userId" />
    </div>
    <div>
      <label>名前</label><form:input path="userName" />
    </div>
    <div>
      <label>TEL</label><form:input path="telephone" />
    </div>
  </fieldset>
  <form:button>検索</form:button>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
