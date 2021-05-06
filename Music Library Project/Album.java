public class Album
{
    Track[] tracks = new Track[1];
    String author;
    String title;
    double playTime;//in minutes

    public Album(Track[] tracks, String author, String title)
    {
        this.tracks = tracks;
        this.author = author;
        this.title = title;
        calculatePlayTime();
    }

    void calculatePlayTime()
    {
        playTime = 0;
        for(Track track : tracks)
        {
            if(track != null)
            playTime += track.playTime;
        }
    }

    public String toString()
    {
        String toReturn = title + " : " + playTime + " minutes By: " + author + "\n";
        for(Track track : tracks)
        {
            if(track != null)
            toReturn += track.trackName + " : " + track.playTime + " minutes\n";
        }
        return toReturn;
    }

}
