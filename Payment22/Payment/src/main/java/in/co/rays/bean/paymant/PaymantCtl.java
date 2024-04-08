package in.co.rays.bean.paymant;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymantCtl")
public class PaymantCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PaymantModel model = new PaymantModel();
		int pageNo = 1;
		int pageSize = 10;
		PaymantBean bean = new PaymantBean();
		try {
			List list = model.search(bean, pageNo, pageSize);
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (PaymantBean) it.next();
				System.out.println("bank Name" + bean.getBankName());
			}

			RequestDispatcher rd = req.getRequestDispatcher("PaymantListView.jsp");
			req.setAttribute("List", list);
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		PaymantModel model = new PaymantModel();
		PaymantBean bean = new PaymantBean();
		int pageNo = 1;
		int pageSize = 10;

		if (op.equalsIgnoreCase("search")) {
			pageNo = 1;
			String bankName=req.getParameter("bankName");
			bean.setBankName(bankName);
		
		}
			
			try {
				List list = model.search(bean, pageNo, pageSize);
//				Iterator it = list.iterator();
//				while (it.hasNext()) {
//					bean = (PaymantBean) it.next();
//					System.out.println("bank Name" + bean.getBankName());
//				}

				RequestDispatcher rd = req.getRequestDispatcher("PaymantListView.jsp");
				req.setAttribute("List", list);
				rd.forward(req, resp);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


