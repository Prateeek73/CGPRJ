<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>
#message {
	color: red;
}
</style>
</head>
<body style="background-color: lavender">

	<!--  Do not change the below line -->
	<a href="/showPage?language=en">English</a>|
	<a href="/showPage?language=fr">French</a>
	</align>
	<!--  Design the page as per the requirements-->
	<h1>
		<center>Health Care Center</center>
	</h1>
	<form:form action="consultation" method="post"
		modelAttribute="appointment">
		<table style="margin: 0px auto; margin-left: auto; margin-right: auto">

			<tr>
				<td><spring:message code="label.patientName" text="default"/></td>
				<td><form:input path="patientName" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.phoneNumber" text="default"/></td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.age" text="default"/></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.consultationFor" text="default"/></td>
				<td><form:select path="consultationFor" items="${consultationList}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id="submit" value="Book Appointment" /></td>
			</tr>
			<tr>
				<td colspan=2><div id="message">${message}</div></td>
			</tr>
		</table>
	</form:form>
</body>
</html>