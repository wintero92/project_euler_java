package com.ondrejwinter.euler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.logging.Logger;

class ProblemsTest {

    private static final Logger LOGGER = Logger.getLogger(ProblemsTest.class.getName());

    private static final Long[] SOLUTIONS = TestUtils.loadSolutions();
    private static final Long[] INPUTS = TestUtils.loadInputs();

    private static final Problem[] SOLVED_PROBLEMS = {
            new Problem001()
    };

    @Test
    void testNaive() {
        for (int i = 0; i < SOLVED_PROBLEMS.length; i++) {
            Long input = INPUTS[i];
            Long expectedSolution = SOLUTIONS[i];
            Long result = SOLVED_PROBLEMS[i].naive(input);
            Assertions.assertEquals(expectedSolution, result, 
                "Naive implementation failed for problem : " + (i + 1));
        }
    }

    @Test
    void testOptimized() {
        for (int i = 0; i < SOLVED_PROBLEMS.length; i++) {
            Long input = INPUTS[i];
            Long expectedSolution = SOLUTIONS[i];

            Optional<Long> result = SOLVED_PROBLEMS[i].optimized(input);
            if (result.isPresent()) {
                Assertions.assertEquals(expectedSolution, result.get(), 
                    "Optimized implementation failed for problem: " + (i + 1));
            } else {
                LOGGER.warning("Optimized method not implemented or returned empty for problem: " + (i + 1));
            }
        }
    }
}
