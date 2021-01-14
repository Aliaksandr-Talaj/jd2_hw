<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="it.academy.data.Accounting" %>
<%@ page import="java.util.List" %>
<% response.setCharacterEncoding("UTF-8"); %>

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

  <% for ( Accounting row: (List<Accounting>)request.getAttribute("rows")) {
      out.print("<tr><td align=\"center\">"+row.getPaymentNumber()+"</td>");
      out.print("<td>"+row.getPaymentDate()+"</td>");
      out.print("<td>"+row.getEntityName()+"</td>");
      out.print("<td>"+row.getAmount()+"</td></tr>");
  } %>

</table>

</body>
</html>