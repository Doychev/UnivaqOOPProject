package com.univaqproject.main;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class JWebconnector 
{
	public static AggregatorData getData (String link)
	{
		StringBuilder sb = new StringBuilder();
		try	{
			UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser)
			userAgent.visit(link);          //visit link			
			sb.append(userAgent.doc.findFirst("<title>").getText() + " ");
			Elements sitems = userAgent.doc.findEvery("<div>"); //find every text in body
			for (Element sitem : sitems) {
				sb.append(sitem.getText() + " ");
			}
		} catch(JauntException e) {                         
			  System.err.println(e);  
		}
		AggregatorData result = new AggregatorData();
		result.setRawWebData(sb.toString().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", ""));
		return result;
	}
	

}
