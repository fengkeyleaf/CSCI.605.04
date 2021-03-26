package hw_7_2;

/*
 * Node.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

/**
 * This program does what exactly hw 7.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public interface Node<T extends Comparable<T>> {
    T getInfo();                       // get the value stored in this node
    void setInfo(T element);           // set the value in this node
}
