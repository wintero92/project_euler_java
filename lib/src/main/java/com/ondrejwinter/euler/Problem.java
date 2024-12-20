package com.ondrejwinter.euler;

import java.util.Optional;

public interface Problem {
    
    Long naive(Long input);

    Optional<Long> optimized(Long input);

}
