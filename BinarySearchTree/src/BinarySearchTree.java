/**
 * @author Garret Grant
 * Date: 02/15/2023
 * Binary Search Tree with node-pointer implementation.
 * The constructor accepts a sequence of unique number and creates a BST.
 * */

import java.util.ArrayList;
public class BinarySearchTree{
    private Node root;

    /** Constructor calls build tree to correctly build the BST*/
    public BinarySearchTree(int[] data){
        buildTree(data);
    }

    /** buildTree loops through each element of sequence and calls insert to
     * insert the element into the BST at the right location*/
    public void buildTree(int[] data){
        for(int i = 0; i < data.length; i++){
            insert(data[i]);
        }
    }

    /** Insert takes a single integer, creates a new node and inserts the new node
     * in the correct position of the BST*/
    public void insert(int data){
        Node newNode = new Node(data);
        Node current = this.root;
        Node previous;
        if (current == null){ // If this is the first node it is the root of the BST
            this.root = newNode;
            return;
        }
        // Traveling the tree until the correct insertion point is found
        while (current != null){ //
            previous = current;
            if (data > current.getData()){ // Need to travel right
                current = current.getRight();
                if (current == null){
                    previous.setRight(newNode);
                }
            } else if (data < current.getData()) { // need to travel left
                current = current.getLeft();
                if (current == null){
                    previous.setLeft(newNode);
                }
            } else {
                current = null;
            }
        }
    }

    /** Getter for the root of the bst*/
    public Node getRoot() {
        return root;
    }
    /** print functions print the values of the BST elements in the
     * specified order, visited array is for testing purposes,
     * see BinarySearchTreeTest.Java lines 67-*/
    // Preorder: Node, LeftChild, RightChild
    public void printPreOrder(Node root, ArrayList<Integer> visited){
        if (root == null) return;
        System.out.print(root.getData() + " ");
        visited.add(root.getData());
        printPreOrder(root.getLeft(), visited);
        printPreOrder(root.getRight(), visited);
    }

    // Postorder: LeftChild, RightChild, Node
    public void printPostOrder(Node root, ArrayList<Integer> visited){
        if (root == null) return;
        printPostOrder(root.getLeft(), visited);
        printPostOrder(root.getRight(), visited);
        visited.add(root.getData());
        System.out.print(root.getData() + " ");
    }

    // Inorder: LeftChild, Node, RightChild
    public void printInOrder(Node root, ArrayList<Integer> visited){
        if(root == null) return;
        printInOrder(root.getLeft(), visited);
        System.out.print(root.getData() + " ");
        visited.add(root.getData());
        printInOrder(root.getRight(), visited);
    }

    /** Search function searches the BST in O(log n) time complexity
     * returns the number of nodes visited to find the element, or
     * 0 if the element is not found*/
    public int search(int data){
        int visited = 1;
        Node current = this.root;
        while(current != null){
            if (data == current.getData()) return visited;
            visited++;
            if (data > current.getData()){ // travel right
                current = current.getRight();
            } else { // travel left
                current = current.getLeft();
            }
        }
        return 0;
    }
}
