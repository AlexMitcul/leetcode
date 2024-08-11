import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberofDaystoDisconnectIslandTest {

    final MinimumNumberofDaystoDisconnectIsland solver = new MinimumNumberofDaystoDisconnectIsland();

    @Test
    void test() {
        int[][] input = new int[][]{{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        int result = solver.minDays(input);
        int expected = 2;

        assertEquals(expected, result);
    }

}