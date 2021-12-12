package de.qStivi.zettel7.Aufgabe2;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Library {
    private final String name;
    private Date lastModified;
    private DVD[] items;

    /**
     * This Constructur returns a library Object initialized with a name and {@link DVD} items.
     * It also sets the lastModified property to the current time.
     *
     * @param name  is a {@link String} representing the name of the library.
     * @param items is an array of {@link DVD}s.
     */
    public Library(String name, DVD[] items) {
        this.name = name;
        this.lastModified = new Date();
        this.items = items;
    }

    public static void main(String[] args) {
        var sumireMorohoshi = new Actor("Sumire", "Morohoshi", new Date(new GregorianCalendar(1999, GregorianCalendar.JANUARY, 23, 0, 0, 0).getTimeInMillis()));
        var yoshimasaHosoya = new Actor("Yoshimasa", "Hosoya", new Date(new GregorianCalendar(1982, GregorianCalendar.FEBRUARY, 10, 0, 0, 0).getTimeInMillis()));
        var mariaNaganawa = new Actor("Maria", "Naganawa", new Date(new GregorianCalendar(1995, GregorianCalendar.AUGUST, 5, 0, 0, 0).getTimeInMillis()));
        var yuukiKaji = new Actor("Yuuki", "Kaji", new Date(new GregorianCalendar(1985, GregorianCalendar.SEPTEMBER, 3, 0, 0, 0).getTimeInMillis()));
        var yuiIshikawa = new Actor("Yui", "Ishikawa", new Date(new GregorianCalendar(1989, GregorianCalendar.MAY, 30, 0, 0, 0).getTimeInMillis()));
        var natsukiHanae = new Actor("Natsuki", "Hanae", new Date(new GregorianCalendar(1991, GregorianCalendar.MAY, 26, 0, 0, 0).getTimeInMillis()));
        var inoriMinase = new Actor("Inori", "Minase", new Date(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 2, 0, 0, 0).getTimeInMillis()));
        var miyuTomita = new Actor("Miyu", "Tomita", new Date(new GregorianCalendar(1999, GregorianCalendar.NOVEMBER, 15, 0, 0, 0).getTimeInMillis()));
        var yuusukeKobayashi = new Actor("Yuusuke", "Kobayashi", new Date(new GregorianCalendar(1985, GregorianCalendar.MARCH, 25, 0, 0, 0).getTimeInMillis()));
        var amiKoshimizu = new Actor("Ami", "Koshimizu", new Date(new GregorianCalendar(1986, GregorianCalendar.FEBRUARY, 15, 0, 0, 0).getTimeInMillis()));

        var youYoshinari = new Director("You", "Yoshinari", new Date(new GregorianCalendar(1971, GregorianCalendar.MAY, 6, 0, 0, 0).getTimeInMillis()));
        var tetsurouAraki = new Director("Tetsurou", "Araki", new Date(new GregorianCalendar(1976, GregorianCalendar.NOVEMBER, 5, 0, 0, 0).getTimeInMillis()));
        var yuuichirouHayashi = new Director("Yuuichirou", "Hayashi", null);
        var haruoSotozaki = new Director("Haruo", "Sotozaki", null);
        var hidekiTachibana = new Director("Hideki", "Tachibana", null);
        var masayukiKojima = new Director("Masayuki", "Kojima", new Date(new GregorianCalendar(1961, GregorianCalendar.MARCH, 11, 0, 0, 0).getTimeInMillis()));
        var shinyaIino = new Director("Shinya", "Iino", null);
        var hiroyukiImaishi = new Director("Hiroyuki", "Imaishi", new Date(new GregorianCalendar(1971, GregorianCalendar.OCTOBER, 4, 0, 0, 0).getTimeInMillis()));

        var bna = new DVD("BNA", "979-8777519115", youYoshinari, new Actor[]{sumireMorohoshi, yoshimasaHosoya, mariaNaganawa});
        var aot1 = new DVD("Attack on Titan S1", "978-3551791641", tetsurouAraki, new Actor[]{yuukiKaji, yuiIshikawa});
        var aot2 = new DVD("Attack on Titan S2", "978-3551791641", yuuichirouHayashi, new Actor[]{yuukiKaji, yuiIshikawa});
        var kny = new DVD("Demon Slayer: Kimetsu no Yaiba", "978-3964332806", haruoSotozaki, new Actor[]{natsukiHanae});
        var danmachi3 = new DVD("Is It Wrong to Try to Pick Up Girls in a Dungeon? III", "978-0316340151", hidekiTachibana, new Actor[]{inoriMinase});
        var mia = new DVD("Made in Abyss", "978-3963587061", masayukiKojima, new Actor[]{miyuTomita});
        var stone2 = new DVD("Dr. STONE: STONE WARS", "978-1974705061", shinyaIino, new Actor[]{yuusukeKobayashi});
        var klk = new DVD("Kill la Kill", "978-3-8420-1254-7", hiroyukiImaishi, new Actor[]{amiKoshimizu});

        var myLibrary = new Library("AniList", new DVD[]{bna, aot1, aot2});
        myLibrary.addDVD(kny);
        myLibrary.addDVD(danmachi3);
        myLibrary.addDVD(danmachi3);
        myLibrary.addDVD(mia);
        myLibrary.addDVD(stone2);
        myLibrary.addDVD(klk);
        myLibrary.removeDVD("Attack on Titan S2");
        myLibrary.removeDVD("Is It Wrong to Try to Pick Up Girls in a Dungeon? III");
        for (DVD item : myLibrary.getItems()) {
            System.out.println(item.getName());
        }
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public DVD[] getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Adds a {@link DVD} to the library and sets the lastModified property to now.
     *
     * @param dvd is the {@link DVD} item to be added.
     */
    private void addDVD(DVD dvd) {
        var newItems = Arrays.copyOf(this.items, this.items.length + 1);
        newItems[this.items.length] = dvd;
        this.items = newItems;
        this.lastModified = new Date();
    }

    /**
     * Removes all {@link DVD}s with the provided title from the library and sets the lastModified property to now.
     *
     * @param title a {@link String} representing the title of a {@link DVD}.
     */
    private void removeDVD(String title) {
        var itemsToBeRemoved = getAllByName(title); // Get all DVDs from our library which have a specified title

        // Iterate through all items in our library
        for (int j = 0; j < this.items.length; j++) {
            // Set current item null if the current item equals one of the items which are to be removed
            for (DVD dvd : itemsToBeRemoved) {
                if (this.items[j].equals(dvd)) {
                    this.items[j] = null;
                    break;
                }
            }
        }

        // Count all items which are not null for later use
        var numberOfItemsNotNull = 0;
        for (DVD item : this.items) {
            if (item != null) {
                numberOfItemsNotNull++;
            }
        }

        // Create a new array with size of numberOfItemsNotNull and fill it with all items which are not null
        var newItems = new DVD[numberOfItemsNotNull];
        for (int i = 0, j = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                newItems[j] = this.items[i];
                j++;
            }
        }

        this.items = newItems;
        this.lastModified = new Date();
    }

    /**
     * Returns an array of {@link DVD}s with a provided title.
     *
     * @param title is a {@link String} which represents the title.
     * @return an array of {@link DVD}s.
     */
    private DVD[] getAllByName(String title) {
        // Count number of items with specified name for later use
        var numberOfItems = 0;
        for (DVD item : this.items) {
            if (item.getName().equals(title)) {
                numberOfItems++;
            }
        }

        // Create array with size of previously counted items and fill it
        var itemsWithName = new DVD[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            for (DVD item : this.items) {
                if (item.getName().equals(title)) {
                    itemsWithName[i] = item;
                }
            }
        }
        return itemsWithName;
    }

    /**
     * Checks if any {@link DVD} in your library has the same name as the provided {@link DVD}.
     *
     * @param dvd is a {@link DVD} object of which you want to now if its name exists in your library.
     * @return a boolean true if a {@link DVD} with the same name as the provided one exists in your library and false if it does not.
     */
    private boolean doIOwn(DVD dvd) {
        for (DVD item : this.items) {
            if (item.getName().equals(dvd.getName())) {
                return true;
            }
        }
        return false;
    }

}
