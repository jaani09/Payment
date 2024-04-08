package in.co.rays.bean.paymant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymantModel {

	public PaymantBean add(PaymantBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into p4 values(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getPayment());
		ps.setInt(3, bean.getAmount());
		ps.setString(4, bean.getBankName());
		ps.setString(5, bean.getCustomerName());
		ps.setString(6, bean.getTransactionId());
		ps.setString(7, bean.getPaymentDate());

		int i = ps.executeUpdate();

		System.out.println("data added" + i);
		return bean;

	}

	public void update(PaymantBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update p4 set paymenttype=?, amount=?,bankname=?,customername=?,transactionid=?,paymentdate=? where id=?");

		ps.setString(1, bean.getPayment());
		ps.setInt(2, bean.getAmount());
		ps.setString(3, bean.getBankName());
		ps.setString(4, bean.getCustomerName());
		ps.setString(5, bean.getTransactionId());
		ps.setString(6, bean.getPaymentDate());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("Data update sussesfully" + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");
		PreparedStatement ps = conn.prepareStatement("Delete from p4 where id= ?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("Data delete successfully");

	}

	public List search(PaymantBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");

		StringBuffer sb = new StringBuffer("select * from p4 where 1=1");

		if (bean != null) {

			if (bean.getBankName() != null && bean.getBankName().length() > 0) {

				sb.append(" and bankName like '" + bean.getBankName() + "%'");

			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sb.append(" limit " + pageNo + ", " + pageSize);

		}

		System.out.println(sb);

		PreparedStatement ps = conn.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new PaymantBean();

			bean.setId(rs.getInt(1));
			bean.setPayment(rs.getString(2));
			bean.setBankName(rs.getString(4));
			bean.setAmount(rs.getInt(3));
			bean.setCustomerName(rs.getString(5));
			bean.setTransactionId(rs.getString(6));
			bean.setPaymentDate(rs.getString(7));

			list.add(bean);

		}

		return list;

	}
}
