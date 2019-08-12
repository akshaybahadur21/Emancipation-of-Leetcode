/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Question Link : https://leetcode.com/problems/longest-common-prefix/

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if (strs.length==1)
            return strs[0].toString();
            
        boolean flag=false;
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));
        
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=1;j<strs.length;j++)
            {
                if (strs[0].charAt(i)==strs[j].charAt(i))
                    flag=true;
                else
                {
                    flag =false;
                    i=strs[0].length();
                    break;
                }
            }
            if (flag==true)
                    sb.append(strs[0].charAt(i));            
        }

        return sb.toString();
        
    }
}
