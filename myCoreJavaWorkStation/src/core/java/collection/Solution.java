package core.java.collection;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {    
    String s = "aeouisddaaeeiouua"; 
    System.out.println(countSubstrings(s)); 
    }

    public static boolean isVowel(char c){
        if(c =='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u'){
            return true;
        }else{
            return false;
        }
    }

    public static int countSubstringsUtil(char [] s){
        int count= 0;
        Map<Character,Integer> vowCouter = new HashMap<>();

        int length = s.length;

        int start = 0;

        for(int i=0; i< length ; i++){
            if(vowCouter.containsKey(s[i])){
                vowCouter.put(s[i], vowCouter.get(s[i]) + 1);
            }else{
                vowCouter.put(s[i], 1);
            }
        
          while (vowCouter.containsKey('a') && vowCouter.containsKey('e') && 
               vowCouter.containsKey('i') && vowCouter.containsKey('o') && 
               vowCouter.containsKey('u') && vowCouter.get('a') > 0 &&  
               vowCouter.get('e') > 0 && vowCouter.get('i') > 0 &&  
             vowCouter.get('o') > 0 && vowCouter.get('u') > 0)  { 
            count += length - i; 
            vowCouter.put(s[start], vowCouter.get(s[start]) - 1); 
            start++; 
        }
    } 
        return count; 	
    }
 

static int countSubstrings(String s) 
{ 

    int count = 0; 

    String temp = ""; 

    for (int i = 0; i < s.length(); i++)  

    { 

        if (isVowel(s.charAt(i)))  

        { 

            temp += s.charAt(i); 

        } 

        else 

        { 

            if (temp.length() > 0) 

                count += countSubstringsUtil(temp.toCharArray()); 

            temp = ""; 

        } 

    } 

    if (temp.length() > 0) 

        count += countSubstringsUtil(temp.toCharArray()); 

    return count; 

} 

}

