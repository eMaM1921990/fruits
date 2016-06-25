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
                    	</table>

                       

                        
                       <br/>
                       	<div class="datagrid">
                            <table id="itemstbl">
	                            	<thead>
	                            		<th>Fruit code</th>
	                            		<th>Quantity</th>
	                            		<th>Price</th>
	                            		<th>--</th>
	                            	</thead>
	                            	<tbody>
	                            		<tr id="1">
	                            			<td>
	                            				<div class="select-style">
	                            				
		                            				<select name="itemId" onchange="getItemPrice(this.value,1)" id="itemId">
		                                        		<option>Select Fruit</option>
		                                        		<c:forEach items="${ItemData }" var="c">
		                                        			<option value="${c.id }">${c.code }</option>
		                                        		</c:forEach>
		                                        	</select>
	                                        	</div>
	                            			</td>
	                            			<td><input type="text" name="quantity" id="quantity"/></td>
	                            			<td><input type="text" name="price" id="price_1"/></td>
	                            			<td><a href="javascript:removeRow(1)">remove</a></td>
	                            		</tr>
	                            	</tbody>
                                </table>
                                </div>
                                <div>
                                	<input type="button" value="New row" class="button-style" onclick="addNewRow()"/>
                                	<input type="button" value="Save" class="button-style" onclick="saveData()"/>
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
<script type="text/javascript">
var dict = [];
function convertToDic(Json){
		
	for(var i=0;i<Json.length;i++){
	
		dict[Json[i].id]=Json[i];
	}

}

function getItemPrice(id,index){
	$('#price_'+index).val(dict[id].price);
}


var lastID=1;

function addNewRow(){
	lastID=lastID+1;
	var fruit="<div class='select-style'><select name='itemId' onchange='getItemPrice(this.value,"+lastID+")' id='itemId'><option>Select Fruit</option>";
	for (var key in dict) {
		fruit=fruit+"<option value='"+dict[key].id+"'>"+dict[key].code+"</option>";
	}
	fruit=fruit+"</select></div>";
	var quantity='<input type="text" name="quantity" />';
	var price='<input type="text" name="price" id="price_'+lastID+'"/>';
	var deleteBtn='<a href="javascript:removeRow('+lastID+')">remove</a>';
	var control=deleteBtn;
	$('#itemstbl > tbody:last-child').append('<tr id='+lastID+'><td>'+fruit+'</td><td>'+quantity+'</td><td>'+price+'</td><td>'+control+'</td></tr>');
}


function validateTable(){
	rowData=[];
	$("tbody > tr").each(function() {
        $this = $(this);
        var quantity = $this.find("input[name=quantity]").val();
        var price = $this.find("input[name=price]").val();
        var itemId = $this.find("select[id=itemId]").val();
        
        if(typeof quantity!=='undefined' && quantity.trim().length>0 && typeof price!=='undefined' && price.trim().length>0  && typeof itemId!=='undefined' && itemId.trim().length>0){
        	rowData.push({
              "itemId":parseInt(itemId),
              "price":parseFloat(price),
              "quantity":parseFloat(quantity),
              "code":dict[itemId].code
          });
        }
  });

	return rowData;
	
}

function saveData(){
	
	$.ajax({
		url : "saveToken",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			bpId : $('#bpId').val(),
			isTrx : $('#isTrx').val(),
			data:JSON.stringify(validateTable())
			
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

function removeRow(id){
	$('#'+id).remove();
}

$( document ).ready(function() {
	convertToDic(${ItemDataJSON});
});

</script>