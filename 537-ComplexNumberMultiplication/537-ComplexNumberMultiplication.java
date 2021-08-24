/*

537. Complex Number Multiplication
Medium

A complex number can be represented as a string on the form "real+imaginaryi" where:

    real is the real part and is an integer in the range [-100, 100].
    imaginary is the imaginary part and is an integer in the range [-100, 100].
    i2 == -1.

Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

Constraints:

    num1 and num2 are valid complex numbers.

*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int n1 = 0, n2 = 0, i1 = 0, i2 = 0;
        int real = 0, imag = 0;
        n1 = Integer.parseInt(num1.split("\\+")[0]);
        n2 = Integer.parseInt(num2.split("\\+")[0]);
        String temp = num1.split("\\+")[1];
        i1 = Integer.parseInt(temp.substring(0, temp.length() - 1));
        temp = num2.split("\\+")[1];
        i2 = Integer.parseInt(temp.substring(0, temp.length() - 1));
        
        real = (n1 * n2) - (i1 * i2);
        imag = (i1 * n2) + (i2 * n1);
        
        StringBuilder sb = new StringBuilder();
        sb.append(real).append("+").append(imag).append("i");
        return sb.toString();
    }
}
