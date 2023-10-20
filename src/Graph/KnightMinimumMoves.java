package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Given a destination coordinate [x, y], determine the minimum number of moves from [0, 0] to [x, y].
public class KnightMinimumMoves {
    public static int minimumMoves(int x, int y) {
        return bfs(new Coordinate(0,0), x,y);
    }

    private static int bfs(Coordinate start, int x, int y) {
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(start);
        int steps = 0;

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate node = queue.pop();
                if (node.r == x && node.c == y) return steps;

                List<Coordinate> neighbors = getNeighbors(node);
                for (Coordinate neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private static List<Coordinate> getNeighbors(Coordinate node) {
        int[] deltaRow = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] deltaCol = {-2, -1, 1, 2, 2, 1, -1, -2};
        List<Coordinate> neighbors = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = node.r + deltaRow[i];
            int neighborCol = node.c + deltaCol[i];
                neighbors.add(new Coordinate(neighborRow, neighborCol));
        }
        return neighbors;
    }
}
