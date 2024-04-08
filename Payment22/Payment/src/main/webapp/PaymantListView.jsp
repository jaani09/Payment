<%@page import="in.co.rays.bean.paymant.PaymantBean"%>
<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean" class="in.co.rays.bean.paymant.PaymantBean"
		scope="request"></jsp:useBean>

	

	<%
		List list = (List) request.getAttribute("List");
		Iterator<PaymantBean> it = list.iterator();
	%>
	<form action="PaymantCtl" method="post">
		<table border="1" bgcolor="yellow" height="100%" width="100%">
<input type="text" name="bankName" value="" placeholder="Enter Bank Name">

	<input type="submit" name="operation" value="search">
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>BankName</th>
				<th>paymant</th>
				<th>amount</th>
				<th>customername</th>
				<th>transactionId</th>
				<th>paymantDate</th>
			</tr>

			<%
				while (it.hasNext()) {
					 bean = (PaymantBean) it.next();
			%>

			<tr>
				<th><input type="checkbox" name="checkbox"
					value="<%=bean.getId()%>"></th>
				<td><%=bean.getId()%></td>
				<td><%=bean.getBankName()%></td>
				<td><%=bean.getPayment()%></td>
				<td><%=bean.getCustomerName()%></td>
				<td><%=bean.getAmount()%></td>
				<td><%=bean.getTransactionId()%></td>
				<td><%=bean.getPaymentDate()%></td>
			</tr>


			<%
				}
			%>



		</table>
	</form>
</body>
</html>