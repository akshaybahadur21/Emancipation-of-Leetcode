/*

767. Reorganize String
Medium

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:

Input: S = "aaab"
Output: ""

Note:

    S will consist of lowercase letters and have length in range [1, 500].

*/

class Solution {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0 ) return "";
        char[] chArray = new char[S.length()];
        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair> heap = new PriorityQueue<>((n1, n2) -> n2.getCount() - n1.getCount()); //max heap
        for(char ch : S.toCharArray())
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        if(heap.peek().getCount() >= Math.ceil((double)S.length() / (double)2) + 1) return "";
        int idx = 0;
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            while(p.getCount() != 0){
                chArray[idx] = p.getCh();
                idx = idx + 2;
                p.setCount(p.getCount() - 1);
                if(idx >= chArray.length)
                    idx = 1;
            }
        }
        return new String(chArray);
    }
}
class Pair{
    char ch;
    int count;
    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
    public char getCh(){
        return ch;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
}
