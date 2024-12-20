package com.ondrejwinter.euler;

public class Common {

    public static Long sumDivisible(Long multiple, Long divisor) {
        Long p = multiple / divisor;
        return (divisor * p * (p + 1)) / 2;
    }

}
