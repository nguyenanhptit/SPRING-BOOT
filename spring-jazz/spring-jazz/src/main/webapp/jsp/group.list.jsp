<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Group List</h1>
		<table style="width: 100%">
			<tr>
				<td>Name</td>
				<td>#</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="/nhom/danh-sach/tim-kiem" method="get">
						<input type="text" name="q">
					</form>
				</td>
			</tr>
			<c:forEach items="${groups }" var="item" varStatus="loop">
				<tr>
					<%-- <td>${item.name }</td> --%>
					<td><a href="/tai-khoan/danh-sach?group=${item.id}">${item.name}</a></td>
					<ul>
						<c:forEach items="${item.users }" var="user" varStatus="loop">
							<li>${user.username }-${user.age }</li>
						</c:forEach>
					</ul>
					<td><a href="xoa/${item.id }">Delete</a></td>
					<td><a href="sua?id=${item.id }">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</tiles:putAttribute>
</tiles:insertDefinition>