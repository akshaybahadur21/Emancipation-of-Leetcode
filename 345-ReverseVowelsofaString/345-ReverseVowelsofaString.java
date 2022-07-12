/*

345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char ch : new String("aeiouAEIOU").toCharArray()) set.add(ch);
        Queue<Character> q = new LinkedList<>();
        for(char ch : arr){
            if(set.contains(ch)) q.add(ch);
        }
        for(int i = arr.length - 1; i >= 0; i--){
            if(set.contains(arr[i])) arr[i] = q.poll();
        }
        return String.valueOf(arr);
    }
}
