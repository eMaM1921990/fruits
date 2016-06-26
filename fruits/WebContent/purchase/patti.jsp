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
                    			<td>Generate Patti</td>
                    			
                    		
                    		</tr>
                    	</table>

                       

                        
                       <br/>
                       	<div class="datagrid">
                            <table id="itemstbl">
	                            	<thead>
	                            		<th>Fruit code</th>
	                            		<th>Avg. Cost</th>
	                            		<th>Avg. Quantity</th>
	                            		<th>Actual cost</th>
	                            		<th>Actual quantity</th>
	                            		<th>Commission percentage</th>
	                            		<th>Cooli</th>
	                            		<th>Lorry charges</th>
	                            		<th>Balance</th>
	                            		<th>--</th>
	                            	</thead>
	                            	<tbody>
	                            		<tr id="1">
	                            			<td>
	                            				<div class="select-style">
	                            				
		                            				<select name="itemId" onchange="getInvoicePurchaser(this.value,1);getItemActualCost(this.value,1);getAvg(this.value,1);balance(1)" id="itemId">
		                                        		<option>Select Fruit</option>
		                                        		<c:forEach items="${ItemData }" var="c">
		                                        			<option value="${c.id }">${c.code }</option>
		                                        		</c:forEach>
		                                        	</select>
	                                        	</div>
	                            			</td>
	                            			<td><input type="hidden" id="purchaser_1" name="purchaser"><input type="text" name="avgCost" id="avgCost_1" style="width: 50px"/></td>
	                            			<td><input type="text" name="avgQuantity" id="avgQuantity_1" style="width: 50px"/></td>
	                            			<td><input type="text" name="actualCost" id="actualCost_1" style="width: 50px;color:red" readonly="readonly"/></td>
	                            			<td><input type="text" name="actualQuantity" id="actualQuantity_1" style="width: 50px;color:red" readonly="readonly"/></td>
	                            			<td><input type="text" name="commissionPercent" id="commissionPercent_1" style="width: 50px" value="0" onkeyup="balance(1)"/></td>
	                            			<td><input type="text" name="cooli" id="cooli_1" style="width: 50px" style="width: 50px" value="0" onkeyup="balance(1)"/></td>
	                            			<td><input type="text" name="lorryCharges" id="lorryCharges_1" style="width: 50px" value="0" onkeyup="balance(1)"/></td>
	                            			<td><input type="text" name="balance" id="balance_1" style="width: 50px;color:green" readonly="readonly"/></td>
	                            			<td><a href="javascript:removeRow(1)">remove</a></td>
	                            		</tr>
	                            	</tbody>
                                </table>
                                </div>
                                <div>
                                	<input type="button" value="New row" class="button-style" onclick="addNewRow()"/>
                                	<input type="button" value="Save" class="button-style" onclick="saveData()"/>
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
<script type="text/javascript">
var dict = [];
function convertToDic(Json){
		
	for(var i=0;i<Json.length;i++){
	
		dict[Json[i].id]=Json[i];
	}

}

function getItemActualCost(id,index){
	$('#actualCost_'+index).val(dict[id].price*dict[id].quantity);
	$('#actualQuantity_'+index).val(dict[id].quantity);
}


var lastID=1;

