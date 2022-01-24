/*

520. Detect Capital
Easy

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:

Input: "USA"
Output: True

Example 2:

Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        boolean isFirstCaptial = false;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(i == 0)
                isFirstCaptial = ch >= 'A' && ch <= 'Z' ? true : false;
            if(ch >= 'A' && ch <= 'Z')
                upperCount++;
        }
        if(upperCount == word.length() || upperCount == 1 && isFirstCaptial || upperCount == 0) return true;
        return false;
    }
}

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        int count = 0, first = 0;
        for(int i = 0; i < word.length(); i++){
            if(i == 0 && word.charAt(i) >= 'A' & word.charAt(i) <= 'Z') first++;
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z') count++;
        }
        return count == word.length() || count == 0 || count + first == word.length();
    }
}
