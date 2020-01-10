/*

819. Most Common Word
Easy

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

Note:

    1 <= paragraph.length <= 1000.
    0 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.

*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //Strip the i/p string
        //create map for words and number of occurances
        //create a priorityQueue of size banned + 1 (this will have atleast one correct answer)
        Map<String, Integer> lookupMap = new HashMap<>();
        Queue<String> heap = new PriorityQueue<>((n1, n2)-> lookupMap.get(n1) == lookupMap.get(n2) ? n2.compareTo(n1) : lookupMap.get(n1) - lookupMap.get(n2));
        paragraph = paragraph.replaceAll("[^A-Za-z\\s]","");
        String[] words = paragraph.toLowerCase().split(" ");
        for(String w : words)
            lookupMap.put(w,lookupMap.containsKey(w) ? lookupMap.get(w) + 1 : 1 );
        for(Map.Entry <String, Integer> entry : lookupMap.entrySet()){
            heap.add(entry.getKey());
            if(heap.size() > banned.length + 1)
                heap.poll();
        }
        String ans ="";
        List<String> list = Arrays.asList(banned);
        while(!heap.isEmpty()){
            if(!list.contains(heap.peek()))
                ans = heap.peek();
            heap.poll();
        }
        return ans;
    }
}