function addNewRow(){
	lastID=lastID+1;
	var fruit="<div class='select-style'><select name='itemId' onchange='getInvoicePurchaser(this.value,"+lastID+");getItemActualCost(this.value,"+lastID+");getAvg(this.value,"+lastID+");balance("+lastID+")' id='itemId'><option>Select Fruit</option>";
	for (var key in dict) {
		fruit=fruit+"<option value='"+dict[key].id+"'>"+dict[key].code+"</option>";
	}
	fruit=fruit+"</select></div>";
	var purchaser='<input type="hidden" id="purchaser_'+lastID+'" name="purchaser"/>';
	var avgCost='<input type="text" name="avgCost" id="avgCost_'+lastID+'" style="width: 50px"/>';
	var avgQuantity='<input type="text" name="avgQuantity" id="avgQuantity_'+lastID+'" style="width: 50px"/>';
	var actualCost='<input type="text" name="actualCost" id="actualCost_'+lastID+'" style="width: 50px;color:red" readonly="readonly"/>';
	var actualQuantity='<input type="text" name="actualQuantity" id="actualQuantity_'+lastID+'" style="width: 50px;color:red" readonly="readonly"/>';
	var commissionPercent='<input type="text" name="commissionPercent" id="commissionPercent_'+lastID+'" style="width: 50px" value="0" onkeyup="balance('+lastID+')"/>';
	var cooli='<input type="text" name="cooli" id="cooli_'+lastID+'" style="width: 50px" style="width: 50px" value="0" onkeyup="balance('+lastID+')"/>';
	var lorryCharges='<input type="text" name="lorryCharges" id="lorryCharges_'+lastID+'" style="width: 50px" value="0" onkeyup="balance('+lastID+')"/>';
	var balance='<input type="text" name="balance" id="balance_'+lastID+'" style="width: 50px;color:green" readonly="readonly"/>';
	var deleteBtn='<a href="javascript:removeRow('+lastID+')">remove</a>';
	var control=deleteBtn;
	$('#itemstbl > tbody:last-child').append('<tr id='+lastID+'><td>'+purchaser+fruit+'</td><td>'+avgCost+'</td><td>'+avgQuantity+'</td><td>'+actualCost+'</td><td>'+actualQuantity+'</td><td>'+commissionPercent+'</td><td>'+cooli+'</td><td>'+lorryCharges+'</td><td>'+balance+'</td><td>'+control+'</td></tr>');
}


function validateTable(){
	rowData=[];
	$("tbody > tr").each(function() {
        $this = $(this);
        var purchaser = $this.find("input[name=purchaser]").val();
        var avgCost = $this.find("input[name=avgCost]").val();
        var avgQuantity = $this.find("input[name=avgQuantity]").val();
        var actualCost = $this.find("input[name=actualCost]").val();
        var actualQuantity = $this.find("input[name=actualQuantity]").val();
        var commissionPercent = $this.find("input[name=commissionPercent]").val();
        var cooli = $this.find("input[name=cooli]").val();
        var lorryCharges = $this.find("input[name=lorryCharges]").val();
        var balance = $this.find("input[name=balance]").val();
        var itemId=$this.find("select[id=itemId]").val()
        
        if(typeof purchaser!=='undefined' && purchaser.trim().length>0 ){
        	rowData.push({
              "code":dict[parseInt(itemId)].code,
              "balance":parseFloat(balance),
              "loory":parseFloat(lorryCharges),
              "cooli":parseFloat(cooli),
              "commissionPercent":parseFloat(commissionPercent),
              "actualQuantity":parseInt(actualQuantity),
              "actualCost":parseFloat(actualCost),
              "avgQuantity":parseInt(avgQuantity),
              "avgCost":parseFloat(avgCost),
              "bpId":parseInt(purchaser),
          });
        }
  });

	return rowData;
	
}

function getInvoicePurchaser(id,index){
	$.ajax({
		url : "ajax_getInvoicePurchaser",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			code :dict[id].code
			
		},
		success : function(responseText) {
				console.log(responseText);
				// render return json
				$('#purchaser_'+index).val(responseText.bpId);

			
		},
		error : function(xhr, errmsg, err) {
			console.log(errmsg);

		}
	});
}

function getAvg(id,index){
	$.ajax({
		url : "ajax_avgCost",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			code :dict[id].code
			
		},
		success : function(responseText) {
				console.log(responseText);
				// render return json
				$('#avgCost_'+index).val(responseText.price);
				$('#avgQuantity_'+index).val(responseText.quantity);

			
		},
		error : function(xhr, errmsg, err) {
			console.log(errmsg);

		}
	});
}

function saveData(){
	
	$.ajax({
		url : "savePatti",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
		
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


function balance(index){
	var cost=$('#actualCost_'+index).val();
	var commission=$('#commissionPercent_'+index).val();
	var cooli=$('#cooli_'+index).val();
	var lorry=$('#lorryCharges_'+index).val();
	
	var totalDeduct=(parseFloat(cost)*parseFloat(commission)/100)+parseFloat(cooli)+parseFloat(lorry);
	var balance=parseFloat(cost)-totalDeduct;
	$('#balance_'+index).val(balance);
	
}

function removeRow(id){
	$('#'+id).remove();
}

$( document ).ready(function() {
	convertToDic(${ItemDataJSON});
});

</script>