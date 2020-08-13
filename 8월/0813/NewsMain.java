package com.ssafy.news;

import java.util.Iterator;
import java.util.List;

public class NewsMain {
	INewsDAO dao;

	public static void main(String[] args) throws Exception {
		NewsDAODOMImpl dom = new NewsDAODOMImpl();
		NewsDAOSAXImpl sax = new NewsDAOSAXImpl();
		
		List<News> domNews = dom.getNewsList("http://rss.etnews.com/Section902.xml");
		List<News> saxNews = sax.getNewsList("http://rss.etnews.com/Section902.xml");
		Iterator<News> domIter = domNews.iterator();
		Iterator<News> saxIter = saxNews.iterator();

		while(domIter.hasNext()) {
			System.out.println(domIter.next());
		}
		
		System.out.println("=============================================");
		
		while(saxIter.hasNext()) {
			System.out.println(saxIter.next());
		}
		
	}

}
