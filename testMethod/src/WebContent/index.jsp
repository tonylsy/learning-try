<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>indexPage</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <button onclick="testLocalRepository()">testLocalRepository</button>
    <script type="text/javascript">
    function testLocalRepository(){
    	$.ajax({
    		url:"testJson.do",
    		method:"POST",
    		dataType:"json",
    		success:function(data){
    			alert(data.result);
    		},
    		error:function(){
    			alert("gg");
    		}
    	});
    }
    
    </script>
  </body>
</html>
