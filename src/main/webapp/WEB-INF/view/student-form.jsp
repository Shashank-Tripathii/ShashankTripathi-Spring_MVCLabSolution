<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student form</title>
<!--  
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${Css}" rel="stylesheet" />
-->
</head>
<body>
<div style="background-color:#ADD8E6">
	<hr width="100%" size="1" />
	<h1 align="middle" >Student Registration</h1>

	<hr width="100%" size="1" />
</div>
	<div align="center">
		<h4>${mode} Student Details</h4>
		<form action="save" method="post" style="background-color:grey;width: 450px;height:150px">
			<table style="with: 80%">
				<tr>
					<input type="hidden" name="id" value="${studentObj.id}">
				<tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" value="${studentObj.firstName}"></td>
				</tr>
				
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"
						value="${studentObj.lastName}"></td>
				</tr>
				<tr>
					<td>Student Course:</td>
					<td><input type="text" name="studentCourse"
						value="${studentObj.studentCourse}"></td>
				</tr>
				<tr>
					<td>Student Country:</td>
					<td><input type="text" name="studentCountry"
						value="${studentObj.studentCountry}"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Save/Update">
			
			<button><a href="/StudentManagement">Home</a></button>
		</form>
	</div>
</body>
</html>