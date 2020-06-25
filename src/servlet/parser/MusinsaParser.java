package servlet.parser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import model.productVO;

public class MusinsaParser implements Parser {

	@Override
	public productVO handle(String URL) {
		productVO product = null;
		try {
			System.out.println("start musinsa parser..");
			String shop ="Musinsa";
			//url
			String url = URL;
			Document document = null;
			document = Jsoup.connect(url).get();
			
			//이름
			Element nameParentNode = document.select("span[class=product_title]").get(0);
			//Element nameChild = nameParentNode.child(0);
			String name = nameParentNode.text();
			name="testName";
			System.out.println("name: "+name);
			
			//가격
			String priceTag = document.select("span[id=goods_price]").text();
			int price = Integer.parseInt(priceTag.replaceAll(",", ""));
			System.out.println("price: "+price);

			//카테고리
			String category = document.select("p[class=item_categories]").text();
			System.out.println("category: "+category);
			
			//이미지
			String imagelist = "";
			Elements imageParentNode = document.select("ul[class=product_thumb]");
			for (Element imageChild : imageParentNode) {
				imagelist = imageChild.select("img").toString();
			}
			imagelist = "testImageList";
			System.out.println("imageList: "+imagelist);
			
			//옵션
			Element selectTag = document.getElementsByClass("option1").get(0);
			String options = selectTag.children().get(0).toString();
			System.out.println("options: "+options);
	//	

			
			product = new productVO(name, price, shop, url, category, imagelist, options);
			System.out.println("product-------------------------");
			System.out.println(product);

			return product;
		
		} catch (IOException e) {
			System.out.println("MUSINSA PRODUCT -------------------------");
			e.printStackTrace();
			return product;
		}

		
	}

}
