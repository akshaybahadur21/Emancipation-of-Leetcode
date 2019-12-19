/*

551. Student Attendance Record I
Easy
You are given a string representing an attendance record for a student. The record only contains the following three characters:

    'A' : Absent.
    'L' : Late.
    'P' : Present.

A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:

Input: "PPALLP"
Output: True

Example 2:

Input: "PPALLL"
Output: False

Link : https://leetcode.com/problems/student-attendance-record-i/

*/
class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i =0; i<s.length(); i++){
            if (s.charAt(i) == 'A')
                countA++;
            if (countA > 1)
                return false;
            if (i+2 < s.length() && s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L')
                return false;
        }
        return true;
    }
}
