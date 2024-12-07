/**
 * Thank you for your attention to our work. Feel free to play around with our BinarySearchTree
 * Inspired by class CPT_S-233 and LeetCode problems
 * @author Yakup Atahanov
 */

public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();

        bst1.addElement(50);
        bst1.addElement(100);
        bst1.addElement(0);
        bst1.addElement(25);
        bst1.addElement(76);

//        System.out.println(bst1.removeElement(75));

        bst1.traversal(1);

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();

        bst2.addElement(50);
        bst2.addElement(100);
        bst2.addElement(0);
        bst2.addElement(25);
        bst2.addElement(76);

        bst2.traversal(1);

        System.out.println(bst1.compareBST(bst2));

        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();

        bst3.addElement(50);
        bst3.addElement(100);
        bst3.addElement(200);
        bst3.addElement(25);
//        bst3.addElement(36);

        System.out.println(bst3.findPredecessor().element);

        Object[] array = bst1.arrayAtDepth(1);
        for (Object i: array) {
            System.out.print(i + " ");
        }
    }
}