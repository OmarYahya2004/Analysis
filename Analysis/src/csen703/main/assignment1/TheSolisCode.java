package csen703.main.assignment1;

import java.util.ArrayList;

public class TheSolisCode {
    
    // ---------------------------------------------------------
    // Method 1: Recursive Solution
    // ---------------------------------------------------------
    public static Integer SolisDecodeDiv(String Code) {
        if (Code == null || Code.length() == 0) {
            return 0;
        }
        return solveDiv(Code, 0);
    }

    private static int solveDiv(String code, int index) {        
        if (index == code.length()) {
            return 1;
        }

        int count = 0;

        // 1. Two Digit Check (Prioritize 2 digits to match sample order/logic)
        // Range is 1-26 to allow "01" to "09"
        if (index + 1 < code.length()) {
            String twoDigits = code.substring(index, index + 2);
            int val = Integer.parseInt(twoDigits);
            if (val >= 1 && val <= 26) {
                count += solveDiv(code, index + 2);
            }
        }

        // 2. Single Digit Check
        // Only valid if the digit is NOT '0'
        if (code.charAt(index) != '0') {
            count += solveDiv(code, index + 1);
        }

        return count;
    }

    // ---------------------------------------------------------
    // Method 2: Dynamic Programming (Count only)
    // ---------------------------------------------------------
    public static Integer SolisDecodeDP(String Code) {
        if (Code == null || Code.length() == 0) {
            return 0;
        }

        int n = Code.length();
        int[] dp = new int[n + 1];

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 0;

            // 1. Two Digit Path
            if (i + 1 < n) {
                String twoDigits = Code.substring(i, i + 2);
                int val = Integer.parseInt(twoDigits);
                // Allow "01"-"09" (1-9) along with standard "10"-"26"
                if (val >= 1 && val <= 26) {
                    dp[i] += dp[i + 2];
                }
            }

            // 2. Single Digit Path
            if (Code.charAt(i) != '0') {
                dp[i] += dp[i + 1];
            }
        }

        return dp[0];
    }

    // ---------------------------------------------------------
    // Method 3: Return All Decoded Strings
    // ---------------------------------------------------------
    public static ArrayList<String> SolisDecodedResults(String Code) {
        if (Code == null || Code.length() == 0) {
            return new ArrayList<>();
        }

        int n = Code.length();
        // Use an array of ArrayLists for DP table
        ArrayList<String>[] dp = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }

        // Base case: empty string
        dp[n].add("");

        for (int i = n - 1; i >= 0; i--) {
            
            // 1. Check Double Digit first (to match sample order "ty", "tbe" before "bbe")
            if (i + 1 < n) {
                String twoDigits = Code.substring(i, i + 2);
                int val = Integer.parseInt(twoDigits);
                
                // Allow 1-26 (includes 01-09)
                if (val >= 1 && val <= 26) {
                    // 'a' + val - 1 converts 1->a, 2->b, etc.
                    char decodedChar = (char) ('a' + val - 1);
                    for (String suffix : dp[i + 2]) {
                        dp[i].add(decodedChar + suffix);
                    }
                }
            }

            // 2. Check Single Digit
            if (Code.charAt(i) != '0') {
                String oneDigit = Code.substring(i, i + 1);
                int val1 = Integer.parseInt(oneDigit);
                
                char decodedChar1 = (char) ('a' + val1 - 1);
                for (String suffix : dp[i + 1]) {
                    dp[i].add(decodedChar1 + suffix);
                }
            }
        }

        return dp[0];
    }
}