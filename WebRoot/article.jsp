<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="site.title"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css"> 
		body {
　　　　			font: normal 100% Helvetica, Arial, sans-serif;
　　		}
		h1 {
　　　　			font-size: 1.2em; 
　　		}
		small {
　　　　			font-size: 0.875em;
　　		}
	</style>

  </head>
  
  <body>
    <div width="90%">
    	<img src="${site.picture}" align="middle" width="90%"/><br>
    	<h1><s:property value="site.title"/></h1>
		<s:property value="#request.article" escape="false"/>
    	
    </div>
  </body>
</html>
