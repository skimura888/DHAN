<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
  float: left;
}

.col-clear {
  clear: both;
}

#arrow {
  margin-top: 60px;
}
</style>
</head>
<body>
  <c:if test="${not empty msg}">
    <p class="message">${msg}</p>
  </c:if>
<p>これでよろしいですか？</p>

<form:form action="updateConfirm" modelAttribute ="form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="id" value="${fn:escapeXml(beforeUser.userId)}" readonly="true"/>
    </div>
  </fieldset>

  <fieldset class="col">
    <legend>変更前</legend>
    <div>
      <label>名前</label><form:input path="forName" value="${beforeUser.userName}" disabled="true"/>
    </div>
    <div>
      <label>TEL</label><form:input path="forTel" value="${beforeUser.telephone}" disabled="true"/>
    </div>
    <div>
      <label>PASS</label><form:password path="forPass" value="${beforeUser.password}" disabled="true"/>
    </div>
  </fieldset>

  <div id="arrow" class="col">⇒</div>

  <fieldset class="col label-110">
    <legend>変更後</legend>
    <div>
      <label>名前</label><form:input path="name" value="${fn:escapeXml(afterUser.userName)}" readonly="true"/>
    </div>
    <div>
      <label>TEL</label><form:input path="tel" value="${fn:escapeXml(afterUser.telephone)}" readonly="true"/>
    </div>
    <div>
      <label>PASS(再入力)</label><form:password path="pass" value ="${fn:escapeXml(rePass)}"/>
    </div>
  </fieldset>

  <div class="col-clear">
    <form:button>更新</form:button>
    <form:button onclick="location.href='update'; return false;">戻る</form:button>
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
