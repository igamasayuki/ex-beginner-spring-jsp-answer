<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="itemForms" action="${pageContext.request.contextPath}/15km/calc">
<form:errors path="goods1" cssStyle="color:red" element="div"/>
商品１：<form:input type="number" path="goods1"/><br>
<form:errors path="goods2" cssStyle="color:red" element="div"/>
商品２：<form:input type="number" path="goods2"/><br>
<form:errors path="goods3" cssStyle="color:red" element="div"/>
商品３：<form:input type="number" path="goods3"/><br>
<input type="submit" name="購入">
</form:form>
</body>
</html>