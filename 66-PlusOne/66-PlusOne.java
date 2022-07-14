/*

66. Plus One
Easy

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

*/

class Solution {
    public int[] plusOne(int[] digits) {
        String number = Arrays.toString(digits);
        int carry = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = number.length() - 1; i >= 0; i--){
            if(!Character.isDigit(number.charAt(i))) continue;
            int d = Character.getNumericValue(number.charAt(i));
            int sum = d + carry;
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(sum);
        }
        if(carry > 0) sb.append(carry);
        String res = sb.reverse().toString();
        int[] resArr = new int[res.length()];
        for(int i = 0; i < res.length(); i++)
            resArr[i] = Character.getNumericValue(res.charAt(i));
        return resArr;
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int one = 1, carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int curr = digits[i];
            curr = curr + one + carry;
            if(curr >= 10){
                carry = 1;
                curr = curr % 10;
            }
            else carry = 0;
            list.add(0, curr);
            one = 0;
        }
        if(carry == 1)list.add(0, carry);
        return list.stream().mapToInt(i->i).toArray();
    }
}
