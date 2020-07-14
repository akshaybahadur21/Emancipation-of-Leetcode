/*

1344. Angle Between Hands of a Clock
Medium

Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

Example 1:

Input: hour = 12, minutes = 30
Output: 165

Example 2:

Input: hour = 3, minutes = 30
Output: 75

Example 3:

Input: hour = 3, minutes = 15
Output: 7.5

Example 4:

Input: hour = 4, minutes = 50
Output: 155

Example 5:

Input: hour = 12, minutes = 0
Output: 0
 

Constraints:

    1 <= hour <= 12
    0 <= minutes <= 59
    Answers within 10^-5 of the actual value will be accepted as correct.

*/

class Solution {
    public double angleClock(int hour, int minutes) {
        // we will check each clock handle against 12 o' clock
        Map<Integer, Integer> hourToDegree = new HashMap<>();
        hourToDegree.put(0, 0);
        hourToDegree.put(1, 30);
        hourToDegree.put(2, 60);
        hourToDegree.put(3, 90);
        hourToDegree.put(4, 120);
        hourToDegree.put(5, 150);
        hourToDegree.put(6, 180);
        hourToDegree.put(7, 210);
        hourToDegree.put(8, 240);
        hourToDegree.put(9, 270);
        hourToDegree.put(10, 300);
        hourToDegree.put(11, 330);
        hourToDegree.put(12, 360);
        
        double res = Math.abs(( (double)hourToDegree.get(hour) + ((double)minutes/60 * 30)) - (double)minutes * 6.0);
        return res > 180.0 ? 360.0 - res : res;
        
    }
}
