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
        <style>
  label {
    display: inline-block;
    width: 5em;
  }
  </style>

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
                    			<td>Purchaser balance</td>
                    			
                    		</tr>
                    	</table>

                       

                        
                       <br/>
                       	<div class="datagrid">
                            <table id="itemstbl">
	                            	<thead>
	                            		<th>Name</th>
	                            		<th>Balance</th>
	                            	</thead>
	                            	<tbody>
	                            		<c:forEach items="${balance }" var="b">
	                            			<tr>
	                            				<td >
	                            					<div id="example-03" class="example-wrapper">
	                            					
	                            					<a href="#" class="tooltip">${b.bpName }
													<span>
														<b></b>
														<strong>${b.bpName } Account number </strong>
														<br />
														<img alt="CSS3 tooltip image" style="float:right;height:50px;width:50px;padding-left:5px;" src="img/phone.png" />
														${b.id }<br /><br />
													</span>
												</a>
	                            					</div>
	                            				
	                            				</td>
	                            				<td>${b.balance }</td>
	                            			</tr>
	                            		</c:forEach>
	                            	</tbody>
                                </table>
                                </div>
                               
                                
                               
                    </div>
                    <%@ include file="../balance_sidebar.jsp"%>

                </div>
            </div>
        </div>
        <div id="footer" class="container">
            <p>&copy; All rights reserved. Design by SL Fruits</p>
        </div>
    </body>
</html>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
