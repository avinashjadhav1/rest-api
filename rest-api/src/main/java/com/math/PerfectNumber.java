package com.math;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
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
		final String msgPositveNumber="Please enter positive number";
		final String msgLargeNumber="Number too large to process. Maximum allowed length is 10";
		final String resultYes="YES";
		final String resultNo="NO";	
		long n, sum=0;
		String result="";
		
		try{			
			//Checking if input is numeric
			if(StringUtils.isNumeric(num)==false){
				return msgPositveNumber;
			}
			//checking length of number
			if(num.length()>10){
				return msgLargeNumber;
			}
			
			//Checking the sign of number
			int sign = Long.signum(Long.parseLong(num));
			if(sign==-1){				
				return msgPositveNumber;
			}
			//checking if input is 0
			if(Long.parseLong(num)==0){
				return resultNo;
			}
			
			//breaking input number into tokens
			Scanner s = new Scanner(num.toString());
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
	            result=resultYes;
	        }
	        else
	        {
	        	result=resultNo;    
	        } 
			s.close();
			
		}catch(InputMismatchException ie){
			ie.getMessage();
			//validating input and returning message
			return msgPositveNumber;
		}
		
		//final output
		return result;				
	}
}
