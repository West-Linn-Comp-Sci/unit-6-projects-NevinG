public class Album
{
    private String title;
    private String artist;
    private int numOfTracks;
    private double playTime;

    //constructor
    public Album(String title, String artist, int numOfTracks, double playTime)
    {
        //assign object attributes
        this.title = title;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
        this.playTime = playTime;
    }

    //toString method, what get called when object is printed
    public String toString()
    {
        return title + " by " + artist + ", " + numOfTracks + " tracks, " + playTime + " minutes long.";
    }

    //get methods
    public int getNumOfTracks()
    {
        return numOfTracks;
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }
    
    public double getPlayTime()
    {
        return playTime;
    }
}