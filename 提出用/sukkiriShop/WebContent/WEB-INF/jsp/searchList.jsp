<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${sessionScope.userId}さん</p>
<p>"${requestScope.searchStr}"は${fn:length(accountList)}件です</p>
<c:if test="${! empty accountList}">
<table>
<c:forEach items="${accountList}" var="acListLine" varStatus="status">
<tr>
<td>
<c:out value="${status.count}"/>
</td>
<td>
ユーザーID:${acListLine.userId}
</td>
<td>
名前:${acListLine.name}
</td>
<td>
メールアドレス:${acListLine.mail}
</td>
<td>
${acListLine.age}
</td>
</tr>
</c:forEach>

</table>
</c:if>
<form action="/sukkiriShop/SearchListServlet" method="GET">
<input type="text" name="searchStr">
<input type="submit" value="検索">
</form>
</body>
</html>