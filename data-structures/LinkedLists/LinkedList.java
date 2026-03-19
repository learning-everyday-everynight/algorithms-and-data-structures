public class LinkedList<T> {

  private Node head;
  private int size;  


  private class Node {
    T value;
    Node next;

    Node(T value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList() {
    this.head = null;
    this.size = 0;
  }

  public void insert(T value) {
    Node newNode = new Node(value);

    if (head == null) {
      head = newNode;
    } 
    
    else {
      Node currentNode = head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }
      currentNode.next = newNode;
    }
    size++; 
  }

  public void remove(T value) {
    if (head == null) {
      return;
    }

    
    if (value == null ? head.value == null : value.equals(head.value)) {
      head = head.next;
      size--;
      return;
    }

    Node currentNode = head;

    while (currentNode.next != null) {
      if (value == null
          ? currentNode.next.value == null
          : value.equals(currentNode.next.value)) {

        currentNode.next = currentNode.next.next;
        size--;
        return;
      }
      currentNode = currentNode.next;
    }
  }

  public boolean contains(T value) {
    Node currentNode = head;

    while (currentNode != null) {
      if (value == null
          ? currentNode.value == null
          : value.equals(currentNode.value)) {
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  public void clear() {
    head = null;
    size = 0;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int getSize() {
    return size; 
  }

  public void printList() {
    Node currentNode = head;
    while (currentNode != null) {
      System.out.print(currentNode.value + " -> ");
      currentNode = currentNode.next;
    }
    System.out.println("null");
  }


  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.insert(1);
    linkedList.insert(2);
    linkedList.insert(3);

    linkedList.printList(); // 1 -> 2 -> 3 -> null

    linkedList.remove(2);
    linkedList.printList(); // 1 -> 3 -> null

    System.out.println("Contains 3: " + linkedList.contains(3)); // true
    System.out.println("Size: " + linkedList.getSize()); // 2
  }
}