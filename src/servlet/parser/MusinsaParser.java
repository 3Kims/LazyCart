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
			String shop ="Musinsa";
			//url
			System.out.println("url-------------------------");
			String url = URL;
			Document document = null;
			document = Jsoup.connect(url).get();
			//이름
			System.out.println("name-------------------------");
			Element nameParentNode = document.select("span[class=product_title]").get(0);
			Element nameChild = nameParentNode.child(0);
			String name = nameParentNode.text();
			System.out.println(name);
//			String name = nameChild.text();

			//가격
			System.out.println("price-------------------------");
			String priceTag = document.select("span[id=goods_price]").text();
			int price = Integer.parseInt(priceTag.replaceAll(",", ""));
			System.out.println(price);

			//카테고리
			System.out.println("category-------------------------");
			String category = document.select("p[class=item_categories]").text();
			System.out.println(category);
			
			//이미지
			System.out.println("image-------------------------");
			ArrayList<String> imglist = new ArrayList<String>();
			Elements imageParentNode = document.select("ul[class=product_thumb]");
			for (Element imageChild : imageParentNode) {
				imglist.add(imageChild.select("img").toString());
			}
			System.out.println(imglist);
			//옵션
//			System.out.println("option-------------------------");
//			Elements optionElementlist = document.select("div[class=opt]");
//			for (Element optionElement : optionElementlist) {
//				System.out.println(optionElement.text());
//			}
			System.out.println("option-------------------------");
			ArrayList<String> optionlist = new ArrayList<String>();
			Element selectTag = document.getElementsByClass("option1").get(0);
			Elements options = selectTag.children();
			for (Element optionChild : options) {
				optionlist.add(optionChild.text());
			}
			System.out.println(optionlist);
	//	
			product = new productVO(name, price, shop, url, category, imglist, optionlist);
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
