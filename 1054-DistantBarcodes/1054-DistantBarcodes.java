/*

1054. Distant Barcodes
Medium

In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists. 

Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]

Note:

    1 <= barcodes.length <= 10000
    1 <= barcodes[i] <= 10000

*/

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> heap = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]); //max heap frequency
        for(int i : barcodes)
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        int[] res = new int[barcodes.length];
        int idx = 0;
        while(!heap.isEmpty()){
            int temp[] = heap.poll();
            while(temp[1]-- != 0){
                res[idx] = temp[0];
                idx = idx + 2;
                if (idx >= barcodes.length) 
                    idx = 1;
            }
        }
        return res;
    }
}
