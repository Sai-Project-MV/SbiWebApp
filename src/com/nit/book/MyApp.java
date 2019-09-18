package com.nit.book;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MyApp {

	public static void main(String[] args) throws Exception {
		
		//getting saxParserFactory
		SAXParserFactory factory=SAXParserFactory.newInstance();
         
		// getting sxparser from saxParserFactory
		SAXParser parse=factory.newSAXParser();
	
		// execute method
		parse.parse(new File("xml/Book.xml"), new BookParser());
	}	

}
