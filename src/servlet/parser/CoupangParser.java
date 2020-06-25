package servlet.parser;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import model.productVO;
public class CoupangParser implements Parser {
	public productVO handle(String url) {

		productVO product = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			// 이름
			String name = doc.selectFirst(".prod-buy-header__title").text();
			System.out.println("name: "+name);
			// 가격
			int price = Integer.parseInt(doc.selectFirst(".total-price").text().replaceAll("[^0-9]", ""));
			System.out.println("price: "+price);
			String shop = "coupang";
			System.out.println("shop: "+shop);
			// 카테고리
			String category = "";
			System.out.println("category: "+category);
			// 이미지
			String images= doc.select(".prod-image__item > img").get(0).toString();
			System.out.println("images: "+images);
			// 옵션
			String options = doc.getElementsByClass("Dropdown-Select__Dropdown__Item").get(0).toString();
			System.out.println("options: "+options);
			product = new productVO(name, price, shop, url, category, images, options);
			if(product==null) {
				System.out.println("coupang product is null");
				return null;
			}else {
				System.out.println(product.toString());
			}
			
			return product;
		} catch (IOException e) {
			e.printStackTrace();
			return product;
		}

	}
}