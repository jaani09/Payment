package in.co.rays.bean.paymant;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class PaymantTest {
	public static void main(String[] args) throws Exception {
		//add();
		//testupdate();
		//delete();
	search();
	}

	private static void search() throws Exception {

		
		PaymantBean bean =new PaymantBean();
		bean.setBankName("B");
		PaymantModel model = new PaymantModel();

		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (PaymantBean) it.next() ;
			
			System.out.println(" "+bean.getId());
			System.out.println(" "+bean.getPayment());
			System.out.println(" " +bean.getAmount());
			System.out.println(" " +bean.getBankName());
			System.out.println("  "+bean.getCustomerName());
			System.out.println(" "+bean.getTransactionId());
			System.out.println(" "+bean.getPaymentDate());
		}
			
	}

	private static void delete() throws Exception {
		
		 PaymantBean bean = new PaymantBean();
		 
		  bean.setId(2);
		  
		   PaymantModel model = new PaymantModel();
		   model.delete(2);
		   
		 
	}

	private static void testupdate() throws Exception {

		
 PaymantBean bean =new PaymantBean();
		
		
		bean.setBankName("BOI");
		bean.setPayment("cash");
		bean.setAmount(5000);
		bean.setCustomerName("gopal");
		bean.setTransactionId("0101");
		bean.setPaymentDate("21-12-2004");
		bean.setId(1);
		
		
		PaymantModel model = new PaymantModel();
		model.update(bean);

	}

	private static void add() throws Exception {
		PaymantBean bean = new PaymantBean();
	
		// SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

		bean.setId(4);
		bean.setPayment("Paytm");
		bean.setAmount(1234);
		bean.setBankName("PNB");
		bean.setCustomerName("SHIv");
		bean.setTransactionId("98765");
		bean.setPaymentDate("9-9-2008");
		
		PaymantModel model = new PaymantModel();
		model.add(bean);
	}
 
}
