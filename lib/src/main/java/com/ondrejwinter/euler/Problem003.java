/**
 * This package contains implementations for solving specific Euler problems.
 */
package com.ondrejwinter.euler;

import java.util.Optional;

/**
 * The {@code Problem003} class implements the solution for Problem 003 of Project Euler.
 *
 * <p>
 * Problem 003: Find the largest prime factor of a given number.
 *
 * <p>
 * This class provides two approaches to solve the problem:
 * <ul>
 *   <li>A naive approach using trial division for all numbers up to the given number.</li>
 *   <li>An optimized approach using properties of prime factors and reducing the search space.</li>
 * </ul>
 */
public class Problem003 implements Problem {

  /**
   * Solves the problem using a naive approach.
   *
   * <p>
   * This method finds the largest prime factor of {@code input} by iterating over all numbers from 2 to the input,
   * dividing out factors when they are found. This approach is straightforward but inefficient for large numbers, with
   * a time complexity of O(n).
   *
   * @param input The number for which to find the largest prime factor.
   * @return The largest prime factor of {@code input}.
   */
  @Override
  public Long naive(Long input) {
    long largestPrime = -1;

    for (long i = 2; i <= input; i++) {
      while (input % i == 0) {
        largestPrime = i;
        input /= i;
      }
    }

    return largestPrime;
  }

  /**
   * Solves the problem using an optimized approach.
   *
   * <p>
   * This method uses the fact that prime factors come in pairs and reduces the input number by dividing out factors of
   * 2 first (to handle even numbers efficiently), and then checks odd numbers up to the square root of the remaining
   * value. If the remaining value is greater than 2, it is a prime number and the largest prime factor.
   *
   * <p>
   * This approach has a time complexity of O(\sqrt{n}).
   *
   * @param input The number for which to find the largest prime factor.
   * @return An {@link Optional} containing the largest prime factor of {@code input}.
   */
  @Override
  public Optional<Long> optimized(Long input) {
    long largestPrime = -1;
    
    // Check and divide out factors of 2
    if (input % 2 == 0) {
      largestPrime = 2;
      while (input % 2 == 0) {
        input /= 2;
      }
    }

    // Check odd factors up to the square root of the input
    for (long i = 3; i <= Math.sqrt(input); i += 2) {
      while (input % i == 0) {
        largestPrime = i;
        input /= i;
      }
    }

    // If the remaining input is greater than 2, it is prime
    if (input > 2) {
      largestPrime = input;
    }

    return Optional.of(largestPrime);
  }
}
