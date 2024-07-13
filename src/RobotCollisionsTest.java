import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RobotCollisionsTest {
    private final RobotCollisions solver = new RobotCollisions();

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(
                new int[]{5,4,3,2,1},
                new int[]{2,17,9,15,10},
                "RRRRR",
                List.of(2,17,9,15,10)
            ),
            Arguments.of(
                new int[]{3,5,2,6},
                new int[]{10,10,15,12},
                "RLRL",
                List.of(14)
            ),
            Arguments.of(
                new int[]{1,2,5,6},
                new int[]{10,10,11,11},
                "RLRL",
                List.of()
            ),
            Arguments.of(
                new int[]{3,40},
                new int[]{49,11},
                "LL",
                List.of(49,11)
            ),
            Arguments.of(
                new int[]{4,47},
                new int[]{15,24},
                "RR",
                List.of(15,24)
            )

        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void robotCollisionsTest(int[] positions, int[] healths, String directions, List<Integer> expected) {
        List<Integer> actual = solver.survivedRobotsHealths(positions, healths, directions);

        assertEquals(expected, actual);
    }
}