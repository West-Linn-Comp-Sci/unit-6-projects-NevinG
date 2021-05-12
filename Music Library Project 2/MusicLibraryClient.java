public class MusicLibraryClient {
    public static void main(String[] args) {
        MusicLibrary myLibrary = new MusicLibrary();

        Album a1 = new Album("First", "one Guy", 10, 42.5);
        Album a2 = new Album("This Music", "Some Band", 9, 36);
        Album a3 = new Album("Play", "People", 12, 39);
        Album a4 = new Album("Funk", "Frank", 20, 10);
        Album a5 = new Album("Jazz", "Dwight", 4, 5.4);
        Album a6 = new Album("Zamboni", "Sarah", 1, 3.6);

        //tests adding
        myLibrary.add(a1);
        myLibrary.add(a2);
        myLibrary.add(a3);
        myLibrary.add(a4);
        myLibrary.add(a5);
        myLibrary.add(a6);
        System.out.println("Here is you music library:");
        System.out.println(myLibrary + "\n");

        //tests removing
        myLibrary.remove(4);
        System.out.println("Jazz by Dwight should be gone");
        System.out.println(myLibrary + "\n");
        myLibrary.add(a5); //adds it back

        //tests getTitleIndex()
        System.out.println("Funk is at index " + myLibrary.getTitleIndex("Funk"));
        System.out.println("Expecting 3\n");

        //tests getArtistIndex()
        System.out.println("Artist Some Band is at index " + myLibrary.getArtistIndex("Some Band"));
        System.out.println("Expecting 1\n");

        //tests sortByTitle()
        System.out.println("Sorted By Title:");
        myLibrary.sortByTitle();
        System.out.println(myLibrary + "\n");

        //tests getTitleIndexBinary()
        System.out.println("Funk is at index " + myLibrary.getTitleIndexBinary("Funk"));
        System.out.println("Expecting 1" + "\n");

        //tests sortByArtist()
        System.out.println("Sorted By Artist:");
        myLibrary.sortByArtist();
        System.out.println(myLibrary + "\n");

        //tests getArtistIndexBinary()
        System.out.println("Artist Sarah is at index " + myLibrary.getArtistIndexBinary("Sarah"));
        System.out.println("Expecting 4" + "\n");

    }
}