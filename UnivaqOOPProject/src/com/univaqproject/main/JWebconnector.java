package com.univaqproject.main;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class JWebconnector 
{
	public static void main (String[]Args)
	{
		try
		{
			
		UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser)
		userAgent.visit("http://facebook.com");          //visit link
		
//		Element sitems = userAgent.doc.findEvery("<div>").findEvery("<a>");  //find search result links
//		System.out.println(sitems.getAt("href"));           //print results
		
		StringBuilder sb = new StringBuilder();
		Elements sitems = userAgent.doc.findEvery("<div>"); //find every text in body
		for (Element sitem : sitems) {
			sb.append(sitem.getText());
//			System.out.print(printing);			
		}
		System.out.println(sb.toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", ""));			
		
		
//		String title = userAgent.doc.findFirst("<title>").getText(); //get child text of title element.
//		System.out.println(title); 
//		
//		Element head = userAgent.doc.findFirst("<head>");  //find search result links		
//		System.out.println(head.getText());           //print results
		
//		Element bodytxt = userAgent.doc.findFirst("<body>"); //find body and get text
//		Element divtxt = bodytxt.findEvery("<div>");			//find div and get text
//		System.out.println(bodytxt.getText());
//		System.out.println(divtxt.getText());
		
		}
		catch(JauntException e)
		{                         
			  System.err.println(e);  
		}
	}
	

}
