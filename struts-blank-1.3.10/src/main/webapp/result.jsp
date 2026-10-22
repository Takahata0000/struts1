<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<body>
<a href="http://localhost:8080/struts-blank-1.3.10/Welcome.do"/><img src="../../images/return.gif" height="24" width="24" alt="Return to examples page" class="icon" /></a>
  <p>商品を登録しました。</p>
  <p>商品名：<bean:write name="helloForm" property="name"/></p>
  <p>価格：<bean:write name="helloForm" property="price"/></p>
  <p>種類：<bean:write name="helloForm" property="category"/></p>
  
<%
out.println(new java.util.Date());
int i = (int)(Math.random()*10);
if(i < 5){
  out.println("あなたは、ラッキーです！");
}else{
  out.println("あなたは、アンラッキーです！");
}
%>
</body>
</html>