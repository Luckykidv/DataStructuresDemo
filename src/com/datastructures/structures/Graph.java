package com.datastructures.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.adjacencyList = new HashMap<Integer, List<Integer>>();
        this.isDirected = isDirected;
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<Integer>());
    }

    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited.add(startVertex);
        queue.add(startVertex);
        
        System.out.print("BFS Traversal: ");
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<Integer>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<Integer>();
        System.out.print("DFS Traversal: ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        
        for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<Integer>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}