import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

/**NodeTest is a unit test file for the Node class*/
public class NodeTest {

    /** testNode tests the functionality of the Node constructor*/
    @Test
    @Order(0)
    @DisplayName("Test Node Constructor")
    public void testNode() {
        Node testNode = new Node(55);
        assertThat(testNode.getData()).isEqualTo(55);
    }
    /** testNodeSetters test the functionality of the Node setter methods*/
    @Test
    @Order(1)
    @DisplayName("Test setLeft and setRight")
    public void testNodeSetters(){
        Node parent = new Node(0);
        Node leftChild = new Node(1);
        Node rightChild = new Node(2);
        parent.setLeft(leftChild);
        parent.setRight(rightChild);
        assertThat(parent.getLeft()).isEqualTo(leftChild);
        assertThat(parent.getRight()).isEqualTo(rightChild);
        assertThat(rightChild.getRight()).isEqualTo(null);
    }

}
