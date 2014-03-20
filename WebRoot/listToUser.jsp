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
    
    <title>文章列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
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
　　　　			font-size: 1.5em; 
　　		}
		small {
　　　　			font-size: 0.875em;
　　		}
	</style>

  </head>
  
  <body>
    
	<h1><center>文章列表</center></font></h1>
   
   
   <table width="95%" align="center">
   
   	<tr>
   	
   	<td>
   		序号
   	</td>
   	
   	<td>
   		城市名
   	</td>
   	
   	<td>
   		阅读文章
   	</td>
   	
   	</tr>
   
   	<s:iterator value="#request.list" id="us">
   	
   		<tr>
   		
   			<td>
   				<s:property value="#us.id"/>
   			</td>
   			
   			<td>
   				<s:property value="#us.name"/>
   			</td>
   			
   			<td>
   				<s:a href="readArticle.action?site.id=%{#us.id}">阅读本文</s:a>
   			</td>
   		
   		</tr>
   	
   	
   	</s:iterator>
   	</table>
   
  </body>
</html>
