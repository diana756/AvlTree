package Avl_tree;

import java.util.*;

public class AVL_Tree {
    private Node root;
    private int size;
    private class Node {
        int value, height;
        Node left, right;

        Node(int value) {
            this.value = value;
            height = 1;
        }
    }
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }
    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }
    private void fixHeight(Node node) {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }
    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        fixHeight(node);
        fixHeight(leftChild);
        return leftChild;
    }
    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        fixHeight(node);
        fixHeight(rightChild);
        return rightChild;
    }
    private Node balance(Node node) {
        fixHeight(node);
        int balanceFactor = balanceFactor(node);
        if (balanceFactor == 2) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        } else if (balanceFactor == -2) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        return node;
    }
    public void insert(int value) {
        root = insert(root, value);
    }
    private Node insert(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }
        return balance(node);
    }
    public void remove(int value) {
        root = remove(root, value);
    }
    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = remove(node.left, value);
        } else if (value > node.value) {
            node.right = remove(node.right, value);
        } else {
            size--;
            Node leftChild = node.left;
            Node rightChild = node.right;
            if (rightChild == null) {
                return leftChild;
            }
            Node minNode = findMin(rightChild);
            minNode.right = removeMin(rightChild);
            minNode.left = leftChild;
            return balance(minNode);
        }
        return balance(node);
    }
    private Node findMin(Node node) {
        return node.left == null ? node : findMin(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value < node.value) {
            return contains(node.left, value);
        } else if (value > node.value) {
            return contains(node.right, value);
        } else {
            return true;
        }
    }
    public int getSize() {
        return size;
    }
}