<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/5km/register-user-info">
<div style="color:red;"><c:out value="${error1}"></c:out></div>
名前：<form:input path="name"/><br>
<div style="color:red;"><c:out value="${error2}"></c:out></div>
<div style="color:red;"><c:out value="${error}"></c:out></div>
年齢：<form:input path="age"/><br>
<div style="color:red;"><c:out value="${error3}"></c:out></div>
住所：<form:input path="address"/><br>
<input type="submit" name="送信">
</form:form>
</body>
</html>