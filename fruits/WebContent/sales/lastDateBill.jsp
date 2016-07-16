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
                    			<td>Sales Bill To</td>
                    			<td>
                    				<div class="select-style">
                    				
	                    				<select name="bpId" id="bpId">
	                        				<option>Select Seller</option>
	                        				<c:forEach items="${customer }" var="cus">
	                        					<option value="${cus.id }">${cus.bpName }</option>
	                        				</c:forEach>
	                        			</select>
	                        		</div>
                    			</td>
                    		
                    		</tr>
                    		
                    		<tr>
                    				<td>Previous Balance : </td><td><p id="balance">Rs .0</td>
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
                        <div class="datagrid">
                        	<table>
                        		<tr><td >Total: </td><td><p id="total">Rs. 0</td></tr>
                        		<tr><td >Total Balance : </td><td><p id="totalBalance">Rs. 0</td></tr>
                        		
                        	</table>
                        </div>
                        <input type="button" class="button-style" value="Print" onclick="print()"/><input type="hidden" id="id"/>
                        
                               
                                
                                
                                <input type="hidden" name="isTrx" value="1" id="isTrx"/>
                    </div>
                    <%@ include file="../sales_sidebar.jsp"%>

                </div>
            </div>
        </div>
        <div id="footer" class="container">
            <p>&copy; All rights reserved. Design by SL Fruits</p>
        </div>
                <iframe  src="" id="pdfDocument" style="display: none;" ></iframe>
        
    </body>
</html>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">

var customers=[];
function CustomerDic(Json){
	
	for(var i=0;i<Json.length;i++){
	
		customers[Json[i].id]=Json[i];
	}

}


function getBalance(id){
	return customers[id].balance;
	
}

function getLastDateInvoice(){
	
	$.ajax({
		url : "ajax_getLastInvoice",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			bpId : $('#bpId').val(),
			isTrx : $('#isTrx').val(),
			
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
	var total=0;
	for(var i=0;i<Json.length;i++){
		lastID=lastID+1;
		var fruit=Json[i].name;
		var quantity=Json[i].quantity;
		var price=Json[i].price;
		var date=Json[i].date;
		total=total+(Json[i].quantity*Json[i].price);
		$('#id').val(Json[i].invoiceId);
		$('#itemstbl > tbody:last-child').append('<tr ><td>'+date+'</td><td>'+fruit+'</td><td>'+quantity+'</td><td>'+price+'</td></tr>');
	}
	
	//display pervious balance
	var balance=getBalance($('#bpId').val());
	var pervious=balance-total;
	$('#balance').html('Rs. '+pervious);
	$('#total').html('Rs. '+total);
	$('#totalBalance').html('Rs. '+balance);
}


function print(){
	$.ajax({
		url : "ajax_printInvoice",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			invoiceId : $('#id').val()
			
		},
		success : function(responseText) {
			if(responseText.indexOf("[")>-1){
				$('#error').removeAttr('style');
				$('#msg_error').html(responseText);
			}else{
				
				var doc=$('#pdfDocument').attr('src',"tmp/"+responseText);
				$('#pdfDocument').load(function() {
					printTrigger('pdfDocument');
			      });

			}
		},
		error : function(xhr, errmsg, err) {
			console.log(errmsg);

		}
	});
}


function removeRow(id){
	$('#'+id).remove();
}


function printTrigger(elementId) {

	var getMyFrame = document.getElementById(elementId);
    getMyFrame.focus();
    getMyFrame.contentWindow.print();

}


$( document ).ready(function() {

	CustomerDic(${customerJson});

});


</script>