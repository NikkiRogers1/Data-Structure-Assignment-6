public class SinglyLinkedList {
    Node head;
    
    private class Node{
    Song song;
    Node next;
    }

    public void addLast(Song song) {
        Node newNode = new Node();
        newNode.song= song;
       
       

        if (head == null) {
            head = newNode;
            return;
        }
      
    Node current = head;
        while(current.next != null){
            current = current.next;
            }
            current.next = newNode;
    }

    public void display() {
    Node current = head;

    while (current != null) {
        System.out.println(current.song);
        current = current.next;
    }
}
    }

