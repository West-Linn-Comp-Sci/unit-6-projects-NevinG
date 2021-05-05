import java.util.Scanner;

public class MusicLibrary
{
    static Album[] albums = new Album[1];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        initialAlbums();
        while(true)
        {
            System.out.println("Use numbers to interact with program");
            System.out.println("(1) - view albums");
            System.out.println("(2) - add album(You can have 10 albums maximum");
            System.out.println("(3) - remove album");
            System.out.println("(4) - get album through title");
            System.out.println("(5) - get album through artist");

            String input = scanner.nextLine();
    
            if(input.equals("1")) //display albums
            {
               for(int i = 0; i < albums.length; i++)
               {
                   if(albums[i] != null)
                   {
                       System.out.println(albums[i]);
                   }
               }
                   System.out.println("press enter to return to main music Library");
                   scanner.nextLine();
            }
            else if(input.equals("2"))//make and add album
            {
               addAlbum();
            }
            else if(input.equals("3"))//make and add album
            {
               removeAlbum();
            }
            else if(input.equals("4"))
            {
               getAlbumByTitle();

               System.out.println("press enter to return to main music Library");
               scanner.nextLine();
            }
            else if(input.equals("5"))
            {
                getAlbumByArtist();

                System.out.println("press enter to return to main music Library");
                scanner.nextLine();
            }
            else
            {
                System.exit(0);
            }
        }
        
    }

    public static void addAlbum()
    {
        int totalTracks = 0;
        String trackName;
        int trackLength;
        Track[] curTracks = new Track[1];
         //make track array

         while(true)
         {
             totalTracks++;
            System.out.println("Enter track " + totalTracks + " name:");
            trackName = scanner.nextLine();
            System.out.println("Enter track " + totalTracks + " length in minutes:");
            trackLength= scanner.nextInt();
            System.out.println("Type 0 if you don't want to add any more tracks.");
            System.out.println("Or hit enter to add more tacks");

            //increases curTracks array if it needs to be increased
            boolean openSpace = false;
            for(int i = 0; i < curTracks.length; i++)
            {
                if(curTracks[i] == null)
                {
                    openSpace = true;
                    break;
                }
            }

            if(!openSpace)
            {
                Track[] placeholder = new Track[curTracks.length + 1];
                for(int i = 0; i < curTracks.length; i++)
                {
                    placeholder[i] = curTracks[i];
                }
                curTracks = placeholder;
            }
            
            //adds track to track array
            for(int i = 0; i < curTracks.length; i++)
            {
                if(curTracks[i] == null)
                {
                    curTracks[i] = new Track(trackName, trackLength);
                    break;
                }
            }
           
            scanner.nextLine();
            String cont;
            cont = scanner.nextLine();
            if(cont.equals("0"))
            {
                break;
            }

         }
         System.out.println("Enter the author of the album");
         String author = scanner.nextLine();

         System.out.println("Enter the title");
         String title = scanner.nextLine();

         //increases album array length by 1 if needed
         boolean openSpace = false;

         for(int i = 0; i < albums.length; i++)
         {
             if(albums[i] == null)
             {
                openSpace = true;
             }
         }

         if(!openSpace)
         {
             Album[] placeholder = new Album[albums.length + 1];
             for(int i = 0; i < albums.length; i++)
             {
                 placeholder[i] = albums[i];
             }
         }

         //add album
         for(int i =0; i < albums.length; i++)
         {
             if(albums[i] == null)
             {
                albums[i] = new Album(curTracks, author,title);
                break;
             }
         }

    }

    public static void removeAlbum()
    {
        System.out.println("Type album name to remove: ");
        String albumName = scanner.nextLine();
        for(int i = 0; i < albums.length; i++)
        {
            if(albums[i] != null && albums[i].title.equalsIgnoreCase(albumName))
            {
                System.out.println("Removed " + albumName);
                albums[i] = null;
                return;
            }
        }
        System.out.println("Couldn't find album " + albumName + " to remove\n");
    }

    public static void initialAlbums()
    {
        albums = new Album[2];
        albums[0] = new Album(new Track[]{new Track("Sunflower",2), new Track("Circles",3), new Track("Congradulations",1)},"Post Malone","Into the Spiderverse");
        albums[1] = new Album(new Track[]{new Track("Homework",3), new Track("Paint",4), new Track("Liverpool",3)},"Nevin Gilday","Some stuff I wrote");
    }

    public static void getAlbumByArtist()
    {
        System.out.println("Type artist to get album");
        String artistName = scanner.nextLine();
        int index = getAlbumIndexByArtist(artistName);
        if(index != -1)
        {
            System.out.println(albums[index]);
        }
        else
        {
            System.out.println("couldn't find album\n");
        }
    }

    public static void getAlbumByTitle()
    {
        System.out.println("Type album name to get");
        String albumName = scanner.nextLine();
        int index = getAlbumIndexByTitle(albumName);
        if(index != -1)
        {
            System.out.println(albums[index]);
        }
        else
        {
            System.out.println("couldn't find album\n");
        }
    }

    public static int getAlbumIndexByArtist(String artistName)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if(artistName.equalsIgnoreCase(albums[i].author))
            {
                return i;
            }
        }
        return -1;
    }

    public static int getAlbumIndexByTitle(String title)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if(albums[i].title.equalsIgnoreCase(title))
            {
                return i;
            }
        }
        return -1;
    }

    public static void sortAlbumsByAlphabetically()
    {
        //goes through full array and swaps alphabetially first with first one
        //go through rest of array and swamp alphabetically first with the second one
        int lowestIndex = 0;
        for(int i = 0; i < albums.length -1; i++)
        {
            for(int j = i; j < albums.length; a++)
            {
                if(albums[i] != null && alphabeticallyFirst(albums[lowesetIndex],albums[i]) == 1)
                {
                 lowestIndex = i;   
                }
            }
            //swap them
            Album placeholder;
            placeholder = albums[i];
            albums[i] = albums[lowestIndex];
            albums[lowestIndex] = placeholder;
        }
    }
    public static int alphabeticallyFirst(String a, String b)
    {
        //gets shortest length
        int length;
        if(a.length() < b.length())
        length = a.length();
        length = b.length();

        for(int i = 0; i < length; i++)
        {
            if(letterValue(a.charAt(i)) < letterValue(b.charAt(i)))
            {
                return 0;
            }
            else if(letterValue(a.charAt(i)) > letterValue(b.charAt(i)))
            {
                return 1;
            }
        }

        return 0;
    }
    public static int letterValue(char letter)
    {
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < letters.length; i++)
        {
            if(letters[i] == letter)
            {
                return i;
            }
        }
        return -1;
    }
    public static void sortAlbumsByTime()
    {

    }

}
