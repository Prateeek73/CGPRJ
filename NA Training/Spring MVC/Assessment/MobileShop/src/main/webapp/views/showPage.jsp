<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body style="background-color:lavender">
<a href="showPage?language=en">English</a>|<a href="showPage?language=de">German</a>|<a href="showPage?language=fr">French</a></align>
<!--  Design the page as per the requirements-->
	<form:form action="billDesk" method="post" modelAttribute="order">
		<table>
			<tr>
				<td>${label.customerName}</td>
				<td><form:input path="customerName"/></td>
			</tr>
			<tr>
				<td>${label.contactNumber}</td>
				<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
				<td>${label.productName}</td>
				<td><form:select path="productName" items="${productList}" /></td>
			</tr>
			<tr>
				<td>${label.quantity}</td>
				<td><form:input path="quantity"/></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" name="submit" value="Submit" ></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>	 