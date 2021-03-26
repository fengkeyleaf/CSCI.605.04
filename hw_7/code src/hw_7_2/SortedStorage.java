package hw_7_2;

/*
 * SortedStorage.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $0.0$
 */

// Four key points to understand the algorithm:
// 1) encapsulate an element or object needed to store in a binary search tree, such as String, Integer and ect.,
// into a class named concreteNode. And use the class SortedStorage to implement the structure of a binary search tree.
// 2) null is considered as the least element compared to any other concreted element,
// which means that null is always store in right sub-tree when its parent node has anything other than null.
// 3) the same nodes (which have the same info)
// are added to the right sub-tree of its parent node that has the same info.
// 4) the first instance of SortedStorage functions as an anchor in order to store elements using it.
// Generally, each element will be being stored in its right-subtree because elements passed in is either greater or equal to it,
// which stores a null in it, as we can see, it is viewed as the least element compared to all other elements
// So we take advantage of a boolean value to indicate whether a tree node is anchor node or not

/**
 * This program does what exactly hw 7.2 requires, and SortedStorage implements StorageInterface
 * This class is used as the structure of BST
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class SortedStorage<T extends Comparable<T>> implements StorageInterface<T>{
    private concreteNode<T> data;       // date field using class concreteNode to store elements in BST
    private SortedStorage<T> left;      // pointer pointing to the left-child node
    private SortedStorage<T> right;     // pointer pointing to the right-child node
    private boolean ifAnchor;           // indicate a tree node is anchor node if it is true

	//可以把Node的类放在这里面，作为inner class
	
    /**
     * the default constructor that creates an BST with an anchor node
     */

    SortedStorage() {
        this(null);
        this.ifAnchor = true;
    }

    /**
     * a constructor that creates a BST with the node stored element
     *
     * @param    element      element added to BST
     */

    SortedStorage(T element) {
        this.data = new concreteNode<T>(element);
        this.left = this.right = null;
    }

    /**
     * Overloaded add method, which returns true if the element was successfully added, false otherwise
     * note that the same nodes (which have the same info) are added to the right sub-tree
	 * 可以在每个node里面加一个成员属性counter，重复的元素没有必要生成新的node，直接counter++即可；
	 * 但是这个方法有一个小缺陷，就是counter的计数是受限于存储数据类型；
     *
     * @param    aNewConcreteNoe      node added to BST
     * @return                        as what described above
     */

    private boolean add(SortedStorage<T> aNewConcreteNoe) {
        // this node is less than the specified node passed in
        if ( this.data.compareTo( aNewConcreteNoe.data ) > 0) {
            if (this.left == null) {
                this.left = aNewConcreteNoe;
                return true;
            }
            else {
                return this.left.add( aNewConcreteNoe );
            }
        }

        // this node is greater than or equal to the specified node passed in
        if (this.right == null) {
            this.right = aNewConcreteNoe;
            return true;
        }

        return this.right.add( aNewConcreteNoe );
    }

    /**
     * true if the element was successfully added, false otherwise
     * note that the same nodes (which have the same info) are added to the right sub-tree
     *
     * @param    element      element added to BST
     * @return                as what described above
     */

    @Override
    public boolean add(T element) {
        SortedStorage<T> aNewConcreteNoe = new SortedStorage<T>(element);
        return this.add(aNewConcreteNoe);
    }

    /**
     * Overloaded find method to find an element in the tree
     *
     * @param    aNewConcreteNoe      node needed to find in the tree
     * @return                        true, found the element in the tree; false, not found
     */

    private SortedStorage<T> find(SortedStorage<T> aNewConcreteNoe) {
        // found the element in the tree
        if ( aNewConcreteNoe.data.compareTo(this.data) == 0 ) {
            return this;
        }

        // the element might be in the left sub-tree
        if ( this.left != null && aNewConcreteNoe.data.compareTo(this.data) < 0) {
            return this.left.find(aNewConcreteNoe);
        }

        // the element might be in the right sub-tree
        if ( this.right != null && aNewConcreteNoe.data.compareTo(this.data) > 0) {
            return this.right.find(aNewConcreteNoe);
        }

        // not found the element
        return null;
    }

    /**
     * find an element in the tree
     *
     * @param    element      element needed to find in the tree
     * @return                true, found the element in the tree; false, not found
     */

    @Override
    public boolean find(T element) {
        // no nodes in the tree
        if ( this.right == null ) {
            return false;
        }

        SortedStorage<T> aNewConcreteNoe = new SortedStorage<T>(element);
        return this.right.find(aNewConcreteNoe) != null;
    }

    /**
     * true, if the storage include a null element, false otherwise
     *
     * @return                as what described above
     */

    @Override
    public boolean includesNull() {
        return this.find( new SortedStorage<T>(null) ) != null;
    }

    /**
     * find the minimum node of a certain given node, continue searching in the left-sub tree
     *
     * @param    aNode        node needed to find in the tree
     * @return                the minimum node of a certain given node
     */

    private SortedStorage<T> minimumElement(SortedStorage<T> aNode) {
        if (aNode.left == null)
            return aNode;
        else {
            return minimumElement(aNode.left);
        }
    }

    /**
     * delete a node in the tree
	 * 如果是counter方式来存储node，删除则先查找node，如果找到counter--，如果小于等于0，则删除改node，返回true；反之没有找到，则返回false
     *
     * @param    root               root node where we find the deleted node
     * @param    deletedNode        node needed to delete
     */

    private SortedStorage<T> deleteThisElementInTree(SortedStorage<T> root, SortedStorage<T> deletedNode) {
        // cannot find the deleted element
        if ( root == null ) {
            return null;
        }

        if ( root.data.compareTo(deletedNode.data) > 0 ) {    // the deleted element might be in the left-subtree
            root.left = deleteThisElementInTree( root.left, deletedNode );
        }
        else if ( root.data.compareTo(deletedNode.data) < 0 ) {     // the deleted element might be in the right-subtree
            root.right = deleteThisElementInTree( root.right, deletedNode );
        }
        else { // find the deleted element, then delete it
            if ( (root.left != null) && (root.right != null) ) {
                SortedStorage<T> tmp = root;
                SortedStorage<T> minimumNodeOnRight = minimumElement( tmp.right );
                root.data = minimumNodeOnRight.data;
                root.right = deleteThisElementInTree( root.right, new SortedStorage<T>(minimumNodeOnRight.data.getInfo()) );
            }
            else if (root.left != null) {
                root = root.left;
            }
            else if (root.right != null) {
                root = root.right;
            }
            else {
                root = null;
            }
        }

        return root;
    }

    /**
     * true if it was successfully deleted, false otherwise
     *
     * @param    element               element needed to deleted in the tree
     * @return                         as what described above
     */

    @Override
    public boolean delete(T element) {
        // no nodes in the tree
        if ( this.right == null ) {
            return false;
        }

        // find if the element is in the tree or not
        SortedStorage<T> deletedNoe = new SortedStorage<T>(element);
        SortedStorage<T> ifFind = this.right.find( deletedNoe );

        // yes, then delete it
        if (ifFind != null) {
            this.right = this.deleteThisElementInTree(this.right, deletedNoe);
            return true;
        }

        // no, failed to delete
        return false;
    }

    /**
     * in-order traversal to iterate all nodes in the tree and count how many nulls in it
     *
     * @param    text               textual representation of nodes
     * @return                      the number of nulls in the BST
     */

    private int inOrderTraversal(StringBuilder text) {
        int numberOfNull = 0; // store the total number of nulls in this node and its child nodes

        if (this.left != null) {
            numberOfNull += this.left.inOrderTraversal(text);
        }

        T element =  this.data.getInfo();
        text.append( !this.ifAnchor ? ( element == null ? "null, " : element + ", ") : "");

        if (this.right != null) {
            numberOfNull += this.right.inOrderTraversal(text);
        }

        return ( !this.ifAnchor && element == null ) ? numberOfNull + 1 : numberOfNull;
    }

    /**
     * get a textual representation of the BST
     */

    public String toString() {
        StringBuilder text = new StringBuilder();
        StringBuilder sortedValues = new StringBuilder();
        int numberOfNull = inOrderTraversal(sortedValues);

        if (sortedValues.length() > 2 ) sortedValues.delete(sortedValues.length() - 2, sortedValues.length());
        text.append("includes so many null values = ").append(numberOfNull).append("\n").
                append("Values stored(in Order Traversal): [").append(sortedValues).append("]");
        return text.toString();
    }
}
