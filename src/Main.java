public class Main {

    public static void main(String[] args) {
        
        SinglyLinkedList playlist = new SinglyLinkedList();


        Song song1 = new Song("Imagine", "John Lennon", 103);
        Song song2 = new Song("Thriller", "Michael Jackson",357 );
        Song song3 = new Song("Shake It Off", "Taylor Swift", 219);

        playlist.addLast(song1);
        playlist.addLast(song2);
        playlist.addLast(song3);
        playlist.display();
    }

    }

