package model;

public class CustomerVO {
	private String id;
	private String password;
	private String img;
	private String name;
	private String address;
	private String phone;
	private CartVO cart;
	
	public CustomerVO() {
		super();
	}
	
	public CustomerVO(String id, String password, String name, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	public CustomerVO(String id, String password, String name, String address, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	public CustomerVO(String id, String password,String img, String name, String address, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.img = img;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public CustomerVO(String id, String password,String img, String name, String address, String phone, CartVO cart) {
		this.id = id;
		this.password = password;
		this.img = img;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.setCart(cart);
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	public CartVO getCart() {
		return cart;
	}

	public void setCart(CartVO cart) {
		this.cart = cart;
	}
	
	@Override
	public String toString() {
		return "customer [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + "]";
	}
}
