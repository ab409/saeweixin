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
    
    <title>My JSP 'save.jsp' starting page</title>
    
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
    <h1><font color="red">保存文章</font></h1>
     
     <s:form action="saveSite">
     
     	<s:textfield name="site.name" label="name"></s:textfield>
     	<s:textfield name="site.title" label="title"></s:textfield>
     	<s:textfield name="site.picture" label="pictureURL"></s:textfield>
     	<%-- <s:textfield name="site.content" label="contentURL"></s:textfield> --%>
     	<s:textarea name="site.content" label="content" cols="80" rows="50" ></s:textarea>
     	<s:submit value="submit"></s:submit>
     
     </s:form>
  </body>
</html>
