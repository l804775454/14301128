package com.vipshop.test.ext02;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.util.StringUtils;

import XMLParser.XMLParser;

public class ServletProcessor2 {

	public void process (Request request, Response response) throws ParserConfigurationException, SAXException, IOException {
		
		String uri = request.getUri();
		String servletName = null;
		if (uri.indexOf("?")!=-1) {
			servletName=uri.substring(uri.indexOf("/")+1,uri.indexOf("?"));
		}else{
			servletName = uri.substring(uri.lastIndexOf("/") + 1);
		}
		String servletName1=XMLParser.getServlet(servletName);		
		Object myClass = null;
		
		try {
			
			myClass = Class.forName(servletName1).newInstance();
			// = loader.loadClass(servletName);
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			
		} catch (InstantiationException e) {
			
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {

			e.printStackTrace();
			
		}
		
		Servlet servlet = null;
		RequestFacade requestFacade = new RequestFacade(request);
		ResponseFacade responseFacade = new ResponseFacade(response);
		try {
			servlet = (Servlet) myClass;
			System.out.println(servlet);
			servlet.service(
					(ServletRequest) requestFacade, 
					(ServletResponse) responseFacade);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
	
}
