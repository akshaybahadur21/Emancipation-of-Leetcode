/*

11. Container With Most Water
Medium

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

class Solution {
    public int maxArea(int[] height) {
        if(!validateInput(height)) return 0;
        int max = 0, len = height.length - 1, left = 0, right = height.length - 1;
        while(left != right){
            int tempArea = Math.min(height[left], height[right]) * len--;
            max = Math.max(tempArea, max);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
    private boolean validateInput(int[] height){
        if(height == null || height.length == 0) 
            return false;
        return true;
    }
}
