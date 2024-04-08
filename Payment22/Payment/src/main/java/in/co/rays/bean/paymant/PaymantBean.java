package in.co.rays.bean.paymant;

public class PaymantBean {
	private int id;
	private String payment;
	private int amount;
	private String bankName;
	private String customerName;
	private String transactionId;
	private String PaymentDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	
	
	

}
