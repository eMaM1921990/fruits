<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html >
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <title>SL Fruits</title>
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
        <link href='http://fonts.googleapis.com/css?family=Abel|Satisfy' rel='stylesheet' type='text/css' />
        <link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
          <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
        
        <!--[if IE 6]>
        <link href="default_ie6.css" rel="stylesheet" type="text/css" />
        <![endif]-->

    </head>
    <body>
        <div id="header-wrapper">
            <div id="header">
                <div id="logo">
                    <h1>
                        <a href="#">SL Fruits</a>
                    </h1>
                </div>
                <%@ include file="../menu.jsp"%>

            </div>

        </div>
        <div id="wrapper">
            <div id="page-wrapper">
                <div id="page">
                    <div id="content">
                   	<%@include file="../notification.jsp" %>

                    	<table>
                    		<tr>
                    			<td>Date from:</td>
                    			<td><input type="text" id="datefrom"></td>
                    		
                    		</tr>
                    		<tr>
                    			<td>Date to:</td>
                    			<td><input type="text" id="dateto"></td>
                    		
                    		</tr>
                    		
                    		<tr>
                    			<td colspan="1"><input type="button" class="button-style" value="Get Invoice" onclick="getLastDateInvoice()"/></td>
                    		</tr>
                    	</table>

                       

                        
                       <br/>
                       	<div class="datagrid">
                            <table id="itemstbl" >
	                            	<thead>
	                            		<th>Date</th>
	                            		<th>Fruit </th>
	                            		<th>Quantity</th>
	                            		<th>Price</th>
	                            	</thead>
	                            	<tbody>
	                            	</tbody>
                                </table>
                                </div>
                               
                                
                                
                                <input type="hidden" name="isTrx" value="0" id="isTrx"/>
                    </div>
                    <%@ include file="../purchase_sidebar.jsp"%>

                </div>
            </div>
        </div>
        <div id="footer" class="container">
            <p>&copy; All rights reserved. Design by SL Fruits</p>
        </div>
    </body>
</html>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">


function getLastDateInvoice(){
	
	$.ajax({
		url : "ajax_getTransactions",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			datefrom : $('#datefrom').val(),
			dateto : $('#dateto').val(),
			isTrx:$('#isTrx').val()
			
		},
		success : function(responseText) {
			addNewRow(responseText);
		},
		error : function(xhr, errmsg, err) {
			console.log(errmsg);

		}
	});
}


var lastID=1;

function addNewRow(Json){
	$("#itemstbl > tbody:last-child").empty();

	for(var i=0;i<Json.length;i++){
		lastID=lastID+1;
		var fruit=Json[i].name;
		var quantity=Json[i].quantity;
		var price=Json[i].price;
		var date=Json[i].date;
		$('#itemstbl > tbody:last-child').append('<tr ><td>'+date+'</td><td>'+fruit+'</td><td>'+quantity+'</td><td>'+price+'</td></tr>');
}
}





$( document ).ready(function() {
	 $( "#datefrom" ).datepicker({ dateFormat: 'dd-mm-yy' });
	 $( "#dateto" ).datepicker({ dateFormat: 'dd-mm-yy' });
});

</script>