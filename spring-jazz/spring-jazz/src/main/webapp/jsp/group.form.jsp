<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add Group</h1>
		<%-- <form method="post" action="/group/add">
		<p><input type="text" name="name"></p>
		<p class="submit"> <input type="submit" name="add" value="Add"></p>
	
		</form> --%>
		
		<form:form method="post" action="/nhom/luu">
		<p><input type="text" path="name" name="name"></p>
		<p class="submit"> <input type="submit" name="add" value="Add"></p>
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>