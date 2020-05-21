/*

1268. Search Suggestions System
Medium

Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]

Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]

Constraints:

    1 <= products.length <= 1000
    There are no repeated elements in products.
    1 <= Σ products[i].length <= 2 * 10^4
    All characters of products[i] are lower-case English letters.
    1 <= searchWord.length <= 1000
    All characters of searchWord are lower-case English letters.

*/

class Solution {
    TNode root = new TNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // trie based approach
        List<List<String>> resList = new ArrayList();
        if(!validateInput(products, searchWord)) return resList;
        Arrays.sort(products);
        for(String prod : products)
            insertInTrie(prod);
        TNode temp = root;
        for(int i = 0; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            if(temp == null || !temp.children.containsKey(ch)){
                for (int j = i; j < searchWord.length(); j++)
                    resList.add(Collections.EMPTY_LIST);    
                break;
            }
            else
                resList.add(temp.children.get(ch).words);
            temp = temp.children.get(ch);
        }
       return resList; 
        
    }
    private boolean validateInput(String[] products, String searchWord){
        if(products == null || products.length == 0 || searchWord == null || searchWord.length() == 0)
            return false;
        return true;
        
    }
    
    private void insertInTrie(String str){
        TNode temp = root;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(temp.children.containsKey(ch))
                temp = temp.children.get(ch);
            else{
                temp.children.put(ch, new TNode());
                temp = temp.children.get(ch);
            }
            temp.isEnd = true;
            if (temp.words.size() < 3)
                    temp.words.add(str);
        }
    }
}
class TNode{
    boolean isEnd;
    Map<Character, TNode> children;
    List<String> words;
    TNode(){
        isEnd = false;
        children = new HashMap<>();
        words = new ArrayList<>();
    }
}
