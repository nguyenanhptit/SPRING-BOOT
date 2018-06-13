<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring jazz application</title>
</head>
<body>

	<h1>Welcome to Spring Jazz</h1>
	<p>
		<a href="/">Trang Chu</a>
		<sec:authorize access="!hasAnyRole('ROLE_USER')">
			<a href="/dang-nhap" style="margin-left: 30px">Dang Nhap</a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_USER')">
			<a href="/nguoi-dung" style="margin-left: 30px">Nguoi Dung</a>
			<a href="javascript:document.getElementById('logout').submit();" style="margin-left:30px">Dang Xuat</a>
		</sec:authorize>
	</p>
	<form action="/j_spring_security_logout" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	<tiles:insertAttribute name="body" />
</body>
</html>