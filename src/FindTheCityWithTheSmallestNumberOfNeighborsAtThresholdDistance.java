public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            m[v][w] = edge[2];
            m[w][v] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || m[i][k] == Integer.MAX_VALUE || m[k][j] == Integer.MAX_VALUE) continue;
                    int d = m[i][k] + m[k][j];
                    if (m[i][j] > d) {
                        m[i][j] = d;
                    }
                }
            }
        }

        int cityNumber = 0;
        int minimalCitiesCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int countCities = 0;
            for (int j = 0; j < n; j++) {
                if (m[i][j] <= distanceThreshold) {
                    countCities++;
                }
            }
            if (countCities <= minimalCitiesCount) {
                minimalCitiesCount = countCities;
                cityNumber = i;
            }
        }

        return cityNumber;
    }

}
