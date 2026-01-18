/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #28: PS4_Ex28_Addition.java
 * 
 * This program computes the sum of two integers in a recursive way.
 * 
 * fpm
 */

import java.util.*;

class Addition {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
    
        System.out.println("Sum = " );
    }
  
    // Add two integers recursively by adding digits in corresponding
    // columns together with carry.
    public static int add(int num1, int num2, int carry) {
        // base case - all input numbers and carry are 0, so we return 0
        if (num1 == 0 && num2 == 0 && carry == 0) {
            return 0;
        }

        // extract the last 2 digits of num1 and num2
        int lastDigitNum1 = num1 % 10;
        int lastDigitNum2 = num2 % 10;
        
        // sum the digits and carry
        int sum = lastDigitNum1 + lastDigitNum2 + carry; 
        
        // determine the new carry and sum digit
        int newCarry = sum / 10;
        int newSumDigit = sum % 10;
        
        // continue addition with the remaining digits of num1 and num2,
        // along with the new carry. we multiply the new add operation by 10 
        // to accurately represent moving from the ones place to the tens place
        // or the tens place to the hundreds place, and so on
        return newSumDigit + 10 * add(num1 / 10, num2 / 10, newCarry);  // stub
    }
}
