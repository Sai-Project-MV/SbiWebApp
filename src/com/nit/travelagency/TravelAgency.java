package com.nit.travelagency;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.nit.pojo.TravelAgent;

public class TravelAgency extends DefaultHandler {
	
	private TravelAgent agent=null;
	
	private boolean flightid=false;
	private boolean flightname=false;
	private boolean from=false;
	private boolean to=false;

	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("*******Parsing Started************");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

	if(qName.equals("domestic-flight")) {
		agent=new TravelAgent();
	}
	else if(qName.equals("flight-id")) {
		flightid=true;
	} else if(qName.equals("flight-name")) {
		flightname=true;
	} else if(qName.equals("from")) {
		from=true;
	}else if(qName.equals("to")) {
		to=true;
    	}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	    
		if(flightid) {
		String fid=new String(ch,start,length);
		flightid=false;
	 //   System.out.println("Flight Id::"+fid);
		agent.setFlightId(fid);
	   } else  if(flightname) {
			String fname=new String(ch,start,length);
			flightname=false;
		  //  System.out.println("Flight name::"+fname);
			agent.setFlightName(fname);
		   } else  if(from) {
				String ffrom=new String(ch,start,length);
				from=false;
			//    System.out.println("Flight from::"+ffrom);
			   agent.setFrom(ffrom);
		   } else  if(to) {
					String fto=new String(ch,start,length);
					to=false;
				 //   System.out.println("Flight to::"+fto);
			   agent.setTo(fto);	   
		   }  
}	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println(agent);
		System.out.println("*******Parsing Ended************");
	}
}
