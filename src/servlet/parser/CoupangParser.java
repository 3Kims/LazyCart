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

		ArrayList<String> images = new ArrayList<String>();
		ArrayList<String> options = new ArrayList<String>();
		productVO product = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			String shop = "coupang";
			String category = "";
			// 이름
			String name = doc.selectFirst(".prod-buy-header__title").text();
			// 가격
			int price = Integer.parseInt(doc.selectFirst(".total-price").text().replaceAll("[^0-9]", ""));
			System.out.println(price);
			// 카테고리
			// 이미지
			Elements Images = doc.select(".prod-image__item > img");
			for (Element image : Images) {
				images.add(image.toString());
			}
			// 옵션
			Elements sizes = doc.getElementsByClass("Dropdown-Select__Dropdown__Item");
			for (Element size : sizes) {
				options.add(size.toString());
			}
			product = new productVO(name, price, shop, url, category, images, options);
			return product;
		} catch (IOException e) {
			e.printStackTrace();
			return product;
		}

	}
}