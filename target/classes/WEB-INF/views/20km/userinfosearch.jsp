<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/20km/search">
<form:errors path="id" cssStyle="color:red" element="div"/>
ID:<form:input type="number" path="id"/><br>
<input type="submit" name="検索">
</form:form>
</body>
</html>