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

                     <form action="javascript:saveLoan()" >
                            <table>
                            		<tr>
                           				<td>
                           					<div class="select-style">
                           						<select name="bpId" id="bpId">
                           							<option>Select employee</option>
				                        				<c:forEach items="${empData }" var="cus">
				                        					<option value="${cus.id }">${cus.bpName }</option>
				                        				</c:forEach>
                           						</select>
                           					</div>
                           				</td>
                            		</tr>
                            		
                            		<tr>
                                    	<td>
                                    		<input type="text" name="needToPay" id="needToPay" class="inputs" placeholder="Neet to pay" />
                                    	</td>
                                    </tr>
                                    
                              
                                    <tr>
                                    	<td>
                                    		<input type="text" name="paid" id="paid" class="inputs" placeholder="Amount" />
                                    	</td>
                                    </tr>
                                    
                                    
                                    <tr>
                                        <td >  
                                         <input class="button-style" type="submit" name="commit" value="save"/>
                                         </td>
                                    </tr>
                            </table>
                        </form>   
                    </div>
                    <%@ include file="../employeeSideBar.jsp"%>

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
function saveLoan(){
	
	$.ajax({
		url : "savePayback",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			bpId : $('#bpId').val(),
			needToPay:$('#needToPay').val(),
			paid:$('#paid').val()
			
			
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



</script>