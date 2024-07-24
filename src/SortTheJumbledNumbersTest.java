import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortTheJumbledNumbersTest {
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSortJumbled(int[] mapping, int[] nums, int[] expected) {
        SortTheJumbledNumbers sorter = new SortTheJumbledNumbers();
        assertArrayEquals(expected, sorter.sortJumbled(mapping, nums));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38}, new int[]{338,38,991}),
                Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123}, new int[]{123,456,789}),
                Arguments.of(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{9,8,7,6,5,4,3,2,1,0})
        );
    }
}