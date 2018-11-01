<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/10km/calc">
<input type="number" name="num1"/>
×
<input type="number" name="num2"/><br>
<div style="color:red;"><c:out value="${error1}"></c:out></div>
<div style="color:red;"><c:out value="${error2}"></c:out></div>
<input type="submit" name="計算">
</form>
</body>
</html>