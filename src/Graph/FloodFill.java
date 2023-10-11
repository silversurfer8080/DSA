package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FloodFill {
    // In computer graphics, an uncompressed raster image is presented as a matrix of numbers.
    // Each entry of the matrix represents the color of a pixel. A flood fill algorithm takes a coordinate r, c
    // and a replacement color, and replaces all pixels connected to r, c that have the same color
    // (i.e., the pixels connected to the given coordinate with same color and all the other pixels connected to the
    // those pixels of the same color) with the replacement color. (e.g. MS-Paint's paint bucket tool).
    //
    // Input
    // r: row
    // c: column
    // replacement: replacement color
    // image: an 2D array of integers representing the image
    // Output
    //  an 2D array of integers representing the replaced image

    public static List<List<Integer>> floodFill(List<List<Integer>> image, int r, int c, int replacement){
        int numRows = image.size();
        int numCols = image.get(0).size();

        bfs(image, new Coordinate(r, c), replacement, numRows, numCols);
        return image;
    }

    private static void bfs(List<List<Integer>> image, Coordinate coordinate, int replacementColor, int numRows, int numCols) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(coordinate);
        boolean visited[][] = new boolean[numRows][numCols];
        int rootColor = image.get(coordinate.r).get(coordinate.c);
        image.get(coordinate.r).set(coordinate.c, replacementColor);
        visited[coordinate.r][coordinate.c] = true;
        while (!queue.isEmpty()) {
            Coordinate node = queue.pop();
            List<Coordinate> neighbors = getNeighbors(image, node, rootColor, numRows, numCols);
        }
    }

    private static List<Coordinate> getNeighbors(List<List<Integer>> image, Coordinate node, int rootColor, int numRows, int numCols) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = node.r + deltaRow[i];
            int neighborCol = node.c + deltaCol[i];
            if (0 <= neighborRow && neighborRow < numRows && 0 <= neighborCol && neighborCol < numCols) {
                if (image.get(neighborRow).get(neighborCol) == rootColor) {
                    neighbors.add(new Coordinate(neighborRow, neighborCol));
                }
            }
        }
        return neighbors;

    }

}
