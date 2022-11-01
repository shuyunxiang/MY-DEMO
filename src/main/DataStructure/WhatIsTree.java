package DataStructure;

public class WhatIsTree {

    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node0.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        printTree(node0);

    }

    static void printTree(Node node) {

        System.out.println("前递归打印-" + node.value);

        if (node.nextNode != null) {
            printTree(node.nextNode);
        }

        System.out.println("后面递归打印-" + node.value);
    }
}

class Node {
    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
    }
}