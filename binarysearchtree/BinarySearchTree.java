/*
    The BinarySearchTree Class implements a binary search tree using a node-pointer implementation.
    Assumes all entries in the tree will be unique.
    The main script is being used as a script to test each function.
    Author: Garret Grant
    Date: 02/13/2023
*/

public class BinarySearchTree{
    private Node root;
    public static void main(String[] args){
        int[] smallSequence = {1,5,4,6,7,2,3};
        int[] largeSequence = {
                150,125,175,166,163,123,108,116,117,184,165,137,141,111,138,122,109,194,143,183,178,173,139,126,170,
                190,140,188,120,195,113,104,193,181,185,198,103,182,136,115,191,144,145,155,153,151,112,129,199,135,
                146,157,176,159,196,121,105,131,154,107,110,158,187,134,132,179,133,102,172,106,177,171,156,168,161,
                149,124,189,167,174,147,148,197,160,130,164,152,142,162,118,186,169,127,114,192,180,101,119,128,100
        };

        BinarySearchTree smallTree = new BinarySearchTree(smallSequence);
        BinarySearchTree largeTree = new BinarySearchTree(largeSequence);
        Node root = smallTree.getRoot();
        // Testing traversals
        System.out.println("PreOrder traversal of Sequence A");
        smallTree.printPreorder(root); // Expected: 1 5 4 2 3 6 7
        System.out.println();
        System.out.println("PostOrder traversal of Sequence A");
        smallTree.printPostOrder(root); // Expected: 3 2 4 7 6 5 1
        System.out.println();
        System.out.println("InOrder traversal of Sequence A");
        smallTree.printInOrder(root); // Expected: 1 2 3 4 5 6 7
        System.out.println();

        // Testing search function
        System.out.printf("Searching smallTree for 9, 5, 3, 100: \n");
        System.out.printf("Results: 9: %d, 5: %d, 3: %d, 100: %d\n",
                smallTree.search(9),
                smallTree.search(5),
                smallTree.search(3),
                smallTree.search(100)
        );

        System.out.printf("Searching largeTree for 42, 142, 102, 190: \n");
        System.out.printf("Results: 42: %d, 142: %d, 102: %d, 190: %d\n",
                largeTree.search(42),
                largeTree.search(142),
                largeTree.search(102),
                largeTree.search(190)
        );

    }

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree(int[] data){
        buildTree(data);
    }
    public void buildTree(int[] data){
        for(int i = 0; i < data.length; i++){
            insert(data[i]);
        }
    }

    public void insert(int data){
//        System.out.println(data);
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

    // Preorder: Node, LeftChild, RightChild
    public void printPreorder(Node root){
        if (root == null) return;
        System.out.print(root.getData() + " ");
        printPreorder(root.getLeft());
        printPreorder(root.getRight());
    }

    // Postorder: LeftChild, RightChild, Node
    public void printPostOrder(Node root){
        if (root == null) return;
        printPostOrder(root.getLeft());
        printPostOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    // Inorder: LeftChild, Node, RightChild
    public void printInOrder(Node root){
        if(root == null) return;
        printInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        printInOrder(root.getRight());
    }

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