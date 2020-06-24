package model;

import java.util.ArrayList;

public class productVO {
	private int id;
	private String name;
	private int price;
	private String shop;
	private String url;
	private String category;
	private ArrayList<String> img;
	private ArrayList<String> option;
	
	public productVO(String name, int price, String shop, String url, String category, ArrayList<String> img,
			ArrayList<String> option) {
		super();
		this.name = name;
		this.price = price;
		this.shop = shop;
		this.url = url;
		this.category = category;
		this.img = img;
		this.option = option;
	}
	
	public productVO(int id,String name, int price, String shop, String url, String category, String[] img,
			String option) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.shop = shop;
		this.url = url;
		this.category = category;
		this.img = img;
		this.option = option;
	}
	

	public productVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getImg() {
		return img;
	}
	public void setImg(String[] img) {
		this.img = img;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	@Override
	public String toString() {
		return "productVO [id=" + id + ", name=" + name + ", price=" + price + ", shop=" + shop + ", url=" + url
				+ ", category=" + category + ", img=" + img + ", option=" + option + "]";
	}
	
	
}
