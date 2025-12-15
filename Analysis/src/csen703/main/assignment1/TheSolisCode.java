package csen703.main.assignment1;

import java.util.ArrayList;

public class TheSolisCode {
	
//==============================================================================================================
//=====================================================Start Of Class===========================================
	
	//================================================================================
	//=============================Divide And Conquer=================================
	//================================================================================
    public static Integer SolisDecodeDiv(String Code) {
        if (Code == null || Code.length() == 0) {
            return 0;
        }
        return divHelper(Code, 0);
    }

    private static int divHelper(String code, int index) {
    	if (index == code.length()) {
    		return 1;
    	}
    	
    	int count = 0;
    	
    	if(index < code.length() - 1) {
    		String two_digits = code.substring(index , index + 2);
    		int int_two_digits = Integer.parseInt(two_digits);
    		if(int_two_digits <= 26 && int_two_digits >= 1){
    			count += divHelper(code,index + 2);
    		}
    	}
    	if(code.charAt(index) != '0') {
    		count += divHelper(code, index + 1);
    	}
    	return count;
    }
    
    
	//================================================================================
	//=============================Dynamic Programming================================
    //================================================================================    
    public static Integer SolisDecodeDP(String code) {
        
    	if (code == null || code.length() == 0) {
            return 0;
        }
        
    	int code_length = code.length();
        int[] dp_table = new int[code_length + 1];
        dp_table[code_length] = 1;

        for (int i = code_length - 1; i >= 0; i--) {
            
        	dp_table[i] = 0;

            if (i < code_length - 1) {
                String twoDigits = code.substring(i, i + 2);
                int int_two_digits = Integer.parseInt(twoDigits);
                if (int_two_digits <= 26 && int_two_digits >= 1 ) {
                    dp_table[i] += dp_table[i + 2];
                }
            }
            
            if (code.charAt(i) != '0') {
                dp_table[i] += dp_table[i + 1];
            }
        }
        return dp_table[0];
    }

 
    
    //================================================================================
  	//=============================Results Generation=================================
  	//================================================================================
    public static ArrayList<String> SolisDecodedResults(String code) {
    	if(code == null || code.length() == 0) {
			return new ArrayList<>();
		}
		
		int code_length = code.length();
		
		@SuppressWarnings("unchecked")
		ArrayList<String>[] dp_table = new ArrayList[code_length+1];
		
		for(int i = 0 ; i <= code_length ; i++) {
			dp_table[i] = new ArrayList<>();
		}
		
		dp_table[code_length].add(""); // Base String the we will build on it
		
		for(int i = code_length - 1 ; i >= 0 ; i--) {
			
			if(i < code_length - 1) {
		
				String two_digits = code.substring(i , i + 2);
				int int_two_digits = Integer.parseInt(two_digits);
				
				if(int_two_digits >= 1 && int_two_digits <= 26) {
					char char_decoded = (char) ('a' + int_two_digits - 1);
					for (String suffix : dp_table[i + 2]) {
                        dp_table[i].add(char_decoded + suffix);
                    }
				}
				
			}
			
			if(code.charAt(i) != '0') {
				
				String single_digit = code.substring(i,i+1);
				int int_single_digit = Integer.parseInt(single_digit);
				char char_decoded = (char) ('a' + int_single_digit - 1);
				
				for(String suffix : dp_table[i + 1]) {
					dp_table[i].add(char_decoded + suffix);
				}
			}
			
		}
		
		return dp_table[0];
	}

//=====================================================End Of Class=============================================
//==============================================================================================================
    
}


