/*

1395. Count Number of Teams
Medium

There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

    Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
    A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).

Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 

Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.

Example 3:

Input: rating = [1,2,3,4]
Output: 4

Constraints:

    n == rating.length
    1 <= n <= 200
    1 <= rating[i] <= 10^5

*/

class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        if(rating == null || rating.length < 3) return res;
        for(int i = 0; i < rating.length - 2; i++){
            for(int j = i + 1; j < rating.length - 1; j++){
                for(int k = j + 1; k < rating.length; k++){
                    if((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k]))
                        res++;
                }
            }
        }
        return res;
    }
}
