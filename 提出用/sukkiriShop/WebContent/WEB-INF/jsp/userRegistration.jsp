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
ユーザーID<input type="text" name="userId"><br>
パスワード<input type="password" name="pass"><br>
メールアドレス<input type="email" name="mail"><br>
名前<input type="text" name="name"><br>
年齢<input type="text" name="age"><br>
<input type="submit" value="登録する">
</form>
</body>
</html>