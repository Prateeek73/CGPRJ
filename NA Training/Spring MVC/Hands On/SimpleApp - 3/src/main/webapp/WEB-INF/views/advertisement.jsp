<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body style="background-color:lavender">
<h1><center> Advertisement Agency </center></h1>

<form:form method="post" action="display" modelAttribute="advertisement">

<table style="margin: 0px auto; margin-left: auto; margin-right:auto">
		               
              
<tr><td>Advertisement Id</td><td> <form:input path="advertisementId" name="advertisementId"/></td></tr>
				
<tr><td>Advertisement Type</td><td><form:input path="advertisementType" name="advertisementType"/></td></tr>
<tr><td>Cost</td><td><form:input path="cost" name="cost"/></td></tr>


			<tr>
				<td><input type="submit" value="Display" name="submit" /></td>
				<td><input type="reset" value="Cancel"/></td>
			</tr>
			
		</table>
</form:form>


</body>
</html>