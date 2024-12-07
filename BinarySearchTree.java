/**
 * Our version of BinarySearchTree with some additional methods
 * @author Yakup Atahanov and Malvika Gandhe
 */
public class BinarySearchTree<E extends Comparable<E>> {

    public int size;

    protected int index;
    public BinarySearchNode<E> root;
    protected BinarySearchNode<E> dummy;

    /**
     * Constructor for the class BinarySearchTree
     */
    public BinarySearchTree() {
        size = 0;
    }

    /**
     * Adds an element to the BST, and returns true, if there are not duplicates. Otherwise, returns false
     * @param element
     * @return
     */
    public boolean addElement(E element) {
        dummy = null;
        root = addElementHelper(root, element);
        size++;
        return dummy == null;
    }

    protected BinarySearchNode<E> addElementHelper(BinarySearchNode<E> root, E element) {
        if (root == null) {
            return new BinarySearchNode<>(element);
        }

        int compareResult = element.compareTo(root.element);

        if (compareResult < 0) {
            root.left = addElementHelper(root.left, element);
        } else if (compareResult > 0) {
            root.right = addElementHelper(root.right, element);
        }
        if (compareResult == 0) {
            dummy = root;
        }

        return root;
    }

    /**
     * Removes an element from the BST, and returns it
     * @param element
     * @return
     */
    public BinarySearchNode<E> removeElement(E element) {
        dummy = null;
        root = removeElementHelper(root, element);
        size--;
        return dummy;
    }

    protected BinarySearchNode<E> removeElementHelper(BinarySearchNode<E> root, E element) {
        if (root == null) {
            return null;
        }
        int compareResult = element.compareTo(root.element);

        if (compareResult < 0) {
            root.left = removeElementHelper(root.left, element);
        } else if (compareResult > 0) {
            root.right = removeElementHelper(root.right, element);
        }
        if (compareResult == 0) {
            dummy = root;
            return null;
        }

        return root;
    }

    /**
     * Finds out whether BST contains a specified element. Returns true, if it does. Otherwise, returns false
     * @param element
     * @return
     */
    public boolean containsElement(E element) {
        return findElementHelper(root, element) != null;
    }

    /**
     * Finds an node from an element. Returns BinarySearchNode<E>
     * @param element
     * @return
     */
    public BinarySearchNode<E> findElement(E element) {
        return findElementHelper(root, element);
    }

    protected BinarySearchNode<E> findElementHelper(BinarySearchNode<E> root, E element) {
        if (root == null) {
            return null;
        }
        int compareResult = element.compareTo(root.element);

        if (compareResult < 0) {
            return findElementHelper(root.left, element);
        } else if (compareResult > 0) {
            return findElementHelper(root.right, element);
        }

        return root;
    }

    /**
     * Traverses the BST. Takes type field as the parameter:
     * 
     * Type = 1 => Pre-order Traversal
     * 
     * Type = 2 => In-order Traversal
     * 
     * Type = 3 => Post-order Traversal
     * @param type
     */
    public void traversal(int type) {
        switch (type) {
            case 1 -> preOrder(root);
            case 2 -> inOrder(root);
            case 3 -> postOrder(root);
            default -> throw new RuntimeException("Type " + type + " is not acceptable. Please select either 1, 2 or 3");
        }
    }

    /**
     * Pre-order Traversal
     */
    protected void preOrder(BinarySearchNode<E> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    /**
     * In-order Traversal
     */
    protected void inOrder(BinarySearchNode<E> root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.println(root.element);
        preOrder(root.right);
    }

    /**
     * Post-order Traversal
     */
    protected void postOrder(BinarySearchNode<E> root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.element);
    }

    /**
     * Compares first (this) tree to another (other) tree. Returns true, if both trees are similar.
     * Similar meaning the structure and the corresponding values are equal
     * @param tree
     * @return
     */
    public boolean compareBST(BinarySearchTree<E> tree) {
        return compareBSTHelper(root, tree.root);
    }

    protected boolean compareBSTHelper(BinarySearchNode<E> root1, BinarySearchNode<E> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.element == root2.element && compareBSTHelper(root1.left, root2.left) && compareBSTHelper(root1.right, root2.right);
    }

    /**
     * Returns Predecessor of the tree
     * @return
     */
    public BinarySearchNode<E> findPredecessor() {
        if (root == null || root.left == null) {
            return root;
        }
        return findPredecessorHelper(root.left);
    }

    protected BinarySearchNode<E> findPredecessorHelper(BinarySearchNode<E> root) {
        if (root.right == null) {
            return root;
        }
        return findPredecessorHelper(root.right);
    }

    /**
     * Returns Successor of the tree
     * @return
     */
    public BinarySearchNode<E> findSuccessor() {
        if (root == null || root.right == null) {
            return root;
        }
        return findSuccessorHelper(root.right);
    }

    protected BinarySearchNode<E> findSuccessorHelper(BinarySearchNode<E> root) {
        if (root.left == null) {
            return root;
        }
        return findSuccessorHelper(root.left);
    }

    /**
     * Returns true, if the tree is symmetric. Symmetricy corresponds to the left and right chilren' values are equal to each other.
     * If we go down one more level, we would have the following:
     * root.left.left, root.left.right, root.right.left, root.right.right
     * At this depth, the tree would be symmetric if root.left.left == root.right.right and root.left.right == root.right.left
     * @return
     */
    public boolean isSymmetric() {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    protected boolean isSymmetricHelper(BinarySearchNode<E> left, BinarySearchNode<E> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null ) {
            return false;
        }
        return left.element == right.element && isSymmetricHelper(root.left, root.right) && isSymmetricHelper(root.right, root.left);
    }

    /**
     * Returns an array of elements at the specified depth.
     * For example, at depth 2, the array would consist of [root.left.left.element, root.left.right.element, root.right.left.element, root.right.right.element]
     * @param depth
     * @return
     */
    public Object[] arrayAtDepth(int depth) {
        index = 0;
        Object[] result = new Object[(int) Math.pow(2, depth)];
        return arrayAtDepthHelper(root, result, 0, depth);
    }

    protected Object[] arrayAtDepthHelper(BinarySearchNode<E> root, Object[] array, int currentDepth, int limitDepth) {
        if (root == null) {
            return array;
        }
        if (currentDepth == limitDepth) {
            array[index] = root.element;
            index++;
            return array;
        }
        Object[] arrayLeft = arrayAtDepthHelper(root.left, array, 1 + currentDepth, limitDepth);
        return arrayAtDepthHelper(root.right, arrayLeft, 1 + currentDepth, limitDepth);
    }
}