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

                     <form action="javascript:saveFruit()" name="AddPrintToken" method="post">
                    	
                       

                        
                       <br/>
                            <font size="4">  <table>
                                    <tr>
                                        <td>Fruit Name*:</td>
                                        <td><input type="text" name="name" id="name" class="inputs" placeholder="Fruit name"/></td>		

                                            
                              	      </tr>
                                   
                                 
                                    <tr>
                                        <td colspan="2">  
                                         <input class="button-style" type="submit" name="commit" value="Save"/>
                                         </td>
                                    </tr>
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

function saveFruit(){
	$.ajax({
		url : "saveFruit",
		type : "POST",
		dataType : "text",
		async:false,
		data : {
			name : $('#name').val(),
			quantity : 0,
			stockId:1
			
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