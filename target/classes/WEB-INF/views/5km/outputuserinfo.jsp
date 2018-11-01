<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>名前：</td>
<td><c:out value="${user.name}"/></td>
</tr>
<tr>
<td>年齢：</td>
<td><c:out value="${user.age}"/></td>
</tr>
<tr>
<td>住所：</td>
<td><c:out value="${user.address}"/></td>
</tr>
</table>
</body>
</html>