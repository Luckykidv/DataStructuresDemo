package com.datastructures.algorithms;

import java.util.*;

public class PathfindingAlgorithms {
    
    public static class DijkstraResult {
        public int[] distances;
        public int[] previous;
        
        public DijkstraResult(int[] distances, int[] previous) {
            this.distances = distances;
            this.previous = previous;
        }
    }

    public static DijkstraResult dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && 
                    dist[u] != Integer.MAX_VALUE && 
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        
        return new DijkstraResult(dist, prev);
    }
    
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}