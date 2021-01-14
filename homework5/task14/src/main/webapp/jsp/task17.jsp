<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html> <head><title>Expenses</title></head>

<body><meta charset="utf-8">
<h1>Expenses table</h1>

<table border="1">
  <tr>
            <th>Payment<br>number</th>
            <th>Payment<br>date</th>
	        <th>Entity name</th>
	        <th>Amount</th>
  </tr>

 <c:forEach items="${rows}" var="row">
   <tr>
      <td align="center"><c:out value="${row.paymentNumber}"/></td>
      <td> <c:out value="${row.paymentDate}"/></td>
      <td> <c:out value="${row.entityName}"/></td>
      <td>  <c:out value="${row.amount}"/></td>
   </tr>
 </c:forEach>
</table>
</body>
</html>