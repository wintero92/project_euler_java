/**
 * This package contains utility classes and methods for solving Euler problems.
 */
package com.ondrejwinter.euler;

/**
 * The {@code Common} class provides utility methods for mathematical operations commonly used in solving Euler
 * problems.
 */
public class Common {

  /**
   * Calculates the sum of all numbers divisible by a given divisor up to a given multiple.
   *
   * <p>
   * This method determines the sum of all integers less than or equal to {@code multiple} that are divisible by
   * {@code divisor}. The formula used is derived from the arithmetic progression sum formula:
   *
   * <pre>
   * S = n/2 * (first_term + last_term)
   * </pre>
   * <p>
   * where:
   * <ul>
   * <li>{@code n} is the number of terms in the sequence,</li>
   * <li>{@code first_term} is the smallest number divisible by {@code divisor}, which is simply {@code divisor}, and</li>
   * <li>{@code last_term} is the largest number less than or equal to {@code multiple} that is divisible by {@code divisor}.</li>
   * </ul>
   *
   * <p>
   * Using this formula, the sum can be expressed as:
   *
   * <pre>
   * S = n/2 * (divisor + (n * divisor))
   * </pre>
   * <p>
   * Since {@code n} is the number of terms divisible by {@code divisor} up to {@code multiple},
   * it can be calculated as:
   *
   * <pre>
   * n = multiple / divisor
   * </pre>
   * <p>
   * Substituting this value of {@code n} back into the formula gives:
   *
   * <pre>
   * S = (divisor * n * (n + 1)) / 2
   * </pre>
   * <p>
   * This simplified formula avoids explicitly iterating through all divisible numbers, providing a
   * computationally efficient solution.
   *
   * @param multiple The upper limit (inclusive) to calculate the sum of divisible numbers.
   * @param divisor  The divisor used to determine divisibility.
   * @return The sum of all numbers divisible by {@code divisor} up to {@code multiple}.
   */
  public static Long sumDivisible(Long multiple, Long divisor) {
    long p = multiple / divisor; // Calculate the number of terms divisible by the divisor
    return (divisor * p * (p + 1)) / 2; // Use the formula to calculate the sum
  }

  /**
   * Checks if a given number is a palindrome.
   *
   * <p>
   * A palindrome is a number that reads the same forwards and backwards. For example, 121 and 12321 are palindromes,
   * but 123 is not.
   *
   * <p>
   * The algorithm for reversing a number works as follows:
   * <ol>
   * <li>Start with the original number and initialize the reverse to 0.</li>
   * <li>Extract the last digit of the number using the modulo operation ({@code number % 10}).</li>
   * <li>Append the digit to the reversed number by multiplying the current reversed number by 10 and adding the digit.</li>
   * <li>Remove the last digit from the original number by performing integer division ({@code number / 10}).</li>
   * <li>Repeat steps 2-4 until the original number becomes 0.</li>
   * </ol>
   * <p>
   * At the end of this process, the reversed number is compared with the original number
   * to determine if it is a palindrome.
   *
   * @param number The number to check.
   * @return {@code true} if the number is a palindrome, {@code false} otherwise.
   */
  public static boolean isPalindrome(long number) {
    long original = number;
    long reverse = 0;

    // Reverse the number
    while (number > 0) {
      long digit = number % 10;
      reverse = reverse * 10 + digit;
      number /= 10;
    }

    return original == reverse;
  }
}
