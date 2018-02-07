package com.math;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 * @author Avinash Jadhav
 * 
 * Test class for PerfectNumber.java
 */

public class PerfectNumberTest {

	private final String msgPositveNumber="Please enter positive number";
	private final String msgLargeNumber="Number too large to process. Maximum allowed length is 10";
	private final String resultYes="YES";
	private final String resultNo="NO";
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 4567;
	}

	/**
	 * Testing success scenario and status code 200
	 */
	@Test
	public void testSuccess() {
				
		try{
		    given().		        
		    expect().
		    when().
		        get("/isperfect/6");
		        
		     Response res = get("/isperfect/6");   
		        		           
		     Assert.assertEquals(200,res.getStatusCode());    
		     Assert.assertEquals(resultYes,res.asString());		        
		        
		}catch(RuntimeException re){
			re.getMessage();
		}

	}

	/**
	 * Testing failure scenario
	 */
	@Test
	public void testFailure(){
		
		try{
		    given().
		    expect().
		    when().
		        get("/isperfect/10");
		        
		     Response res = get("/isperfect/10");   
		        		            
		     Assert.assertEquals(200,res.getStatusCode());    
		     Assert.assertEquals(resultNo,res.asString());		        
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
		
	}
	
	/**
	 * Testing 404 error scenario
	 */
	@Test
	public void testNotFound(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect");
		        
		     Response res = get("/isperfect");   		        
		            
		     Assert.assertEquals(404,res.getStatusCode());  		     
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}
		
	

	/**
	 * Testing string input scenario
	 */
	@Test
	public void testInputString(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect/abcd");
		        
		     Response res = get("/isperfect/abcd");   		        
		            
		     Assert.assertEquals(200,res.getStatusCode());    
		     Assert.assertEquals(msgPositveNumber,res.asString());
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}	

	
	/**
	 * Testing negative number input scenario
	 */
	@Test
	public void testNegativeNumber(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect/-10");
		        
		     Response res = get("/isperfect/-10");   		        
		     
		     Assert.assertEquals(msgPositveNumber,res.asString());
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}		
	
	/**
	 * Testing Alphanumeric input scenario
	 */
	@Test
	public void testAlphaNumberic(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect/abcd1234");
		        
		     Response res = get("/isperfect/abcd1234");   		        
		     
		     Assert.assertEquals(msgPositveNumber,res.asString());
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}			
	
	
	/**
	 * Testing zero input scenario
	 */
	@Test
	public void testInputZero(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect/0");
		        
		     Response res = get("/isperfect/0");   		        
		     
		     Assert.assertEquals(resultNo,res.asString());
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}
	
	/**
	 * Testing large number scenario
	 * Maximum length is 10
	 */
	@Test
	public void testLargeNumber(){
		
		try{
			
		    given().
		    expect().
		    when().
		        get("/isperfect/12345678901");
		        
		     Response res = get("/isperfect/12345678901");   		        
		     
		     Assert.assertEquals(msgLargeNumber,res.asString());
		        
		}catch(RuntimeException re){
				re.getMessage();
		}
			
			
	}	
	
}



