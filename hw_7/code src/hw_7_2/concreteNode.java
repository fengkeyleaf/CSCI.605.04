/*
 * concreteNode.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_7_2;

/**
 * This program does what exactly hw 7.2 requires, and concreteNode implements Node
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class concreteNode<T extends Comparable<T>> implements Node<T>, Comparable<concreteNode<T>> {
    private T info; // information stored in this node

    /**
     * the constructor that create a node
     * no default constructor provided, so cannot create an empty node.
     *
     * @param    value      value stored in the node
     */

    public concreteNode(T value) {
        this.info = value;
    }

    /**
     * overridden method to compare two nodes
     *
     * @param    aConcreteNode     passed-in node needed to compare
     * @return                     Returns a negative integer, zero, or a positive integer as this node is
     *                             less than, equal to, or greater than the passed-in node.
     */

    @Override
    public int compareTo(concreteNode<T> aConcreteNode) {
        // first, compare with null
        if (this.info == null && aConcreteNode.getInfo() == null) {
            return 0;
        }
        else if (this.info == null && aConcreteNode.getInfo() != null) {
            return -1;
        }
        else if (this.info != null && aConcreteNode.getInfo() == null) {
            return 1;
        }

        // then, compare address
        if (this.info == aConcreteNode.getInfo()) {
            return 0;
        }

        // last, compare value
        return this.info.compareTo( aConcreteNode.getInfo() );
    }

    /**
     * get the value stored in this node
     */

    @Override
    public T getInfo() {
        return this.info;
    }

    /**
     * set the value in this node
     */

    @Override
    public void setInfo(T element) {
        this.info = element;
    }
}
