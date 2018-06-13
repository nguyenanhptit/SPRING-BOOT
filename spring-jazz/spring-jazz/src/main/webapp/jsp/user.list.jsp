<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>User List</h1>
		<table style="width: 100%">
			<tr>
				<td>Name</td>
				<td>Age</td>
			</tr>
			<c:forEach items="${users}" var="item" varStatus="loop">
				<tr>
					<td><a href="/tai-khoan/chi-tiet/${item.username}">${item.username}</a></td>
					<td>${item.age}</td>
					<td><a href="/tai-khoan/xoa/${item.username}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</tiles:putAttribute>
</tiles:insertDefinition>