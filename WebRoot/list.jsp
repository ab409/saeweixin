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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del()
		{
			if(confirm("Are you sure?"))
			{
				return true;
			}
			
			return false;
		}
	</script>
  </head>
  
  <body>
    <h1><font color="red"><center>文章列表</center></font></h1>
   
   
   <table border="1" width="95%" align="center">
   
   	<tr>
   	
   	<td>
   		序号
   	</td>
   	
   	<td>
   		城市名
   	</td>
   	
   	<td>
   		文章标题
   	</td>
   	
   	<td>
   		图片地址
   	</td>

   	<td>
   		删除
   	</td>
   	
   	<td>
   		更新
   	</td>
   	
   	<td>
   		查看文章内容
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
   				<s:property value="#us.title"/>
   			</td>
   			
   			<td>
   				<s:property value="#us.picture"/>
   			</td>
   			
   			<td>
   				<s:a href="deleteSite.action?site.id=%{#us.id}" onclick="return del();">delete</s:a>
   			</td>
   			
   			<td>
   				<s:a href="updatePSite.action?site.id=%{#us.id}">update</s:a>
   			</td>
   			
   			<td>
   				<s:a href="readArticle.action?site.id=%{#us.id}">read</s:a>
   			</td>
   		
   		</tr>
   	
   	
   	</s:iterator>
   	</table>
   	<s:a href="save.jsp">继续添加</s:a>
   
  </body>
</html>
