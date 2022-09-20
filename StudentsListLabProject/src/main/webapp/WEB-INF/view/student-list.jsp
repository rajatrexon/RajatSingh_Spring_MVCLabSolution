<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.container {
	margin: auto;
	width: 70%;
	padding: 16px;
	background-color: white;
	box-shadow: 20px 20px 20px 0px rgba(0, 0, 0, 0.7);
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="./BaseStyle.jsp"%>


<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div class="container  my-3 bg-dark text-white">
		<h2>Students List</h2>
	</div>


	<div class="container mt-2"'>

		<a href="/StudentsListLabProject/student_page/add-student-button"
			class="btn btn-outline-success">Add Student</a>
<a href="/StudentsListLabProject/"  class ="btn btn-danger" style="float:right">Back</a>
		<table class="table table-hover">

			<thead>

				<tr class="thead-dark">
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Department</th>
					<th scope="col">Country</th>
					<th scope="colgroup">Action</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${studentsList}" var="stu">
					<tr>
						<th scope="row">${stu.id}</th>
						<td>${stu.name}</td>
						<td>${stu.department}</td>
						<td>${stu.country}</td>
						<td><a href="delete/${stu.id}"><i
								class="fas fa-trash-alt text-danger"></i></a> &nbsp;&nbsp; <a
							href="update/${stu.id}"><i class="fas fa-user-edit"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>