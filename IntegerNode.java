// IntegerNode is a self-referential data type.

// Each node has a data field: item (an integer)
// and a link field (next) that points to another node (of the same type).

public class IntegerNode {

  // Attributes
  private int item;
  private IntegerNode next;

  // Constructor: create a new node with the given data (newItem).
  public IntegerNode(int newItem) {
    item = newItem;
    next = null;
  } // end constructor

  // Constructor: create a new node 
  // with the given data (newItem) and link (nextNode).
  public IntegerNode(int newItem, IntegerNode nextNode) {
    item = newItem;
    next = nextNode;
  } // end constructor

  // Mutator method for item.
  public void setItem(int newItem) {
    item = newItem;
  } // end setItem

  // Accessor method for item.
  public int getItem() {
    return item;
  } // end getItem

  // Mutator method for next.
  public void setNext(IntegerNode nextNode) {
    next = nextNode;
  } // end setNext

  // Accessor method for next.
  public IntegerNode getNext() {
    return next;
  } // end getNext

} // end class IntegerNode