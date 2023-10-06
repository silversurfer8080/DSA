package Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

// Given an (unweighted) connected graph, return the length of the shortest path between two nodes A and B,
// in terms of the number of edges.
// Assume there always exists a path between nodes A and B.
public class ShortestPath {
    public static int shortestPath(List<List<Integer>> graph, int a, int b){
        return bfs(graph, a, b);
    }

    private static int bfs(List<List<Integer>> graph, int root, int target) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.pop();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level++;
        }
        return level;
    }

}
