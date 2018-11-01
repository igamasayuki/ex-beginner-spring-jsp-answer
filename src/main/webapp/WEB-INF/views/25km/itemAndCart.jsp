<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>商品一覧</h3>
	<ul>
		<c:forEach var="item" items="${itemList}" varStatus="status">
			<li>
				<c:out value="${item.name}" /> 
				<c:out value="${item.price}" />円
				<form action="${pageContext.request.contextPath}/25km/in-cart">
					<input type="hidden" name="index" value="${status.index}" /> 
					<input type="submit" value="カートへ">
				</form></li>
		</c:forEach>
	</ul>
	<hr>
	<h3>ショッピングカート</h3>
	<ul>
		<c:forEach var="cartItem" items="${cartItemList}" varStatus="status">
			<li>
				<c:out value="${cartItem.name}" />
				<c:out value="${cartItem.price}" />円
				<form action="${pageContext.request.contextPath}/25km/delete">
					<input type="hidden" name="index" value="${status.index}" /> 
					<input type="submit" value="削除">
				</form>
			</li>
		</c:forEach>
	</ul>
	<hr>
	合計金額：
	<c:out value="${totalPrice}" />
	円
</body>
</html>