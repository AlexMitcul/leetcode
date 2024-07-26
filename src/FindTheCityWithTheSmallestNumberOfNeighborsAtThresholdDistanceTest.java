import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistanceTest {

    @Test
    void findTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance() {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distance = 4;

        var solver = new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance();
        int result = solver.findTheCity(n, edges, distance);
        assertEquals(3, result);
    }
}