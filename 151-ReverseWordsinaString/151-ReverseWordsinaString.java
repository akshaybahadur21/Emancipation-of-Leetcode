/*

151. Reverse Words in a String
Medium

Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Note:

    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.

Follow up:

For C programmers, try to solve it in-place in O(1) extra space

*/

class Solution {
    //Multiple Apprach
    //1. get each word and reverse it
    //2. Use stack
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        String[] str = s.trim().split(" +");
        StringBuffer sb = new StringBuffer();
        for(int i =str.length-1;i >= 0; i--){
            if (str[i] != " ")
                sb.append(str[i]+" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}

class Solution {
    //Multiple Apprach
    //1. get each word and reverse it
    //2. Use stack
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        String[] str = s.trim().split(" +");
        Stack<String> stack = new Stack<>();
        for(String sr : str)
            stack.push(sr);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString().substring(0, sb.length() -1);
    }
}
