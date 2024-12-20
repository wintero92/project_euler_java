package com.ondrejwinter.euler;

import java.util.Optional;

public class Problem001 implements Problem {

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

    @Override
    public Optional<Long> optimized(Long input) {
        return Optional.of(
                Common.sumDivisible(input - 1, 3L)
                        + Common.sumDivisible(input - 1, 5L)
                        - Common.sumDivisible(input - 1, 15L));
    }

}
