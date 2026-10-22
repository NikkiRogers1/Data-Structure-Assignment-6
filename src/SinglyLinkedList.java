import java.util.Iterator;
import java.util.NoSuchElementException;

//A linked list that stores Song objects.
public class SinglyLinkedList  implements Iterable<Song> {
   //Points to the first node in the list.
    Node head;
    //Each node stores a song and a reference to the next node.
    private class Node{
    Song song;
    Node next;
    }
    //Adds a song to the end of the list;
    public void addLast(Song song) {
        Node newNode = new Node();
        newNode.song= song;
       
       
        // if the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
            return;
        }
      //Traverse the list to find the last node.
    Node current = head;
        while(current.next != null){
            current = current.next;
            }
            //Connects the last node to the new node.
            current.next = newNode;
    }
    // Prints each song by traversing the list.
    public void display() {
    Node current = head;

    while (current != null) {
        System.out.println(current.song);
        current = current.next;
        }
    }

    //Allows songs to be accessed through an iterator.
    @Override
    public Iterator<Song> iterator() {
    return new Iterator<Song>() {

        //Tracks the next node to return.
    private Node current = head;
        //Tracks the node most recently returned.
    private Node lastReturned = null;
        //Tracks the node before current.
    private Node previous = null;
        //Helps remove the last returned node.
    private Node lastReturnedPrevious = null;


    //Checks whether another node exists.
    @Override
    public boolean hasNext() {
            return current != null;
        }

        //Returns the next song and advances the iterator.
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

    //Removes the song most recently returned by next().
    @Override
public void remove() {
    if (lastReturned == null) {
        throw new IllegalStateException();
    }

    //Update the head if removing the first node.
    if (lastReturnedPrevious == null) {
        head = current;
    } else {
        //Skip the removed node to reconnect the list.
        lastReturnedPrevious.next = current;
    }

    //Update iterator state after removal.
    previous = lastReturnedPrevious;
    lastReturned = null;
}
    };
 }
 //Return the song at the specified index.
 public Song get(int index) {
    //Negative indexes are invalid.
    if (index < 0) {
        throw new IndexOutOfBoundsException();
    }

    Node current = head;

    //Follow the links until reaching the requested index.
    for (int i = 0; i < index; i++) {
       
    
    if (current == null) {
        //Throws an exception if the current node does not exist.  
            throw new IndexOutOfBoundsException();
        }
        current = current.next;
    }

    //Throw an exception if the index exceeds the list size.
    if (current == null) {
        throw new IndexOutOfBoundsException();
    }

    return current.song;
}

//Insert a song at the specified index.
public void add(int index, Song song){
    int count = 0;
    Node current = head;
    
    //Counts the nodes to validate the insertion index.
    while (current != null){
        count++;
        current = current.next;
    }

    //Rejects indexes outside the valid insertion range.
    if (index < 0) {
        throw new IndexOutOfBoundsException();
    }
    if (index > count) {
        throw new IndexOutOfBoundsException();
    }
//Creates a node to store the new song.
    Node newNode = new Node();
    newNode.song = song;

    //Insert at the beginning of the list.
    if (index == 0){
        newNode.next=head;
        head = newNode;
        return;
    }
    Node previous = head;

    //Find the node immediately before the insertion position.
    for (int i = 0; i < index -1; i++) {
        previous = previous.next;
        
    }

    //Connect the previous node to the new node.
    newNode.next =previous.next;
    previous.next = newNode;

}
}