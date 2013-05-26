<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/api.js"/>"></script>
	<link type="text/css" rel="stylesheet" media="all" href="<c:url value="/css/jquery-ui.css"/>" />
    <link type="text/css" rel="stylesheet" media="all" href="<c:url value="/css/style.css"/>"/>    
	<!--[if IE]>
	<link type="text/css" rel="stylesheet" media="all" href="<c:url value="/css/ie.css"/>"/>
	<![endif]-->
	<!--[if IE 7]>
	<link type="text/css" rel="stylesheet" media="all" href="<c:url value="/css/ie7.css"/>"/>
	<![endif]-->
</head>

<body>

<div id="wrapper">
	<div id="header">
        <c:import url="/jsp/header.jsp"/>
	</div>
	<div id="main">
		<div id="container">
			<div id="content">
				<input type="button" value="Add Sale" onclick="addSale()"/>
				<br>
				<br>				
				<table class="mainTable">
				<thead>
					<tr>
						<th>Client</th>
						<th>Seller</th>
						<th>Car</th>
						<th>Price</th>
						<th>Date</th>
						<th class="operationCol">Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sales}" var="sale">
						<tr>
							<td>${clients[sale.clientId].firstName}&nbsp;${clients[sale.clientId].firstName}</td>
							<td>${sellers[sale.sellertId].firstName}&nbsp;${sellers[sale.sellerId].firstName}</td>
							<td>${sale.vin}</td>
							<td>${sale.price}</td>
							<td>${sale.date}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div id="addSaleDlg" style="display:none" title="New Sale">
	<form id="addSaleForm" action="" method="POST">
	<table>
	<tr>
	<td>
		Client: 
		<select name="clientId">
		<c:forEach items="${clients}" var="client">
			<option value="${client.id}">${client.firstName}&nbsp;${client.lastName}</option>
		</c:forEach>
		</select>
	</td>
	</tr>
	<tr>
	<td>
		Seller: 
		<select name="sellerId">
		<c:forEach items="${sellers}" var="seller">
			<option value="${seller.id}">${seller.firstName}&nbsp;${seller.lastName}</option>
		</c:forEach>
		</select>
	</td>
	</tr>
	<tr>
	<td><input type="text" name="vin" placeholder="vin"/></td>
	</tr>
	<tr>
	<td><input type="text" name="price" placeholder="price"/></td>
	</tr>
	</table>
	</form>
</div>

<script type="text/javascript">
	function addSale(){
		$('#addSaleDlg').dialog({modal:true, width:380, height:'auto', buttons: {
            'Add': function() {
				$('#addSaleForm').submit();
            },
            'Cancel': function() {
                $(this).dialog('close');
            }
        }});
	}
</script>

</body>
</html>