/*

In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size. For example, take a look at this problem:

    Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

Let’s understand this problem with a real input:

Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:

    For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6−1)/5=>2.2(1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
    The average of next 5 numbers (subarray from index 1-5) is: (3+2+6−1+4)/5=>2.8(3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
    For the next 5 numbers (subarray from index 2-6), the average is: (2+6−1+4+1)/5=>2.4(2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
    …

Here is the final output containing the averages of all contiguous subarrays of size 5:

Output: [2.2, 2.8, 2.4, 3.6, 2.8]

*/
// Brute Force


/*

The efficient way to solve this problem would be to visualize each contiguous subarray as a sliding window of ‘5’ elements. 
This means that when we move on to the next subarray, we will slide the window by one element. 
So, to reuse the sum from the previous subarray, we will subtract the element going out of the window and add the element now being included in the sliding window. 
This will save us from going through the whole subarray to find the sum and, as a result, the algorithm complexity will reduce to O(N.

*/

