public class MusicLibrary
{
    private Album[] albums = new Album[10]; //starts with initial size of 10
    private int totalSongs = 0;
    private double totalPlaytime;

    //constructor
    public MusicLibrary()
    {
    }

    public void add(Album album)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if(albums[i] == null)//if there is no album object at this index in the albums array
            {
                albums[i] = album;
                totalSongs += album.getNumOfTracks();
                totalPlaytime +=album.getPlayTime();
                break; //breaks so you dont add this album again 
            }
        }
    }

    public void remove(int index)
    {
        albums[index] = null;
    }

    public void removeByTitle(String title)
    {
        albums[getTitleIndex(title)] = null;
    }

    public void removeByArtist(String title)
    {
        albums[getArtistIndex(title)] = null;
    }

    public void doubleSize()
    {
        Album[] newAlbums = new Album[albums.length*2]; //makes new album array twice the size

        //copies the old albums into the new album array
        for(int i = 0; i < albums.length; i++)
        {
            newAlbums[i] = albums[i];
        }

        //make albums the newAlbum array
        albums = newAlbums;
    }

    //the toString methods, whats called when object is printed
    public String toString()
    {
        String toReturn = "";
        for(int i = 0; i < albums.length; i++)
        {
            if(albums[i] != null) //as longs as an object in albums exists at index i
            {
                toReturn += albums[i].toString() + "\n";
            }    
        }
        toReturn += "Total songs: " + totalSongs +"\n";
        toReturn += "Playtime: " + totalPlaytime;

        return toReturn;
    }

    //linear searches
    public int getTitleIndex(String title)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if(title.equalsIgnoreCase(albums[i].getTitle())) //if the title of the album is equal to the given title
            {
                return i; //return the index in albums
            }
        }
        return -1; //this runs if the code never returned an index.
    }

    public int getArtistIndex(String artist)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if(artist.equalsIgnoreCase(albums[i].getArtist())) //if the title of the album is equal to the given title
            {
                return i; //return the index in albums
            }
        }
        return -1; //this runs if the code never returned an index.
    }

    //Selection sort
    public void sortByTitle()
    {
        for(int i = 1; i < albums.length -1; i++) //goes through each index except last one
        {
            int lowestIndex = i;
            for(int j = i; j < albums.length; j++) //goes through all indexes from i to the end
            {
                //must do (albums[j] != null) to make sure an album exists at this spot
                if(albums[j] != null && albums[j].getTitle().compareToIgnoreCase(albums[lowestIndex].getTitle()) < 0) //if the title of current j index is before the current lowest index
                {
                    lowestIndex = j;   
                }
            }
            //swap them
            Album placeholder;
            placeholder = albums[i];
            albums[i] = albums[lowestIndex];
            albums[lowestIndex] = placeholder;
        }
    }

    //Insertion sort
    public void sortByArtist()
    {
        for(int i = 1; i < albums.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(albums[j] != null && albums[j-1] != null && albums[j].getArtist().compareToIgnoreCase(albums[j-1].getArtist()) < 0) //if this is less than the one before it
                {
                 //swap them
                 Album placeholder;
                 placeholder = albums[j];
                 albums[j] = albums[j-1];
                 albums[j-1] = placeholder;
                }
                else if(albums[j] != null && albums[j-1] != null) //if albums[j] is before albums[j-1] then break out of loop
                {
                    break;
                }
            }
            
        }
    }

    //Binary searches
    public int getTitleIndexBinary(String title)
    {
        int min = 0;
        int max = albums.length;
        int middle = (min +max)/2;
        while(!albums[middle].getTitle().equals(title))//as long as middle isn't what were looking for
        {
            if(albums[middle].getTitle().compareToIgnoreCase(title) < 0) // if middle before title alphabetically
            {   
                min = middle;
                middle = (min +max)/2;
            }
            else
            {
                max = middle;
                middle = (min +max)/2;
            }
        }
        return middle;
    }

    public int getArtistIndexBinary(String artist)
    {
        int min = 0;
        int max = albums.length;
        int middle = (min +max)/2;
        while(!albums[middle].getArtist().equals(artist))//as long as middle isn't what were looking for
        {
            if(albums[middle].getArtist().compareToIgnoreCase(artist) < 0) // if middle before title alphabetically
            {   
                min = middle;
                middle = (min +max)/2;
            }
            else
            {
                max = middle;
                middle = (min +max)/2;
            }
        }
        return middle;
    }

}