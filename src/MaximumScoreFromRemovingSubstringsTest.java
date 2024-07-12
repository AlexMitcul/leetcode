import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumScoreFromRemovingSubstringsTest {

    private final MaximumScoreFromRemovingSubstrings solver =
            new MaximumScoreFromRemovingSubstrings();

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("cdbcbbaaabab", 4, 5, 19),
                Arguments.of("aabbaaxybbaabb", 5, 4, 20),
                Arguments.of("cabxbae", 2, 1, 3),
                Arguments.of("aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha", 1926, 4320, 112374)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void maximumScoreFromRemovingSubstringsTest(String input, int x, int y, int expected) {
        int actual = solver.maximumGain(input, x, y);
        assertEquals(expected, actual);
    }
}