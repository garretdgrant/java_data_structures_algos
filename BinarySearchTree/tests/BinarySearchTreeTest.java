import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static com.google.common.truth.Truth.assertThat;

/**NodeTest is a unit test file for the Node class*/
public class BinarySearchTreeTest {
    /** Small and Large sequences to test BST functionality*/
    private final int[] smallSequence = {1,5,4,6,7,2,3};
    private final int[] largeSequence = {
            150,125,175,166,163,123,108,116,117,184,165,137,141,111,138,122,109,194,143,183,178,173,139,126,170,
            190,140,188,120,195,113,104,193,181,185,198,103,182,136,115,191,144,145,155,153,151,112,129,199,135,
            146,157,176,159,196,121,105,131,154,107,110,158,187,134,132,179,133,102,172,106,177,171,156,168,161,
            149,124,189,167,174,147,148,197,160,130,164,152,142,162,118,186,169,127,114,192,180,101,119,128,100
    };

    /** Creating instance variable trees to use in all test functions
     * Small Tree Visualization
     *              1
     *              \
     *               5
     *              / \
     *             4   6
     *            /     \
     *           2       7
     *            \
     *             3
     * */
    BinarySearchTree smallTree = new BinarySearchTree(smallSequence);
    BinarySearchTree largeTree = new BinarySearchTree(largeSequence);


    /** testBST tests the functionality of the BST constructor*/
    @Test
    @Order(1)
    @DisplayName("Test BST Constructor")
    public void testBST() {
      BinarySearchTree testTree = new BinarySearchTree(smallSequence);
      // root should be first element of sequence
      assertThat(testTree.getRoot().getData()).isEqualTo(smallSequence[0]);

    }
    /** testNodeSetters test the functionality of the Node setter methods*/
    @Test
    @Order(2)
    @DisplayName("Test BST search")
    public void testBSTSearch(){
        // Small tree search test
        assertThat(smallTree.search(1)).isEqualTo(1); // root node should be first visited
        assertThat(smallTree.search(4)).isEqualTo(3); // Looking at visualization to get expected
        assertThat(smallTree.search(2)).isEqualTo(4);

        // Large tree search test
        int[] testLarge = {largeTree.search(42),
                largeTree.search(142),
                largeTree.search(102),
                largeTree.search(190)};
        int [] expected = {0, 6, 7, 5}; // expected derived from drawing of tree
        assertThat(testLarge).isEqualTo(expected);
    }

    @Test
    @Order(3)
    @DisplayName("Test printing functions")
    public void testPrints(){
        Node root = smallTree.getRoot();
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> expectedPost = new ArrayList<>(){{ // expected post-order traversal
            add(3); add(2); add(4); add(7); add(6); add(5); add(1);
        }};
        ArrayList<Integer> expectedPre = new ArrayList<>(){{ // expected pre-order traversal
            add(1); add(5); add(4); add(2); add(3); add(6); add(7);
        }};
        ArrayList<Integer> expectedIn = new ArrayList<>(){{ // expected in-order traversal
            add(1); add(2); add(3); add(4); add(5); add(6); add(7);
        }};

        // Testing post order print
        System.out.println("post-order traversal:");
        smallTree.printPostOrder(root, visited); // This will load the visited array in PostOrder (LeftChild, rightChild, Node)
        assertThat(visited).isEqualTo(expectedPost);
        visited.clear(); // Clearing visited array for new test
        System.out.println();
        // Testing pre order print
        System.out.println("pre-order traversal:");
        smallTree.printPreOrder(root, visited); // Loading visited in pre-order (Node, LeftChild, RightChild)
        assertThat(visited).isEqualTo(expectedPre);
        visited.clear();
        System.out.println();
        // Testing in order print
        System.out.println("in-order traversal:");
        smallTree.printInOrder(root, visited); // Loading visited in in-order (LeftChild, Node, RightChild)
        assertThat(visited).isEqualTo(expectedIn);
    }

}