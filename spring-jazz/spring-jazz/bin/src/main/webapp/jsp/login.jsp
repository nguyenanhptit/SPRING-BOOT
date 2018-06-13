<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Trang Dang Nhap</h1>
		<c:if test="${not empty error}">
		<p>Sai ten dang nhap hoac mat khau</p>
		
		</c:if>
		<form method="post" action="/j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token }" />
			<p>
				<input type="text" name="username" placeholder="Username">
			</p>
			<p>
				<input type="password" name="password" placeholder="Password">
			</p>
			<p>
				<input type="submit" name="commit" value="Login">
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>