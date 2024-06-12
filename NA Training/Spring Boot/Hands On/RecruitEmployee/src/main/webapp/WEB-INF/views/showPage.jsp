<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
* {
	box-sizing: border-box;
}

.row {
	margin-left: -5px;
	margin-right: -5px;
}

.column {
	float: left;
	width: 60%;
	padding: 3px;
}

.column1 {
	float: left;
	width: 25%;
	padding: 3px;
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 5px;
}

#message {
	color: red;
}
</style>
</head>

<body style="background-color: lavender">
	<h1>
		<center>Register Candidate</center>
	</h1>

	<form:form modelAttribute="candidate" method="post" action="register">

		<div class="row">
			<div class="column1">
				<table>
					<tr>
						<td><a href="/home">Home</a></td>
					</tr>
					<tr>
						<td><a href="/viewAllCandidateList">View All Candidates</a></td>
					</tr>
				</table>
			</div>
			<div class="column">
				<table
					style="margin: 0px auto; margin-left: auto; margin-right: auto">
					<tr>
						<td><form:label path="candidateName">Candidate Name</form:label></td>
						<td><form:input path="candidateName" /></td>
						<td><form:errors path="candidateName" />
					</tr>
					<tr>
						<td><form:label path="contactNumber">Contact Number</form:label></td>
						<td><form:input path="contactNumber" /></td>
						<td><form:errors path="contactNumber"/>
					</tr>
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td>
							<form:radiobutton path="gender" id="male" value="M" label="Male" />
							<form:radiobutton path="gender" id="female" value="F" label="Female" />
						</td>
						<td><form:errors path="gender"/>
							
					</tr>
					<tr>
						<td><form:label path="positionApplied">Position Applied</form:label></td>
						<td><form:select path="positionApplied" items="${positionDtls}" /></td>
						<td><form:errors path="positionApplied" />	
					</tr>
					<tr>
						<td><form:label path="expectedSalary">Expected Salary</form:label></td>
						<td><form:input path="expectedSalary" /></td>
						<td><form:errors path="expectedSalary" id="message"/>						
					</tr>
					<tr>
						<td><form:label path="yearsOfExperience">Experience in years</form:label></td>
						<td><form:input path="yearsOfExperience" /></td>
						<td><form:errors path="yearsOfExperience" />
					</tr>
					<tr>
						<td />
						<td><input type="submit" id="submit" name="submit" value="Register" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form:form>
</body>
</html>
