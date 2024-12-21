/**
 * This package contains implementations for solving specific Euler problems.
 */
package com.ondrejwinter.euler;

import java.util.Optional;

/**
 * The {@code Problem002} class implements the solution for Problem 002 of Project Euler.
 *
 * <p>
 * Problem 002: Find the sum of even Fibonacci numbers not exceeding a given limit.
 *
 * <p>
 * This class provides two approaches to solve the problem:
 * <ul>
 *   <li>A naive approach using iteration and checking each Fibonacci number for evenness.</li>
 *   <li>An optimized approach that directly generates even Fibonacci numbers.</li>
 * </ul>
 */
public class Problem002 implements Problem {

  /**
   * Solves the problem using a naive approach.
   *
   * <p>
   * This method generates all Fibonacci numbers up to {@code input}, checks if each number
   * is even, and adds it to the sum if it is. The time complexity is O(n) with respect to
   * the number of Fibonacci numbers generated.
   *
   * @param input The upper limit for Fibonacci numbers to include in the sum.
   * @return The sum of even Fibonacci numbers not exceeding {@code input}.
   */
  @Override
  public Long naive(Long input) {
    int sum = 0;
    int a = 1;
    int b = 2;

    while (a <= input) {
      if (a % 2 == 0) {
        sum += a;
      }

      int next = a + b;
      a = b;
      b = next;
    }

    return (long) sum;
  }

  /**
   * Solves the problem using an optimized approach.
   *
   * <p>
   * This method leverages the property that every third Fibonacci number is even.
   * Instead of generating all Fibonacci numbers, it directly generates even Fibonacci
   * numbers using the recurrence relation:
   *
   * <pre>
   * F(n+3) = 4 * F(n+2) + F(n)
   * </pre>
   *
   * The time complexity of this approach is O(log(input)) since it only computes
   * even Fibonacci numbers.
   *
   * @param input The upper limit for Fibonacci numbers to include in the sum.
   * @return An {@link Optional} containing the sum of even Fibonacci numbers not exceeding {@code input}.
   */
  @Override
  public Optional<Long> optimized(Long input) {
    int sum = 0;

    int a = 2;
    int b = 8;

    while (a <= input) {
      sum += a;

      int next = 4 * b + a;
      a = b;
      b = next;
    }

    return Optional.of((long) sum);
  }
}
