package csen703.main.assignment1;

import java.util.ArrayList;
//ADDING A COMMENT
//adding another push
//adding a comment
public class TestSolis {
	
	
	public static void testCodePrints(String[] arr) {
		System.out.println("--- GUC CSEN 703: Assignment 1 Test Runner ---\n");
		for(int i = 1;i<=arr.length;i++) {
			System.out.print("Code Number " + i + "\n");
			testCode(arr[i-1]);
		}
	}

    public static void main(String[] args) {
        
    	String[] codes = new String[] 
        		{"4182113",
				 "7213",
				 "191512919",
				 "411892119",
				 "931182119",
				 "851291519",
				 "2025",
				 "30",
				 "308",
				 "4300812",
				 "4200812",
				 "3008",
				 "2008",
				 "85121215231518124",
				 "9113918151413114"
        		};
        
        testCodePrints(codes);
     
    }

    public static void testCode(String code) {
        System.out.println("Testing Code: \"" + code + "\"");

        // 1. Test Divide and Conquer
        long startTime = System.nanoTime();
        Integer resultDiv = TheSolisCode.SolisDecodeDiv(code);
        long endTime = System.nanoTime();
        System.out.println("Output Div: " + resultDiv + " (Time: " + (endTime - startTime) + " ns)");

        // 2. Test Dynamic Programming (Count)
        startTime = System.nanoTime();
        Integer resultDP = TheSolisCode.SolisDecodeDP(code);
        endTime = System.nanoTime();
        System.out.println("Output DP : " + resultDP + " (Time: " + (endTime - startTime) + " ns)");
        
        // 3. Test Decoded Results
        ArrayList<String> results = TheSolisCode.SolisDecodedResults(code);
        System.out.println("Output Results: " + results);
        
        System.out.println("--------------------------------------------------");
    }
}