/*

1002. Find Common Characters
Easy

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]

Note:

    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter

*/


class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList();
        if(A == null || A.length == 0) return res;
        int[] map = new int[26];
        //create map for first string
        for(char ch : A[0].toCharArray()) map[ch - 'a']++;
        for(int i = 1; i < A.length; i++){
            int[] newMap = new int[26];
            for(char ch : A[i].toCharArray()){
                if(map[ch - 'a'] > 0){
                    newMap[ch - 'a']++;
                    map[ch - 'a']--;
                }
            }
            map = newMap;
        }
        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                while(map[i] > 0){
                    res.add(Character.toString('a' + i));
                    map[i]--;
                }
            }
        }
    return res;            
    }
}

