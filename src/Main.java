
import java.util.Comparator;
import java.util.Iterator;

//Demonstrates creating a playlist and removing songs using an iterator.
public class Main {

    public static void main(String[] args) {
        
        //Creates an empty playlist. 
        SinglyLinkedList playlist = new SinglyLinkedList();

        //Creates three songs to add to the playlist.
        Song song1 = new Song("Imagine", "John Lennon", 103);
        Song song2 = new Song("Thriller", "Michael Jackson",357 );
        Song song3 = new Song("Shake It Off", "Taylor Swift", 219);
        Song song4 = new Song("Billie Jean", "Michael Jackson",294);


        //Adds each song to the end of the linked list.
        playlist.addLast(song1);
        playlist.addLast(song2);
        playlist.addLast(song3);
        //Inserting Billie Jean at index 1, shifting the other songs forward.
        playlist.add(1,song4);

        //Retrieves the song at index 2 and displays it.
        Song retrievedSong = playlist.get(2);
        System.out.println("Retrieved Song: " + retrievedSong);

        //Displays the playlist after inserting Billie Jean.
        System.out.println("Original Playlist:");

        //Use the enhanced for loop to display each song.
        for (Song song : playlist) {
            System.out.println(song);

        }
        //Removes Thriller from the playlist using an iterator.
        System.out.println("\n Removing Thriller");
        
        //Create an iterator to search through the playlist.
        Iterator<Song> iterator = playlist.iterator();


        while( iterator.hasNext()) {
            Song song = iterator.next();

            //Remove Thriller when matching title is found
            if (song.title.equals("Thriller")) {
                iterator.remove();
                break;
                }
            }
            System.out.println("\n Playlist After Removal:");

            //Display the playlist after removing Thriller.
        for (Song song : playlist) {
            System.out.println(song);

        }

        System.out.println("\n Removing Imagine:");

        //Create a new iterator to search the updated playlist.
        Iterator<Song> iterator2 = playlist.iterator();

        while (iterator2.hasNext()) {
            Song song = iterator2.next();

            //Remove Imagine when matching title found.
            if (song.title.equals("Imagine")) {
                iterator2.remove();
                break;
            }
        }
        System.out.println("\nPlaylist After Removing Imagine:");

        //Display the remaining songs.
        for (Song song :playlist) {
            System.out.println(song);
        }

            // Creates a list that sorts songs alphabetically by title.
SortedLinkedList titlePlaylist = new SortedLinkedList(
    Comparator.comparing(song -> song.title)
);

// Adds songs in an unsorted order.
titlePlaylist.add(0, song2);
titlePlaylist.add(1, song3);
titlePlaylist.add(2, song1);
titlePlaylist.add(3, song4);

// Displays the playlist sorted by title.
System.out.println("\nPlaylist Sorted by Title:");

for (Song song : titlePlaylist) {
    System.out.println(song);
}

SortedLinkedList artistPlaylist = new SortedLinkedList(
    Comparator.comparing(song -> song.artist));

    // Adds songs in an unsorted order.
    artistPlaylist.add(0, song1);
    artistPlaylist.add(1, song2);
    artistPlaylist.add(2, song3);
    artistPlaylist.add(3, song4);

    System.out.println("\n Playlist Sorted by Artist: ");

    for (Song song : artistPlaylist) {
        System.out.println(song);
    }


    }

}