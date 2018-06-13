<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>User</h1>
		<p>Username:${user.username}</p>
		<p>Password:${user.password}</p>
		<p>Email:${user.email}</p>
		<p>Age:${user.age}</p>
		<p>Group:${user.group.name}</p>
	
	</tiles:putAttribute>
</tiles:insertDefinition>