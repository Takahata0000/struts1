<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:html>
<body>
  <html:form action="/hello">
    名前: <html:text property="name"/>
    <html:submit value="送信"/>
  </html:form>
</body>
</html:html>