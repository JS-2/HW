package com.ssafy.news;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl extends DefaultHandler implements INewsDAO {
	
	private List<News> list = new ArrayList<News>();
	private SAXParserFactory factory;
	private SAXParser parser;
	
	private boolean itemFlag;
	private boolean titleFlag;
	private boolean linkFlag;
	private boolean descFlag;
	
	private String title, link, desc;
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("item")) itemFlag = true;
		else if(qName.equals("title")) titleFlag = true;
		else if(qName.equals("link")) linkFlag = true;
		else if(qName.equals("description")) descFlag = true;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("item")) itemFlag = false;
		else if(qName.equals("title")) titleFlag = false;
		else if(qName.equals("link")) linkFlag = false;
		else if(qName.equals("description")) descFlag = false;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(itemFlag) {
			if(titleFlag) {
				title = new String(ch, start, length);
			}
			else if(linkFlag)
				link = new String(ch, start, length);
			else if(descFlag) {
				desc = new String(ch, start, length);
				list.add(new News(title, link, desc));
			}
		}
	}
	
	@Override
	public List<News> getNewsList(String url) throws Exception {
		factory = SAXParserFactory.newInstance();
		parser = factory.newSAXParser();
		
		parser.parse(url, this);
		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
