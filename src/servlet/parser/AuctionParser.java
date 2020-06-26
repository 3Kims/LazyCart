package servlet.parser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.function.categoryController;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import model.productVO;

public class AuctionParser implements Parser {

	@Override
	public productVO handle(String url) {
		productVO product = null;
		String shop ="Auction";
		//url
		System.out.println("url-------------------------");
		Document document;
		try {
			document = Jsoup.connect(url).get();
			//이름
			System.out.println("name-------------------------");
			Elements nameParentNode = document.getElementsByClass("itemtit");
			String name = nameParentNode.text();

			System.out.println(name);
			
			System.out.println("price-------------------------");
			String priceTag = document.select("strong.price_real").text();
			int price = Integer.parseInt(priceTag.replace(",", "").replace("원", ""));
			System.out.println(price);

			//카테고리
			System.out.println("category-------------------------");
			Element mainCategory = document.select("div[class=loc]").get(0);
			Elements strongCategory = mainCategory.select("a.dropdown");
			String category = strongCategory.text().replace("더보기", ">");
			System.out.println(category);
			
			//이미지
			System.out.println("image-------------------------");
			Element imageParentNode = document.getElementById(" on");
			Elements liNodes =document.select("ul[class=viewer]").get(0).children();
			String image = liNodes.get(0).getElementsByTag("img").toString();
			System.out.println(image);

			product = new productVO(name, price, shop, url, category, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return product;
		}
		return product;
		
	}

}
