package csen703.main.assignment1;

import java.util.ArrayList;
//ADDING A COMMENT
//adding another push
public class TestSolis {

    public static void main(String[] args) {
        System.out.println("--- GUC CSEN 703: Assignment 1 Test Runner ---\n");

        // Test Case 1: The main example
        testCode("4182113");

        // Test Case 2: The edge case with zeros
        testCode("2025");

        // Test Case 3: Invalid trailing zero
        testCode("80");
        
        // Extra Test: Simple ABC
        testCode("123");
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