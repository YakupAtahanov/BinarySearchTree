/**
 * Basic BinarySearchNode
 * @author Malvika Gandhe
 */
public class BinarySearchNode<E extends Comparable<E>> {
    public E element;

    public BinarySearchNode<E> left, right;

    public BinarySearchNode(E element) {
        this.element = element;
    }
}
