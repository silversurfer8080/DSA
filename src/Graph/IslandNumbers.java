package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Given a 2-dimensional matrix of values with 0 and 1, count the number of islands of 1.
// An island consists of all value 1 cells and is surrounded by either an edge or all 0 cells.
// A cell can only be adjacent to each other horizontally or vertically, not diagonally.
public class IslandNumbers {
    public static List<Coordinate> getNeighbors(Coordinate cell, int numRows, int numCols) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = cell.r + deltaRow[i];
            int neighborCol = cell.c + deltaCol[i];
            if (0 <= neighborRow && neighborRow < numRows
                    && 0 <= neighborCol && neighborCol < numCols) {
                if (neighborRow == cell.r || neighborCol == cell.c) {
                    neighbors.add(new Coordinate(neighborRow, neighborCol));
                }
            }
        }
        return neighbors;
    }

    public static int countIslands(List<List<Integer>> grid) {
        int numRows = grid.size();
        int numCols = grid.get(0).size();
        int count = 0;
        //bfs starting from each unvisited land cell
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid.get(r).get(c) == 0) continue;
                bfs(grid, new Coordinate(r, c), numRows, numCols);
                count++;
            }
        }
        return count;
    }

    private static void bfs(List<List<Integer>> grid, Coordinate coordinate, int numRows, int numCols) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(coordinate);
        grid.get(coordinate.r).set(coordinate.c, 0);
        while (!queue.isEmpty()) {
            Coordinate node = queue.pop();
            List<Coordinate> neighbors = getNeighbors(node, numRows, numCols);
            for (Coordinate neighbor : neighbors) {
                if (grid.get(neighbor.r).get(neighbor.c) == 0) continue;
                queue.add(neighbor);
                grid.get(neighbor.r).set(neighbor.c, 0);
            }
        }
    }
}
