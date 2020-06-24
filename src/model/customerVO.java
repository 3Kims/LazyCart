package model;

public class customerVO {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	
	public customerVO(String id, String password, String name, String address, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public customerVO() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "customer [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + "]";
	}
}