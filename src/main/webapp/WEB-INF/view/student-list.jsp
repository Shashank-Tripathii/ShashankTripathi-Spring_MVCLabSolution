<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Students</title>
</head>
<body>
	<div name="headings" style="background-color: #ADD8E6">
		<hr width="100%" size="5" />
		<h1 align="middle">Student Lists with Details</h1>

		<br>
		<hr width="100%" size="5" />
	</div>

	<div align="center">

		<table cellspacing="1" cellpadding="10" bgcolor="#ADD8E6">



			<h3>List of Students</h3>


			<thead>
				<tr bgcolor="#ffffff">
					<th align="left" size="3">First Name</th>
					<th align="left" size="3">Last Name</th>
					<th align="left" size="3">Course</th>
					<th align="left" size="3">Country</th>
					<th align="center" size="3">Action</th>
				</tr>
			</thead>
			<c:forEach items="${students}" var="s">
				<tr bgcolor="#ffffff">
					<td>${s.firstName}</td>
					<td>${s.lastName}</td>
					<td>${s.studentCourse}</td>
					<td>${s.studentCountry}</td>
					<td><button>
							<a href="updateStudent?id=${s.id}">Update</a>
						</button>
						<button>
							<a href="removeStudent?id=${s.id}">Delete</a></td>
					</button>
				</tr>
			</c:forEach>

		</table>
		<br>
		<button align="left">
			<a href="/StudentManagement/student/addform">Add New Student</a>
		</button>
		<button align="right">
			<a href="/StudentManagement">Home</a>
		</button>
	</div>


</body>
</html>