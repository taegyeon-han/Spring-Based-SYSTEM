<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8">

<!-- jQuery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<!-- common CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/common/css/common.css">

<style>
body {
	padding: 0px
}

#tile_header {
	width: 100%;
}

#tile_body {
	width: 100%;
	float: left;
}
</style>


</head>
<body>
	<div id="tile_header">
		<tiles:insertAttribute name="tile_header" />
	</div>

	<div id="tile_body">
		<tiles:insertAttribute name="tile_body" />
	</div>
</body>