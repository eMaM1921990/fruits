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

                     <form action="javascript:saveToken()" name="AddPrintToken" method="post">
                    	<table>
                    		<tr>
                    			<td>Sales Bill To :</td>
                    			<td>
                    				<div class="select-style">
                    				
	                    				<select name="bpId" id="bpId" onchange="getBalance(this.value)">
	                        				<option>Select Seller</option>
	                        				<c:forEach items="${customer }" var="cus">
	                        					<option value="${cus.id }">${cus.bpName }</option>
	                        				</c:forEach>
	                        			</select>
                        			</div>
                    			</td>
                    		
                    		</tr>
                    		<tr>
                    				<td>Current Balance : </td><td><p id="balance">Rs .0</td>
                    		</tr>
                    		
                    	</table>

                       

                        
                       <br/>
                            <font size="4">  <table>
                                    <tr>
                                        <td>Fruit Code*:</td>
                                        <td>
                                        	<div class="select-style">
                                        	
	                                        	<select name="itemId" onchange="getItemPrice(this.value)" id="itemId">
	                                        		<option>Select Fruit</option>
	                                        		<c:forEach items="${ItemData }" var="c">
	                                        			<option value="${c.id }">${c.code } | ${c.name } | ${c.type }</option>
	                                        		</c:forEach>
	                                        	</select>
                                        	</div>
                                        </td>
                                            
                                    </tr>
                                   
                                   <tr>
                                        <td>Fruit Name / Type :</td>
                                        <td><input type="text" name="name" id="name" class="inputs" placeholder="Fruit Name / Type" readonly="readonly"/></td>		
                                    </tr>
                                    
                                    <tr>
                                        <td>Quantity*:</td>
                                        <td><input type="text" name="quantity" id="quantity" class="inputs" placeholder="Quantity"/></td>		
                                    </tr>
                                    <tr>
                                        <td>Price:</td>
                                        <td><input type="text" name="price" id="price" class="inputs" placeholder="Price"/></td>		
                                    </tr>
                                    <tr>
                                        <td colspan="2">  
                                         <input class="button-style" type="submit" name="commit" value="Print Token"/>
                                         </td>
                                    </tr>
                                    <input type="hidden" name="isTrx" value="1" id="isTrx"/>
                                </table></font>
                        </form>   
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
<script type="text/javascript">
var dict = [];
function convertToDic(Json){
		
	for(var i=0;i<Json.length;i++){
	
		dict[Json[i].id]=Json[i];
	}

}


var customers=[];
function CustomerDic(Json){
	
	for(var i=0;i<Json.length;i++){
	
		customers[Json[i].id]=Json[i];
	}

}

function getBalance(id){
	$('#balance').html('Rs. '+customers[id].balance);
	
}

function getItemPrice(id){
	$('#price').val(dict[id].price);
	$('#name').val(dict[id].name+" / "+dict[id].type);
}

function saveToken(){
	$.ajax({
		url : "saveToken",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			token:0,
			bpId : $('#bpId').val(),
			isTrx : $('#isTrx').val(),
			grandTotal:(parseFloat($('#price').val())*parseFloat($('#quantity').val())),
			data:"[{'itemId':"+$('#itemId').val()+",'quantity':"+$('#quantity').val()+",'price':"+parseFloat($('#price').val())+",'code':"+dict[$('#itemId').val()].code.toString()+"}]"
			
		},
		success : function(responseText) {
			if(responseText.indexOf("[")>-1){
				$('#error').removeAttr('style');
				$('#msg_error').html(responseText);
			}else{
				$('#suc').removeAttr('style');
				$('#msg_suc').html(responseText.split(":")[0]);
				
				var doc=$('#pdfDocument').attr('src',"tmp/"+responseText.split(":")[1]);
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
$( document ).ready(function() {
	convertToDic(${ItemDataJSON});
	CustomerDic(${customerJson});
	$('#balanceRow').hide();
});


function printTrigger(elementId) {

	var getMyFrame = document.getElementById(elementId);
    getMyFrame.focus();
    getMyFrame.contentWindow.print();

}

</script>