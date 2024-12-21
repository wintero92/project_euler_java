package com.ondrejwinter.euler;

import java.util.Optional;

public class Problem004 implements Problem {


  @Override
  public Long naive(Long input) {
    int maxNumber = (int) Math.pow(10, input) - 1;
    int minNumber = (int) Math.pow(10, input - 1);
    int largestPalindrome = 0;

    // Iterate through numbers starting from maxNumber and decrement
    for (int i = maxNumber; i >= minNumber; i--) {
      for (int j = maxNumber; j >= minNumber; j--) {
        int product = i * j;
        if (Common.isPalindrome(product) && product > largestPalindrome) {
          largestPalindrome = product;
        }
      }
    }

    return (long) largestPalindrome;
  }

  public Optional<Long> optimized(Long input) {
    int maxNumber = (int) Math.pow(10, input) - 1;
    int minNumber = (int) Math.pow(10, input - 1);
    int largestPalindrome = 0;

    // Iterate through numbers from maxNumber to minNumber
    for (int i = maxNumber; i >= minNumber; i--) {
      for (int j = i; j >= minNumber; j--) { // Avoid duplicate calculations
        int product = i * j;
        if (product < largestPalindrome) {
          break; // No need to check smaller products
        }
        if (Common.isPalindrome(product)) {
          largestPalindrome = product;
        }
      }
    }

    return Optional.of((long) largestPalindrome);
  }
}
