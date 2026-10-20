public class Song {
    String title;
    String artist;
    int duration;

    public Song (String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;

    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + " seconds)";
    }

}