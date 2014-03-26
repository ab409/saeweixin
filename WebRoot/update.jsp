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
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1><font color="red"><center>更新</center></font></h1>
    
     <s:form action="updateSite">
     
     <table>
     
     <tr>
     <td>
     	<s:hidden name="site.id" value="%{site.id}"></s:hidden>
     
     </td>
     </tr>
     
     
     <tr>
     <td>
     	<s:textfield name="site.name" value="%{site.name}" label="name"></s:textfield>
     
     </td>
     </tr>
     
     
     <tr>
     <td>
     	<s:textfield name="site.title" value="%{site.title}" label="title"></s:textfield>
     
     </td>
     </tr>
     
     
     <tr>
     <td>
     	
		<s:textfield name="site.picture" value="%{site.picture}" label="pictureURL"></s:textfield>
     
     </td>
     </tr>
     
     <tr>
     <td>
     	
		<s:textarea name="site.content" label="contentURL" cols="80" rows="50"></s:textarea>
     
     </td>
     </tr>
     
     <tr>
     <td>
     	<s:submit value="submit"></s:submit>
	     
     </td>
     </tr>

     </table>
     
     
     
     </s:form>
  </body>
</html>
