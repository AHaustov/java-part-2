public class BinaryTree {
    public static void main(String[] args) {
        Node one= new Node(null,null);
        Node two= new Node(null,one);
        Node three= new Node(null,two);
        Node four= new Node(null,null);
        Node five= new Node(four,three);
        Node six= new Node(null,five);
        Node seven= new Node(null,null);
        Node eight= new Node(seven,six);

        System.out.println(getHeight(seven));
    }
    static int getHeight(Node root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        if (root.left != null && root.right != null)
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        else
            return getHeight(root.left) + getHeight(root.right) + 1;
    }

    static int getVertexNumber(Node root) {
        if (root == null)
            return 0;

        return getVertexNumber(root.left) + getVertexNumber(root.right) + 1;
    }


    static class Node<Type> {
        Node<Type> left;
        Node<Type> right;

        public Node(Node<Type> left, Node<Type> right) {
            this.left = left;
            this.right = right;
        }
    }
}
