package com.ethumada.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    static Stream<TestData> testDataProvider() {
        return Stream.of(
                new TestData("aabb", List.of("abba", "baab")),
                new TestData("abc", List.of()),
                new TestData("aab", List.of("aba")),
                new TestData("racecar", List.of("rcaeacr", "craearc", "racecar", "arcecra", "carerac", "acrerca")),
                new TestData("aaa", List.of("aaa")),
                new TestData("aabbcc", List.of("cbaabc", "bcaacb", "cabbac", "acbbca", "baccab", "abccba"))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testGeneratePalindromes(TestData testData) {
        Solution solution = new Solution();
        List<String> result = solution.generatePalindromes(testData.input);
        assertThat(result).containsExactlyInAnyOrderElementsOf(testData.expected);
    }

    private static class TestData {
        String input;
        List<String> expected;

        TestData(String input, List<String> expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}
