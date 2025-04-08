"""

1054. Distant Barcodes

In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

Example 1:

Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:

Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]

Constraints:

    1 <= barcodes.length <= 10000
    1 <= barcodes[i] <= 10000

"""

class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        res = [0] * len(barcodes)
        mapp = Counter(barcodes)
        heap = []
        for k,v in mapp.items(): heappush(heap, (-v, k, v))
        idx = 0
        while heap:
            _, k, v = heappop(heap)
            for _ in range(v):
                res[idx] = k
                idx += 2
                if idx >= len(res): idx = 1
        return res
