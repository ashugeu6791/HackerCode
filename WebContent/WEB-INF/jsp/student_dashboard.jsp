<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Welcome Page</title>
      <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
   </head>
   
   <body>
   <%@include file="header.jsp" %>
      <h2>${message}</h2>
      It worked
      <%@include file="footer.jsp" %>
   </body>
</html>