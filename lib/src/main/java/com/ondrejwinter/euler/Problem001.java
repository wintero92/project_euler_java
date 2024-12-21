/**
 * This package contains implementations for solving specific Euler problems.
 */
package com.ondrejwinter.euler;

import java.util.Optional;

/**
 * The {@code Problem001} class implements the solution for Problem 001 of Project Euler.
 *
 * <p>
 * Problem 001: Find the sum of all the multiples of 3 or 5 below a given limit.
 *
 * <p>
 * This class provides two approaches to solve the problem:
 * <ul>
 *   <li>A naive approach using iteration.</li>
 *   <li>An optimized approach leveraging arithmetic progressions for efficiency.</li>
 * </ul>
 */
public class Problem001 implements Problem {

  /**
   * Solves the problem using a naive approach.
   *
   * <p>
   * The method iterates through all numbers less than {@code limit}, checks if they are divisible by 3 or 5, and adds
   * them to the sum. This approach has a time complexity of O(n).
   *
   * @param limit The exclusive upper limit for checking multiples.
   * @return The sum of all multiples of 3 or 5 below the given {@code limit}.
   */
  @Override
  public Long naive(Long limit) {
    long sum = 0;

    for (int i = 1; i < limit; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }

    return sum;
  }

  /**
   * Solves the problem using an optimized approach.
   *
   * <p>
   * This method leverages the fact that the sum of multiples of a number can be computed efficiently using arithmetic
   * progression. It calculates:
   *
   * <pre>
   * sum = sumDivisible(limit - 1, 3) + sumDivisible(limit - 1, 5) - sumDivisible(limit - 1, 15)
   * </pre>
   * <p>
   * The subtraction of {@code sumDivisible(limit - 1, 15)} ensures that numbers that are multiples of both 3 and 5
   * (i.e., multiples of 15) are not double-counted.
   *
   * @param input The exclusive upper limit for calculating the sum of multiples.
   * @return An {@link Optional} containing the sum of all multiples of 3 or 5 below the given {@code input}.
   */
  @Override
  public Optional<Long> optimized(Long input) {
    return Optional.of(
        Common.sumDivisible(input - 1, 3L)
            + Common.sumDivisible(input - 1, 5L)
            - Common.sumDivisible(input - 1, 15L));
  }
}
