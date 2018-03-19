<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${sessionScope.userId}さん</p>

<p>ユーザーIDまたは、名前で検索します。</p>
<form action="/sukkiriShop/SearchListServlet" method="get">
<input type="text" name="searchStr">
<input type="submit" value="検索">
</form>
</body>
</html>