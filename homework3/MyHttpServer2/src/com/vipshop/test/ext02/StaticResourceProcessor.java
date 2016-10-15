package com.vipshop.test.ext02;

import java.io.IOException;

public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		
		try {
			if(response==null){
			    return;
			}
			response.sendStaticResource();
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
}
