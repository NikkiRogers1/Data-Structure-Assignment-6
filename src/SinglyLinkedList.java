import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList  implements Iterable<Song> {
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
    @Override
    public Iterator<Song> iterator() {
    return new Iterator<Song>() {

    private Node current = head;
    private Node lastReturned = null;
    private Node previous = null;
    private Node lastReturnedPrevious = null;

    @Override
    public boolean hasNext() {
            return current != null;
        }

    @Override
    public Song next() {
    if (current == null) {
        throw new NoSuchElementException();
    }

        lastReturnedPrevious = previous;
        lastReturned = current;
        previous = current;
        current = current.next;

        return lastReturned.song;
    }

    @Override
public void remove() {
    if (lastReturned == null) {
        throw new IllegalStateException();
    }

    if (lastReturnedPrevious == null) {
        head = current;
    } else {
        lastReturnedPrevious.next = current;
    }

    previous = lastReturnedPrevious;
    lastReturned = null;
}
    };
}
}