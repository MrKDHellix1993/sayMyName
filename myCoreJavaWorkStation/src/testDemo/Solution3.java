package testDemo;

import java.util.LinkedHashMap;

public class Solution3 {
    public static int solve(String A, int[] B, String C) {
    	int size = 0;
    	if(null != C)
    	{
    		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
    		
    		size = C.length();
    		
    		if(size > A.length())
    		{
    			
    		}else {
    			if(A.contains(C))
    	        {
    				for(int j = 0 ; j < B.length ; j++)
    				{
    					hm.put(j , B[j]);
    				}
    				
					/*
					 * for(int i = 0 ; i < A.length() ; i++) { if(A.substring(i, size).equals(C)) {
					 * if(hm.get(i) > ) } }
					 */
    	          return 0;  
    	        }
    	        else{
    	            return -1;
    	        }
    		}
    		
    	}
    	return 0;
    }
    
    public static void main( String [] a) {
    	String ip = "abbaba";
		int A[] = {3 , 5 , 2 , 4 , 1 , 1};
		String c = "ab";
		System.out.println( solve(ip , A , c));
	}
}
