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

                     <form action="javascript:savePurchase()" name="AddPrintToken" method="post">
                    	<table>
                    		<tr>
                    			<td>Add New purchaser</td>
                    			<td>
                    				<div class="select-style">
                    				
	                    				<select name="bpId" id="bpId">
	                        				<option>Select Seller</option>
	                        				<c:forEach items="${purchaser }" var="cus">
	                        					<option value="${cus.id }">${cus.bpName }</option>
	                        				</c:forEach>
	                        			</select>
                        			</div>
                    			</td>
                    		
                    		</tr>
                    	</table>

                       

                        
                       <br/>
                            <font size="4">  <table>
                                    <tr>
                                        <td>Fruit Name*:</td>
                                        <td>
                                        	<div class="select-style">
                                        	
	                                        	<select name="itemId" onchange="getItemPrice(this.value)" id="itemId">
	                                        		<option>Select Fruit</option>
	                                        		<c:forEach items="${ItemData }" var="c">
	                                        			<option value="${c.id }">${c.name }</option>
	                                        		</c:forEach>
	                                        	</select>
                                        	</div>
                                        </td>
                                            
                              	      </tr>
                                   
                                    <tr>
                                        <td>Type*:</td>
                                        <td><input type="text" name="type" id="type" class="inputs" placeholder="Fruit type"/></td>		
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
                                         <input class="button-style" type="submit" name="commit" value="Save"/>
                                         </td>
                                    </tr>
                                    <input type="hidden" name="isTrx" value="0" id="isTrx"/>
                                </table></font>
                        </form>   
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
<script type="text/javascript">
var dict = [];
function convertToDic(Json){
		
	for(var i=0;i<Json.length;i++){
	
		dict[Json[i].id]=Json[i];
	}

}

function getItemPrice(id){
	$('#price').val(dict[id].price);
}

function savePurchase(){
	$.ajax({
		url : "savePurchase",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			bpId : $('#bpId').val(),
			isTrx : $('#isTrx').val(),
			grandTotal:(parseFloat($('#price').val())*parseFloat($('#quantity').val())),
			data:"[{'itemId':"+$('#itemId').val()+",'id':"+$('#itemId').val()+",'name':"+$('#itemId option:selected').text()+",'quantity':"+$('#quantity').val()+",'price':"+parseFloat($('#price').val())+",'type':"+$('#type').val()+",'code':"+dict[$('#itemId').val()].code.toString()+",'purchase':"+$('#bpId option:selected').text()+",'stockId':1}]"
			
		},
		success : function(responseText) {
			if(responseText.indexOf("[")>-1){
				$('#error').removeAttr('style');
				$('#msg_error').html(responseText);
			}else{
				$('#suc').removeAttr('style');
				$('#msg_suc').html(responseText);

			}
		},
		error : function(xhr, errmsg, err) {
			console.log(errmsg);

		}
	});
}
$( document ).ready(function() {
	convertToDic(${ItemDataJSON});
});

</script>