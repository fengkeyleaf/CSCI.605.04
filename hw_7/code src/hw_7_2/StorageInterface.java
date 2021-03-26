/*
 * StorageInterface.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_7_2;

/**
 * This program does what exactly hw 7.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public interface StorageInterface<E> {
        boolean add(E element);      // true if it was successfully added, false otherwise
        boolean find(E element);     // true if x could be found, false otherwise
        boolean includesNull();      // true, if the storage include a null element, false otherwise
        boolean delete(E element);   // true if it was successfully deleted, false otherwise
}
