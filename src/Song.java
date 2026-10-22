//Represents a song with a title, artist and duration.
public class Song {
    //Stores the songs titles, artist, and duration in seconds.
    String title;
    String artist;
    int duration;

    //Initializes a song with its information.
    public Song (String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;

    }
//Returns a readable description of the song when printed.
    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + " seconds)";
    }

}