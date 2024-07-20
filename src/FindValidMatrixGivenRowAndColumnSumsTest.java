import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindValidMatrixGivenRowAndColumnSumsTest {
    private final FindValidMatrixGivenRowAndColumnSums solver = new FindValidMatrixGivenRowAndColumnSums();

    private static Stream<Arguments> provide_data() {
        return Stream.of(
                Arguments.of(
                        new int[]{3,8},
                        new int[]{4,7},
                        new int[][]{
                                new int[]{3,0},
                                new int[]{1,7}
                        }
                ),
                Arguments.of(
                        new int[]{5,7,10},
                        new int[]{8,6,8},
                        new int[][]{
                                new int[]{5,0,0},
                                new int[]{3,4,0},
                                new int[]{0,2,8}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provide_data")
    void restoreMatrixTest(int[] rowSum, int[] colSum, int[][] expected) {
        int[][] result = solver.restoreMatrix(rowSum, colSum);

        assertArrayEquals(expected, result);
    }
}