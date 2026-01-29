package com.datastructures.structures;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left, right;
        
        Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }
        
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node<T> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> root, T data) {
        if (root == null) return false;
        
        if (data.equals(root.data)) return true;
        
        return data.compareTo(root.data) < 0 ? 
               searchRec(root.left, data) : 
               searchRec(root.right, data);
    }
}