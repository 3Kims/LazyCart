package model;

public class ProductVO {
	private int id;
	private String name;
	private int price;
	private String shop;
	private String url;
	private String category;
	private String img;
	
	public ProductVO() {
		super();
	}
	

	public ProductVO(String name, int price, String shop, String url, String category, String img) {
		super();
		this.name = name;
		this.price = price;
		this.shop = shop;
		this.url = url;
		this.category = category;
		this.img = img;
	}
	
	public ProductVO(int id, String name, int price, String shop, String url, String category, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.shop = shop;
		this.url = url;
		this.category = category;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "productVO [id=" + id + ", name=" + name + ", price=" + price + ", shop=" + shop + ", url=" + url + ", category=" + category + ", img=" + img + "]";
	}

}
