<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="lavender">
	<h1>
		<center>Candidate List</center>
	</h1>
	<!--  Fill the code -->
	<table border="1" cellpadding="5" cellspacing="0" align="center">
		<tr>
			<th>Candidate Name</th>
			<th>Contact Number</th>
			<th>Gender</th>
			<th>Position Applied</th>
			<th>Expected Salary</th>
			<th>Years of Experience</th>
		</tr>
		<c:forEach items="${candidateList}" var="candidate">
            <tr>
                <td>${candidate.candidateName}</td>
                <td>${candidate.contactNumber}</td>
                <td>${candidate.gender}</td>
                <td>${candidate.positionApplied}</td>
                <td>${candidate.expectedSalary}</td>
                <td>${candidate.yearsOfExperience}</td>
            </tr>
        </c:forEach>
	</table>
	<center>
		<a href="home">Back to Home</a>
	</center>
</body>
</html>
