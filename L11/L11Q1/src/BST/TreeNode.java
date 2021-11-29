package BST;

public class TreeNode<E extends Comparable<E>> {

    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode() {
    }

    public TreeNode(E o) {
        element = o;
    }
}
