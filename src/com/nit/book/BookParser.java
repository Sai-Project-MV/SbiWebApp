package com.nit.book;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookParser extends DefaultHandler {
	
	boolean id=false;
	boolean name=false;
	
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Document started");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	//	System.out.println("startElement()");
		if(qName.equals("id")) {
			id=true;
		} else if(qName.equals("name")) {
			name=true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		  if(id) {
		String data=new String(ch,start,length);
		System.out.println("Element Id::"+data);
		id=false;
		  } else if(name) {
			
					String data=new String(ch,start,length);
					System.out.println("Element Name::"+data);
					name=false;
		  }
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	//System.out.println("BookParser.endElement()");
	}
	@Override
	public void endDocument() throws SAXException {
	//System.out.println("BookParser.endDocument()");
	}

}
