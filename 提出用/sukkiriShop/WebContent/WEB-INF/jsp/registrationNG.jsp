<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<form action="/sukkiriShop/UserRegistrationServlet" method="post">
ユーザーID<input type="text" name="userId" value="${account.userId}"><font color="red"><c:out value="${input.userIdCheck}" /></font><br>
パスワード<input type="password" name="pass" value="${account.pass}"><font color="red"><c:out value="${input.passCheck}" /></font><br>
メールアドレス<input type="email" name="mail" value="${account.mail}"><font color="red"><c:out value="${input.mailCheck}" /></font><br>
名前<input type="text" name="name" value="${account.name}"><font color="red"><c:out value="${input.nameCheck}" /></font><br>

年齢<c:choose>
<c:when test="${account.age==-1}">
<input type="text" name="age">
</c:when>
<c:otherwise>
 <input type="text" name="age" value="${account.age}">
 </c:otherwise>
 </c:choose>
<font color="red"><c:out value="${input.ageCheck}" /></font><br>
<input type="submit" value="登録する">
</form>
</body>
</html>