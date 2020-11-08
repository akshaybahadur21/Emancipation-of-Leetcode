/*

1647. Minimum Deletions to Make Character Frequencies Unique
Medium

A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

Constraints:

    1 <= s.length <= 105
    s contains only lowercase English letters.

*/

class Solution {
    public int minDeletions(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1 );
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (n1, n2) -> n2 - n1);
        Set<Integer> set = new HashSet<>();
        for(int v : values){
            if(set.contains(v)){
                while(set.contains(v) && v != 0) {
                    res++;
                    v--;
                }
            }
        set.add(v);
        }
        return res;
    }
}
