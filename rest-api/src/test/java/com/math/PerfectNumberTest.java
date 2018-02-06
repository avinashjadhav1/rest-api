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
		     Assert.assertEquals("YES",res.asString());		        
		        
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
		     Assert.assertEquals("NO",res.asString());		        
		        
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
		

}



