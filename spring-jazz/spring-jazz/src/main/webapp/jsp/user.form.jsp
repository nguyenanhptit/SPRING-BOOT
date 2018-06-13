<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add User</h1>
		<form:form method="post" action="/tai-khoan/luu">
			<p>
				Ten
				<form:input path="username" type="text" name="username" />
				<br>
			</p>
			<p>
				Mat khau
				<form:input path="password" type="password" name="password" />
				<br>
			</p>
			<p>
				Email
				<form:input path="email" type="text" name="email" />
				<br>
			</p>
			<p>
				Tuoi
				<form:input path="age" type="number" name="age" />
				<br>
			</p>
			<p>
				Nhom
				<form:select id="group" name="group" path="groupId">
					<form:options items="${groups}" />
				</form:select>
				<br>
			</p>
			<p class="submit">
				<input type="submit" name="add" value="add" />
			</p>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>