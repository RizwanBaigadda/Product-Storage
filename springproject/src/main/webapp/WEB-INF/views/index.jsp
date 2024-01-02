<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./base.jsp"%>

<style>
body {
	background-image: url('https://picsum.photos/1920/1080');
	/* Specify the URL of your image */
	background-size: cover;
	/* Ensures the image covers the entire background */
	background-position: center;
	/* Centers the image horizontally and vertically */
	background-repeat: no-repeat; /* Prevents the image from repeating */
}

/* You can add additional styling for other elements if needed */
.container {
	background-color: rgba(255, 255, 255, 0.8);
	/* Add a semi-transparent white background to the container */
	padding: 20px;
	margin-top: 20px;
	border-radius: 10px;
}

.table {
	background-color: rgba(255, 255, 255, -5);
	/* Adjust the alpha channel for transparency */
}

.table thead th {
    background-color: #343a40; /* Set a dark color for the table header */
    color: white; /* Set the text color for the table header */
}

.table tbody td {
    background-color: #f8f9fa; /* Set a light color for the table body */
}

/* Add styling for other elements as needed */
</style>

</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Product Page</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${products}" var="product">
							<tr>
								<th scope="row">${product.pid}</th>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td class="font-weight-bold">&#x20B9 ${product.price}</td>
								<td><a href="deleteproduct/${product.pid}"><i
										class="fas fa-trash-alt"></i></a> <a
									href="updateproduct/${product.pid}"><i
										class="fas fa-pen-nib text-primary"></i></a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>
				</div>
			</div>

		</div>

	</div>









</body>
</html>
