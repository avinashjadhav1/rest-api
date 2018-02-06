package com.math;

import static spark.Spark.*;

/**
 * 
 * @author Avinash Jadhav
 * 
 * Description: This class "PerfectNumberService.java" implements REST Service 
 * 
 */

public class PerfectNumberService {

	public static void main(String[] args) {
		/** REST call
		 *   
		 */
		get("/isperfect/:number", (req,res) -> PerfectNumber.getResult(req.params(":number")));

	}

}
