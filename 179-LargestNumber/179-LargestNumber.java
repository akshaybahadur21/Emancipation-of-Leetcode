/*

179. Largest Number
Medium

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"

Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.

*/

class Solution {
    public String largestNumber(int[] nums) {
        String[] s_num = new String[nums.length];
		for(int i = 0; i < nums.length; i++) s_num[i] = String.valueOf(nums[i]);
        Arrays.sort(s_num, (s1, s2) -> (s2 + s1).compareTo((s1 + s2)));
        if(s_num[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String n : s_num) 
            sb.append(n);
        return sb.toString();
    }
}
