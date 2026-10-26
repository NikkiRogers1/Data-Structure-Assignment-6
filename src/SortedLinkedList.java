
import java.util.Comparator;
import java.util.Iterator;

//A sorted linked list that automatically places songs in order
public class SortedLinkedList extends SinglyLinkedList {

    //Determine how songs should be compared and sorted.
    Comparator<Song> sort;

    //Recieves the comparator that defines the sorting order.
public SortedLinkedList(Comparator<Song> sort){
    this.sort = sort;

} 
//Overrides the parent's add method to insert songs in sorted order.
//The Index parameter is ignored because the comparator determines the position.
@Override
public void add(int index, Song song ) {
    
    //Starts searching at the beginning of the list.
    int position = 0;
    
    //Creates an iterator to move through the existing songs. 
    Iterator<Song> iterator = iterator();

    //Continues searching while there are more songs in the list
    while (iterator.hasNext()) {
        
        //Retrieves the next song to compare with the new song.
        Song currentSong = iterator.next();

        //Checkes whether the new song belongs before the current song. 
        if (sort.compare(song, currentSong) < 0) {

            //Stops searching because the position was found.
            break;
        } 

        //Moves to the next position if the new song belongs after this one. 
        position++;
    }
    //Inserts the new song at the position determined by the search.
    super.add(position, song);
}


}

