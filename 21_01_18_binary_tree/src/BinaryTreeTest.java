import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree.Node fifteen = new BinaryTree.Node(null, null);
    BinaryTree.Node fourteen = new BinaryTree.Node(null, fifteen);
    BinaryTree.Node thirteen = new BinaryTree.Node(null, null);
    BinaryTree.Node twelve = new BinaryTree.Node(thirteen, fourteen);
    BinaryTree.Node eleven = new BinaryTree.Node(null, null);
    BinaryTree.Node ten = new BinaryTree.Node(eleven, twelve);
    BinaryTree.Node nine = new BinaryTree.Node(null, null);
    BinaryTree.Node eight = new BinaryTree.Node(null, ten);
    BinaryTree.Node seven = new BinaryTree.Node(eight, nine);
    BinaryTree.Node six = new BinaryTree.Node(null, null);
    BinaryTree.Node five = new BinaryTree.Node(null, seven);
    BinaryTree.Node four = new BinaryTree.Node(null, null);
    BinaryTree.Node three = new BinaryTree.Node(six, null);
    BinaryTree.Node two = new BinaryTree.Node(four, five);
    BinaryTree.Node one = new BinaryTree.Node(two, three);

    @Test
    public void test_getHeight_one_8() {
        assertEquals(8, BinaryTree.getHeight(one));
    }

    @Test
    public void test_getHeight_four_2() {
        assertEquals(0, BinaryTree.getHeight(four));
    }

    @Test
    public void test_getHeight_six_0() {
        assertEquals(0, BinaryTree.getHeight(six));
    }

    @Test
    public void test_getHeight_seven_8() {
        assertEquals(5, BinaryTree.getHeight(seven));
    }

    @Test
    public void test_getHeight_ten_8() {
        assertEquals(3, BinaryTree.getHeight(ten));
    }

    @Test
    public void test_getNumber_one_15() {
        assertEquals(15, BinaryTree.getVertexNumber(one));
    }


    @Test
    public void test_getNumber_two_12() {
        assertEquals(12, BinaryTree.getVertexNumber(two));
    }

    @Test
    public void test_getNumber_nine_1() {
        assertEquals(1, BinaryTree.getVertexNumber(nine));
    }

    @Test
    public void test_getNumber_five_10() {
        assertEquals(10, BinaryTree.getVertexNumber(five));
    }

    @Test
    public void test_getNumber_four_1() {
        assertEquals(1, BinaryTree.getVertexNumber(four));
    }

    @Test
    public void test_getNumber_three_2() {
        assertEquals(2, BinaryTree.getVertexNumber(three));
    }

    @Test
    public void test_getNumber_ten_15() {
        assertEquals(6, BinaryTree.getVertexNumber(ten));
    }

    @Test
    public void test_getNumber_seven_9() {
        assertEquals(9, BinaryTree.getVertexNumber(seven));
    }

    @Test
    public void test_getNumber_fifteen_1() {
        assertEquals(1, BinaryTree.getVertexNumber(fifteen));
    }
}