package com.math;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 * @author Avinash Jadhav
 * 
 * Description: This class "PerfectNumber.java" implements REST Service for 
 * finding out whether provided number is Perfect or not.
 */

public class PerfectNumber {
		
	/**
	 * String getResult
	 * @param num
	 * @return 
	 */
	public static String getResult(String num){
		
		/*
		 * Initializing variables
		 */
		long n, sum=0;
		String result="";
		
		try{			
			//breaking input number into tokens
			Scanner s = new Scanner(num);
			//capturing the input as integer
			n=s.nextLong();
			//loop for checking divisible numbers and sum those
			for(long i = 1; i <= n/2; i++)
	        {
	            if(n % i == 0)
	            {
	                sum = sum + i;
	            }
	        }
			
			if(sum == n)
	        {
	            result="YES";
	        }
	        else
	        {
	        	result="NO";    
	        } 
			s.close();
			
		}catch(InputMismatchException ie){
			ie.getMessage();
			//validating input and returning message
			return "Please enter positive number";
		}
		
		//final output
		return result;				
	}
}
