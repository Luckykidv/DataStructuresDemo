// package com.datastructures;

// import com.datastructures.structures.*;
// import com.datastructures.algorithms.*;
// import java.util.*;
package com.datastructures;

// DO NOT import java.util.* or java.util.LinkedList
// Only import what you need
import java.util.Scanner;
import java.util.Arrays;

// Use fully qualified names for your custom classes
// OR use specific imports
import com.datastructures.structures.LinkedList;
import com.datastructures.structures.BinarySearchTree;
import com.datastructures.structures.Graph;
import com.datastructures.algorithms.SortingAlgorithms;
import com.datastructures.algorithms.SearchAlgorithms;
import com.datastructures.algorithms.PathfindingAlgorithms;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    DATA STRUCTURES & ALGORITHMS DEMO     ║");
        System.out.println("╚══════════════════════════════════════════╝\n");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);
            
            switch (choice) {
                case 1:
                    demoLinkedList();
                    break;
                case 2:
                    demoBinarySearchTree();
                    break;
                case 3:
                    demoGraph();
                    break;
                case 4:
                    demoSortingAlgorithms();
                    break;
                case 5:
                    demoSearchAlgorithms();
                    break;
                case 6:
                    demoPathfinding();
                    break;
                case 7:
                    System.out.println("\nExiting... Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("          SELECT DEMONSTRATION");
        System.out.println("══════════════════════════════════════════");
        System.out.println("1. Linked List Demo");
        System.out.println("2. Binary Search Tree Demo");
        System.out.println("3. Graph Traversal (BFS/DFS)");
        System.out.println("4. Sorting Algorithms");
        System.out.println("5. Search Algorithms");
        System.out.println("6. Pathfinding (Dijkstra's Algorithm)");
        System.out.println("7. Exit");
        System.out.println("══════════════════════════════════════════");
        System.out.print("Enter your choice (1-7): ");
    }
    
    private static int getUserChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void demoLinkedList() {
        System.out.println("\n════════════ LINKED LIST DEMO ════════════");
        LinkedList<Integer> list = new LinkedList<Integer>();  // Fixed
        
        System.out.println("Inserting elements: 10, 20, 30, 40");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        
        System.out.print("Current list: ");
        list.display();
        
        System.out.println("\nInserting 5 at beginning:");
        list.insertAtBeginning(5);
        System.out.print("Current list: ");
        list.display();
        
        System.out.println("\nDeleting 20:");
        list.delete(20);
        System.out.print("Current list: ");
        list.display();
        
        System.out.println("\nFinal size: " + list.getSize());
    }
    
    private static void demoBinarySearchTree() {
        System.out.println("\n═════════ BINARY SEARCH TREE DEMO ═════════");
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();  // Fixed
        
        System.out.println("Inserting: 50, 30, 70, 20, 40, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        System.out.print("Inorder traversal: ");
        bst.inorder();
        
        System.out.println("\nSearching for 40: " + bst.search(40));
        System.out.println("Searching for 90: " + bst.search(90));
        
        visualizeBST();
    }
    
    private static void demoGraph() {
        System.out.println("\n═══════════ GRAPH TRAVERSAL DEMO ═══════════");
        Graph graph = new Graph(false);
        
        System.out.println("Creating graph with vertices 0-7");
        System.out.println("Edges: (0-1), (0-2), (1-3), (1-4), (2-5), (2-6), (3-7), (4-7)");
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        
        System.out.println("\nStarting BFS from vertex 0:");
        graph.bfs(0);
        
        System.out.println("\nStarting DFS from vertex 0:");
        graph.dfs(0);
    }
    
    private static void demoSortingAlgorithms() {
        System.out.println("\n══════════ SORTING ALGORITHMS DEMO ══════════");
        
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        
        System.out.println("Original array: " + Arrays.toString(arr1));
        
        SortingAlgorithms.bubbleSort(arr1);
        System.out.println("Bubble Sort:    " + Arrays.toString(arr1));
        
        SortingAlgorithms.quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Quick Sort:     " + Arrays.toString(arr2));
        
        SortingAlgorithms.mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("Merge Sort:     " + Arrays.toString(arr3));
    }
    
    private static void demoSearchAlgorithms() {
        System.out.println("\n══════════ SEARCH ALGORITHMS DEMO ══════════");
        
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        
        int target = 23;
        System.out.println("\nSearching for: " + target);
        
        int linearResult = SearchAlgorithms.linearSearch(sortedArray, target);
        System.out.println("Linear Search: Found at index " + linearResult);
        
        int binaryResult = SearchAlgorithms.binarySearch(sortedArray, target);
        System.out.println("Binary Search: Found at index " + binaryResult);
        
        System.out.println("\nTime Complexity Comparison:");
        System.out.println("• Linear Search: O(n)");
        System.out.println("• Binary Search: O(log n)");
    }
    
    private static void demoPathfinding() {
        System.out.println("\n════════ DIJKSTRA'S ALGORITHM DEMO ════════");
        
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        
        System.out.println("Graph representation (9 vertices):");
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " connects to: ");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    System.out.print(j + "(" + graph[i][j] + ") ");
                }
            }
            System.out.println();
        }
        
        int source = 0;
        System.out.println("\nFinding shortest paths from vertex " + source + ":");
        
        PathfindingAlgorithms.DijkstraResult result = 
            PathfindingAlgorithms.dijkstra(graph, source);
        
        System.out.println("Vertex\tDistance\tPath");
        for (int i = 0; i < result.distances.length; i++) {
            System.out.print(i + "\t" + result.distances[i] + "\t\t");
            printPath(result.previous, i);
            System.out.println();
        }
    }
    
    private static void printPath(int[] previous, int vertex) {
        if (vertex == -1) return;
        printPath(previous, previous[vertex]);
        System.out.print(vertex + " ");
    }
    
    private static void visualizeBST() {
        System.out.println("\nBST Structure Visualization:");
        System.out.println("       50");
        System.out.println("      /  \\");
        System.out.println("    30    70");
        System.out.println("   /  \\  /  \\");
        System.out.println("  20  40 60  80");
    }
}