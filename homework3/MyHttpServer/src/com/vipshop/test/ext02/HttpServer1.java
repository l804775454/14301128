package com.vipshop.test.ext02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class HttpServer1 {

	// shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	// the shutdown command received
	private boolean shutdown = false;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		HttpServer1 server = new HttpServer1();
		server.await();
		
	}
	
	public void await() throws ParserConfigurationException, SAXException, IOException {
		
		ServerSocket serverSocket = null;
		int port = 8080;
		
		try {
			
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
			
		}
		
		// Loop waiting for a request
		while(!shutdown) {
			
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
			// create Request object and parse
			Request request = new Request(input);
			request.parse();
			
			// create Response object
			Response response = new Response(output);
			response.setRequest(request);
			if (request.getUri()==null||request==null) {
				continue;
			}
			// check if this is a request for a servlet or a static resource
			// a request for a servlet begings with "/servlet"
			if (request.
					getUri().
					startsWith("/")&&request.getUri().indexOf(".")==-1) {
				
				ServletProcessor2 processor = new ServletProcessor2();
				processor.process(request, response);
				
			} else {
				
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}
			
			try {
				// Close the socket
				socket.close();
				// check if the previous URI is a shutdown command
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				e.printStackTrace();
				//System.exit(1);
				
			}
			
		}
		
	}
	
}
