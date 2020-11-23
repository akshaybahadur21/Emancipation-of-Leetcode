/*

433. Minimum Genetic Mutation
Medium

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

    Starting point is assumed to be valid, so it might not be included in the bank.
    If multiple mutations are needed, all mutations during in the sequence must be valid.
    You may assume start and end string is not the same.

Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2

 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3

*/

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        if(!bankSet.contains(end)) return -1;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int res = 1;
        Set<String> vis = new HashSet<>();
        vis.add(start);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                char[] cArr = q.poll().toCharArray();
                for(int j = 0; j < cArr.length; j++){
                    char temp = cArr[j];
                    for(char ch : choices){
                        cArr[j] = ch;
                        String mutatedStr = String.valueOf(cArr);
                        if(end.equals(mutatedStr)) return res;
                        if(bankSet.contains(mutatedStr) && !vis.contains(mutatedStr)){
                            vis.add(mutatedStr);
                            q.add(mutatedStr);
                        }
                    }
                    cArr[j] = temp;
                }
            }
            res++;
        }
        return -1;
    }
}
