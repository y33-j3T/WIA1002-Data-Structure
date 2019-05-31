package BST;

import java.util.Arrays;

public class TestBST {

    public static void main(String[] args) {
        Integer[] arr = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        String data = Arrays.toString(arr).replace("[", "").replace("]", "");
        System.out.println("Input Data: " + data);

        BST<Integer> tree = new BST(arr);

        System.out.print("Inorder (sorted): ");
        tree.inorder(tree.getRoot());
        System.out.println();
        
        System.out.print("Postorder (sorted): ");
        tree.postorder(tree.getRoot());
        System.out.println();
        
        System.out.print("Preorder (sorted): ");
        tree.preorder(tree.getRoot());
        System.out.println();
        
        System.out.println("Height of BST: " + tree.height());
        
        System.out.println("Root of BST: " + tree.getRootElement());
        
        System.out.println("Check whether 10 is in the tree? " + tree.search(10));
        
        System.out.println("Delete 53");
        tree.delete(53);
        
        System.out.print("Updated Inorder data (sorted): ");
        tree.inorder(tree.getRoot());
        System.out.println();
        
        System.out.println("Min Value: " + tree.minValue());
        
        System.out.println("Max Value: " + tree.maxValue());
        
        System.out.println("A path from the root to 6 is: " + tree.pathAsStr(6));
    }
}
