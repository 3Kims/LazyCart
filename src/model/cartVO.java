package model;
import java.sql.Date;
public class cartVO {
	private String customer_id;
	private int product_id;
	private int quantity;
	private Date date;
	
	public cartVO(int product_id, int quantity, Date date) {
		this.product_id = product_id;
		this.quantity = quantity;
		this.date = date;
	}
	
	public cartVO(String customer_id, int product_id, int quantity, Date date) {
		super();
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.date = date;
	}
	public cartVO() {
		super();	
		// TODO Auto-generated constructor stub
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "cart [customer_id=" + customer_id + ", product_id=" + product_id + ", quantity=" + quantity + ", date="
				+ date + "]";
	}
}