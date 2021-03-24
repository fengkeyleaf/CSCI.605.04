package hw_5_2;

public interface Element {

//    boolean add(Element element); // Returns true if element could be added
    boolean add(String str); // Returns true if element could be added
    boolean delete(Element element); // Returns true if element could be deleted
    boolean contains(Element element); // Returns true if a particular element is stored

}
