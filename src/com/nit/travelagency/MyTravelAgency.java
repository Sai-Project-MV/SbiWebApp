package com.nit.travelagency;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class MyTravelAgency {

public MyTravelAgency(){

}

	boolean isValid=false;
	public static void main(String[] args) throws Exception{
		MyTravelAgency agency=
				                      new MyTravelAgency();
		
		boolean  isValid=agency.validateXml();
		
		if(isValid) {
			//getting saxparserFactory
				SAXParserFactory factory=SAXParserFactory.newInstance();
				//getting saxparser from saxparserfactory
				SAXParser parser=factory.newSAXParser();		
				//invoke method
				parser.parse(new File("xml/TravelAgency.xml"),new TravelAgency());
		 } else {
			 System.out.println("xml is not valid to against xsd");
		 }
 	}
	public boolean validateXml(){
		isValid=true;
		try {
			//getting SchemaFactory
			SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//getting schema
			Schema schema=factory.newSchema(new File("xsd/Travel-Agent-Xsd.xsd"));
			// get validator
			Validator validator= schema.newValidator();
			//validate xml against xsd
			validator.validate(new StreamSource(new File("xml/TravelAgency.xml")));
			
		} catch (Exception e) {
			e.printStackTrace();
		isValid=false;
		}
		return isValid;
	}
}
