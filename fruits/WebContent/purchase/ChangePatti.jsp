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
                    			<td>Change Patti</td>
                    			<td>
                    				<div class="select-style">
                           						<select name="pattiId" id="pattiId" onchange="pattiDetail(this.value)">
                           							<option>Select Patti</option>
				                        				<c:forEach items="${patti }" var="p">
				                        					<option value="${p.id }">${p.id }</option>
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
	                            		<th>Avg. Cost</th>
	                            		<th>Avg. Quantity</th>
	                            		<th>Actual cost</th>
	                            		<th>Actual quantity</th>
	                            		<th>Commission percentage</th>
	                            		<th>Cooli</th>
	                            		<th>Lorry charges</th>
	                            		<th>Balance</th>
	                            	</thead>
	                            	<tbody>
	                            		
	                            	</tbody>
                                </table>
                                </div>
                                <div>
                                	<input type="button" value="Update" class="button-style" onclick="saveData()"/>
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

function parseRows(JSON){
	lastID=lastID+1;
	for(var i=0;i<JSON.length;i++){
		var fruit='<input type="hidden" value="'+JSON[i].id+'" name="id"/><input type="text"  name="code" value="'+JSON[i].code+'" readonly="readonly"/>';
		var purchaser='<input type="hidden" id="purchaser_'+lastID+'" name="purchaser" value="'+JSON[i].bpId+'"/>';
		var avgCost='<input type="text" name="avgCost" id="avgCost_'+lastID+'" style="width: 50px" value="'+JSON[i].avgCost+'"/>';
		var avgQuantity='<input type="text" name="avgQuantity" id="avgQuantity_'+lastID+'" style="width: 50px" value="'+JSON[i].avgQuantity+'"/>';
		var actualCost='<input type="text" name="actualCost" id="actualCost_'+lastID+'" style="width: 50px;color:red" readonly="readonly" value="'+JSON[i].actualCost+'"/>';
		var actualQuantity='<input type="text" name="actualQuantity" id="actualQuantity_'+lastID+'" style="width: 50px;color:red" readonly="readonly" value="'+JSON[i].actualQuantity+'"/>';
		var commissionPercent='<input type="text" name="commissionPercent" id="commissionPercent_'+lastID+'" style="width: 50px" onkeyup="balance('+lastID+')" value="'+JSON[i].commissionPercent+'"/>';
		var cooli='<input type="text" name="cooli" id="cooli_'+lastID+'" style="width: 50px" style="width: 50px"  onkeyup="balance('+lastID+')" value="'+JSON[i].loory+'"/>';
		var lorryCharges='<input type="text" name="lorryCharges" id="lorryCharges_'+lastID+'" style="width: 50px"  onkeyup="balance('+lastID+')" value="'+JSON[i].cooli+'"/>';
		var balance='<input type="text" name="balance" id="balance_'+lastID+'" style="width: 50px;color:green" readonly="readonly" value="'+JSON[i].balance+'"/>';
		$('#itemstbl > tbody:last-child').append('<tr id='+lastID+'><td>'+purchaser+fruit+'</td><td>'+avgCost+'</td><td>'+avgQuantity+'</td><td>'+actualCost+'</td><td>'+actualQuantity+'</td><td>'+commissionPercent+'</td><td>'+cooli+'</td><td>'+lorryCharges+'</td><td>'+balance+'</td></tr>');
	}
	
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
        var id=$this.find("input[name=id]").val();
        
        if(typeof purchaser!=='undefined' && purchaser.trim().length>0 ){
        	rowData.push({
              "code":dict[parseInt(itemId)].code,
              "balance":parseFloat(balance),
              "lorryCharges":parseFloat(lorryCharges),
              "cooli":parseFloat(cooli),
              "commissionPercent":parseFloat(commissionPercent),
              "actualQuantity":parseInt(actualQuantity),
              "actualCost":parseFloat(actualCost),
              "avgQuantity":parseInt(avgQuantity),
              "avgCost":parseFloat(avgCost),
              "bpId":parseInt(purchaser),
              "id":parseInt(id)
          });
        }
  });

	return rowData;
	
}

function pattiDetail(id){
	$.ajax({
		url : "ajax_pattiDetails",
		type : "POST",
		dataType : "json",
		async:false,
		data : {
			pattiId :id
			
		},
		success : function(responseText) {
				// render return json
				console.log(responseText);
				parseRows(responseText);
			
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