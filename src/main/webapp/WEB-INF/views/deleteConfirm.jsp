<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>これでよろしいですか？</p>

<form:form action="deleteConfirm" modelAttribute="form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="id" value="${User.userId}" readonly="true"/>
    </div>
    <div>
      <label>名前</label><form:input path="name" value="${User.userName}" readonly="true"/>
    </div>
    <div>
      <label>TEL</label><form:input path="tel" value="${User.telephone}" readonly="true"/>
    </div>
  </fieldset>
  <div>
    <form:button>削除</form:button>
    <form:button onclick="location.href='delete'; return false;">戻る</form:button>
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
