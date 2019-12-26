/*

387. First Unique Character in a String
Easy

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 

Link : https://leetcode.com/problems/first-unique-character-in-a-string/

*/


public class Solution {
    public int firstUniqChar(String s) {
        if (s.length()==0)
            return -1;
        LinkedHashMap <Character, Pair> lookupMap = new LinkedHashMap <>();
        for (int i=0;i<s.length();i++)
        {
            if(!lookupMap.containsKey(s.charAt(i))){
                Pair p = new Pair(1,i);
                lookupMap.put(s.charAt(i),p);
            }
            else{
                 Pair p = lookupMap.get(s.charAt(i));
                 p.setcount(p.getcount()+1);
                 lookupMap.put(s.charAt(i),p);
            }
                
        }
        
        for (Map.Entry mapElement : lookupMap.entrySet()) { 
            Character key = (Character)mapElement.getKey(); 
            Pair value = ((Pair)mapElement.getValue()); 

        
            if  (value.getcount()==1)
                return value.getindex();
        }
        return -1;
        
    }

public static class Pair{
    int count;
    int index;
    
    public Pair(int count, int index) 
        { 
            this.count = count; 
            this.index = index; 
        } 
  
        public int getindex() 
        { 
            return this.index; 
        } 
  
        public int getcount() 
        { 
            return this.count; 
        } 
  
        public void setindex(int index) 
        { 
            this.index = index; 
        } 
  
        public void setcount(int count) 
        { 
            this.count = count; 
        } 
    } 
}
