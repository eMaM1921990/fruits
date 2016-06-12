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
                    			<td>Date :</td>
                    			<td><input type="text" id="date"></td>
                    		</tr>
                    		<tr>
                    			<td colspan="1"><input type="button" class="button-style" value="Get Invoice" onclick="getInvoice()"/></td>
                    		</tr>
                    	</table>

                       

                        
                       <br/>
                       	<div class="datagrid">
                            <table id="itemstbl" >
	                            	<thead>
	                            		<th>Fruit </th>
	                            		<th>Quantity</th>
	                            		<th>Price</th>
	                            		<th>--</th>
	                            	</thead>
	                            	<tbody>
	                            	</tbody>
                                </table>
                                </div>
                               
                                
                                
                                <input type="hidden" name="isTrx" value="1" id="isTrx"/>
                    </div>
                    <%@ include file="../sales_sidebar.jsp"%>

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


function getInvoice(){
	
	$.ajax({
		url : "ajax_getInvoice",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			bpId : $('#bpId').val(),
			isTrx : $('#isTrx').val(),
			date:$('#date').val()
			
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
		var quantity='<input type="text" name="quantity" value="'+Json[i].quantity+'" onkeyup="showUpdate('+Json[i].id+')"/>';
		var price='<input type="text" name="price" id="price_'+lastID+'" value="'+Json[i].price+'" onkeyup="showUpdate('+Json[i].id+')"/>';
		var deleteBtn='<a href="javascript:removePurchase('+Json[i].id+')">remove</a>';
		var updateBtn='<a href="javascript:update('+Json[i].id+')" style="color:chartreuse;display:none" id="update_'+Json[i].id+'">update</a> ';
		var control=updateBtn+deleteBtn;
		$('#itemstbl > tbody:last-child').append('<tr id='+Json[i].id+'><td>'+fruit+'</td><td>'+quantity+'</td><td>'+price+'</td><td>'+control+'</td></tr>');
	}	
}

function showUpdate(id){
	$('#update_'+id).removeAttr('style');
	$('#update_'+id).attr('style','color:chartreuse');
}


function removePurchase(id){
	$.ajax({
		url : "ajax_removePurchase",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			id : id,
			
		},
		success : function(responseText) {
			if(responseText.indexOf("[")>-1){
				$('#error').removeAttr('style');
				$('#msg_error').html(responseText);
			}else{
				$('#suc').removeAttr('style');
				$('#msg_suc').html(responseText);
				removeRow(id);
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

$( document ).ready(function() {
	 $( "#date" ).datepicker({ dateFormat: 'dd-mm-yy' });
});

</script>