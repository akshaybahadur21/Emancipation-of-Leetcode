/*

1286. Iterator for Combination
Medium

Design an Iterator class, which has:

    A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
    A function next() that returns the next combination of length combinationLength in lexicographical order.
    A function hasNext() that returns True if and only if there exists a next combination.

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

    1 <= combinationLength <= characters.length <= 15
    There will be at most 10^4 function calls per test.
    It's guaranteed that all calls of the function next are valid.

*/

class CombinationIterator {

    List<String> list = new ArrayList<>();
    int listPos = 0;
    public CombinationIterator(String characters, int combinationLength) {
        dfs(characters, combinationLength, "", 0);
    }
    private void dfs(String s, int len, String curr, int idx){
        if(curr.length() == len){
            list.add(curr);
            return;
        }
        for(int i = idx; i < s.length(); i++){
            dfs(s,len, curr + s.charAt(i), i + 1);
        }
    }
    
    public String next() {
        return list.get(listPos++);
    }
    
    public boolean hasNext() {
        if(listPos == list.size())
            return false;
        return true;
    }
}
