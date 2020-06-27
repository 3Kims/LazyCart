package servlet.parser;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import model.ProductVO;
public class CoupangParser implements Parser {
	public ProductVO handle(String url) {
		ProductVO product = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			System.out.println(doc);
			// 이름
			String name = doc.selectFirst(".prod-buy-header__title").text();
			System.out.println("name: "+name);
			// 가격
			int price = Integer.parseInt(doc.selectFirst(".total-price").text().replaceAll("[^0-9]", ""));
			System.out.println("price: "+price);
			//샵
			String shop = "coupang";
			System.out.println("shop: "+shop);
			// 카테고리
			String category = "none";
			
			System.out.println("naver------------------------------");
			String naverUrl = "https://search.shopping.naver.com/search/all?query="+name;
			Document naverDoc = Jsoup.connect(naverUrl).get();
			Elements naverCategories = naverDoc.select("ul[class=filter_finder_list__16XU5]");
			System.out.println(naverCategories.size());
			System.out.println(naverCategories.text());
			System.out.println("naver------------------------------");
			String naverCategoriesText =  naverCategories.text();
			category = naverCategoriesText.replaceAll("[0-9]","");
			// 이미지
			Element images = doc.select("img.prod-image__detail").get(0);
			String thumbnailSrc = images.attr("data-preload-img-src");
			String thumbnail ="//thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/";
			String detailImage ="//image10.coupangcdn.com/image/retail/images/";
			String imageSrc = thumbnailSrc.replace(thumbnail, detailImage);
			String image =  "<img src="+ imageSrc +">";
			
			product = new ProductVO(name, price, shop, url, category, image);
			System.out.println("product------------------------------");
			System.out.println(product);
			return product;
		} catch (IOException e) {
			e.printStackTrace();
			return product;
		}
	}
	/*
	public static void main(String[] args) {
		productVO product = null;
		Document doc;
		try {
			String url = "https://www.coupang.com/vp/products/35289521?itemId=130861838&vendorItemId=3274676123&isAddedCart=";
			doc = Jsoup.connect(url).get();
			System.out.println(doc);
			// 이름
			String name = doc.selectFirst(".prod-buy-header__title").text();
			System.out.println("name: "+name);
			// 가격
			int price = Integer.parseInt(doc.selectFirst(".total-price").text().replaceAll("[^0-9]", ""));
			System.out.println("price: "+price);
			//샵
			String shop = "coupang";
			System.out.println("shop: "+shop);
			// 카테고리
			String category = "none";
			
			System.out.println("naver------------------------------");
			String naverUrl = "https://search.shopping.naver.com/search/all?query="+name;
			Document naverDoc = Jsoup.connect(naverUrl).get();
			Elements naverCategories = naverDoc.select("ul[class=filter_finder_list__16XU5]");
			System.out.println(naverCategories.size());
			System.out.println(naverCategories.text());
			System.out.println("naver------------------------------");
			String naverCategoriesText =  naverCategories.text();
			category = naverCategoriesText.replaceAll("[0-9]","");
			// 이미지
			Element images = doc.select("img.prod-image__detail").get(0);
			String thumbnailSrc = images.attr("data-preload-img-src");
			String thumbnail ="//thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/";
			String detailImage ="//image10.coupangcdn.com/image/retail/images/";
			String imageSrc = thumbnailSrc.replace(thumbnail, detailImage);
			String image =  "<img src="+ imageSrc +">";
			
			product = new productVO(name, price, shop, url, category, image);
			System.out.println("product------------------------------");
			System.out.println(product);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println(product);
		}
	}*/
}