<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.6.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/canvasjs.min.js" />"></script>
<!-- <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script> -->

</style>
<script type="text/javascript">
	window.onload = function() {

		var dps = [ [] ];
		var chart = new CanvasJS.Chart("chartContainer", {
			theme : "dark2", // "light1", "light2", "dark1"
			animationEnabled : true,
			title : {
				text : "Sản Phẩm và Số Lượng Chart"
			},
			axisY : {
				title : "Số Lượng Sản Phẩm",
				includeZero : true,
				prefix : "",
				suffix : ""
			},
			data : [ {
				type : "bar",
				yValueFormatString : "",
				indexLabel : "{y}",
				dataPoints : dps[0]
			} ]
		});

		var yValue;
		var label;

		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		dps[parseInt("${loop.index}")].push({
			label : label,
			y : yValue
		});
		</c:forEach>
		</c:forEach>

		chart.render();

	}
</script>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
</body>
</html>