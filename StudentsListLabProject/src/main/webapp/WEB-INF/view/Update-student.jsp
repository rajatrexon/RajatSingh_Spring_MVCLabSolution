<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./BaseStyle.jsp"%>
<style>
body {
	background-color: teal;
}

* {
	box-sizing: border-box;
}

p {
	text-align: center;
	font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI',
		Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue',
		sans-serif
}

.container {
	margin: auto;
	width: auto;
	padding: 16px;
	background-color: white;
	box-shadow: 20px 20px 20px 0px rgba(0, 0, 0, 0.7);
}
</style>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset md-3">
				<h1 class="text-centre mb-3">Update the Student detail</h1>

				<form
					action="${pageContext.request.contextPath }/student_page/update-student"
					method="post">
					<input type="hidden" value="${student.id }" name="id">
					<div class="form-group">
						<label for="fullname">Full Name</label> <input type="text"
							class="form-control" id="fullname" name="name"
							placeholder="Full Name" value="${student.name }"> <label
							for="dpt"> Department</label> <input type="text"
							class="form-control" id="dpt" name="department"
							placeholder="Department Name" value="${student.department }">
						<label for="ctry">Country</label> <input type="text"
							class="form-control" id="ctry" name="country"
							placeholder="Country Name" value="${student.country}">
					</div>

					<div class="container text-centre">
						<button type="submit" class="btn btn-primary">Update
							Student</button>
				</form>


				<a href="/StudentsListLabProject/student_page/show"
					class="btn btn-outline-danger">Back</a>

			</div>
		</div>
	</div>

</body>
</html>