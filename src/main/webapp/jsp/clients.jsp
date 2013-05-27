<%@ page trimDirectiveWhitespaces="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Clients</title>
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
				<input type="button" value="Add Client" onclick="addClient()"/>
				<br>
				<br>				
				<table class="mainTable">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Patronymic</th>
						<th>Passport</th>
						<th>Address</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Birthday</th>
						<th class="operationCol">Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clients}" var="client">
						<tr id="tr_${client.id}">
							<td>${client.firstName}</td>
							<td>${client.lastName}</td>
							<td>${client.patronymic}</td>
							<td>${client.pase}</td>
							<td>${client.address}</td>
							<td>${client.email}</td>
							<td>${client.phone}</td>
							<td>${client.birthday}</td>
							<td class="operationCol"><a href="javascript:deleteClient(${client.id},'${client.seller}')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div id="addClientDlg" style="display:none" title="New Client">
	<form id="addClientForm" action="" method="POST">
	<table>
	<tr>
	<td><input type="text" name="firstName" placeholder="first name"/></td>
	</tr>
	<tr>
	<td><input type="text" name="lastName" placeholder="last name"/></td>
	</tr>
	<tr>
	<td><input type="text" name="passport" placeholder="passport"/></td>
	</tr>
	<tr>
	<td><input type="text" name="email" placeholder="email"/></td>
	</tr>
	<tr>
	<td><input type="text" name="phone" placeholder="phone"/></td>
	</tr>
	<tr>
	<td><input type="text" name="address" placeholder="address"/></td>
	</tr>
	<tr>
	<td><input type="text" name="patronymic" placeholder="patronymic"/></td>
	</tr>
	</table>
	</form>
</div>

<script type="text/javascript">
	function addClient(){
		$('#addClientDlg').dialog({modal:true, width:380, height:'auto', buttons: {
            'Add': function() {
				$('#addClientForm').submit();
            },
            'Cancel': function() {
                $(this).dialog('close');
            }
        }});
	}
	function deleteClient(id, isSeller){
		if(confirm("Are you shure to delete client?")){
			var deleteUrl;
			if(isSeller=='true'){
				deleteUrl="${sellers_url}/"+id;
			}else{
				deleteUrl="${clients_url}/"+id;				
			}
			$.ajax({url:deleteUrl,
	        	type:'DELETE'
	        }).done(function() {
	        	$('#tr_'+id).remove();
	        });
		}
	}
</script>

</body>
</html>