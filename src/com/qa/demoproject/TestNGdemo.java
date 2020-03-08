package com.qa.demoproject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGdemo {
	
	@Test
	@Parameters({"url", "username", "password"})
	public static void parameterdemo(String url, String username, String password)
	{
		System.out.println(url);
		System.out.println(username);
		
	}
	

}
