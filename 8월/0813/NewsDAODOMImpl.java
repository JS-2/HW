package com.ssafy.news;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	private List<News> list = new ArrayList<News>();
	private DocumentBuilderFactory factory; // 공장
	private DocumentBuilder builder;
	private Document doc;
	
	@Override
	public List<News> getNewsList(String url) throws Exception {
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		
		doc = builder.parse(url);
		
		NodeList itemList = doc.getElementsByTagName("item");
		int itemListLength = itemList.getLength();
		
		for(int i = 0; i < itemListLength; i++) {
			Node item = itemList.item(i);
			NodeList childNodes = item.getChildNodes();
			
			Node title = childNodes.item(1);
			String titleStr = title.getTextContent();
			
			Node link = childNodes.item(3);
			String linkStr = link.getTextContent();
			
			Node desc = childNodes.item(5);
			String descStr = desc.getTextContent();
			
			list.add(new News(titleStr, descStr, linkStr));
		}
		
		return list;
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}
	
}
