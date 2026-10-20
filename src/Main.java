
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        
        SinglyLinkedList playlist = new SinglyLinkedList();


        Song song1 = new Song("Imagine", "John Lennon", 103);
        Song song2 = new Song("Thriller", "Michael Jackson",357 );
        Song song3 = new Song("Shake It Off", "Taylor Swift", 219);

        playlist.addLast(song1);
        playlist.addLast(song2);
        playlist.addLast(song3);
        
        System.out.println("Original Playlist:");

        for (Song song : playlist) {
            System.out.println(song);

        }
        System.out.println("\n Removing Thriller");
        
        Iterator<Song> iterator = playlist.iterator();


        while( iterator.hasNext()) {
            Song song = iterator.next();

            if (song.title.equals("Thriller")) {
                iterator.remove();
                break;
                }
            }
            System.out.println("\n Playlist After Removal:");

        for (Song song : playlist) {
            System.out.println(song);

        }

        System.out.println("\n Removing Imagine:");

        Iterator<Song> iterator2 = playlist.iterator();

        while (iterator2.hasNext()) {
            Song song = iterator2.next();

            if (song.title.equals("Imagine")) {
                iterator2.remove();
                break;
            }
        }
        System.out.println("\nPlaylist After Removing Imagine:");

        for (Song song :playlist) {
            System.out.println(song);
        }
    }


    }

