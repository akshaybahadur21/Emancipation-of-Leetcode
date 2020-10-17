/*

187. Repeated DNA Sequences
Medium

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

Constraints:

    0 <= s.length <= 105
    s[i] is 'A', 'C', 'G', or 'T'.

*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if(s == null || s.length() < 10) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length() - 10 + 1; i++){
            String str = s.substring(i, i + 10);
            if(set.contains(str)) res.add(str);
            set.add(str);
        }
        return new ArrayList<>(res);
    }
}
