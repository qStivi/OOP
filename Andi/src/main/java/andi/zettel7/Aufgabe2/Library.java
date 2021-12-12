package andi.zettel7.Aufgabe2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;

public class Library {

    private final String name;
    private Date lastModified;
    private DVD[] dvds;

    public Library(String name, DVD[] dvds) {
        this.name = name;
        this.lastModified = new Date();
        this.dvds = dvds;
    }

    public void addDVD(DVD dvd) {
        DVD[] dvds1 = Arrays.copyOf(this.dvds, this.dvds.length + 1);
        dvds1[dvds.length] = dvd;
        this.dvds = dvds1;
        this.lastModified = new Date();
    }

    public void removeDVD(String title) {
        removeDVDHelp(title, this.dvds, 0);
    }

    private void removeDVDHelp(String title, DVD[] dvds1, int index) {
        if (index < dvds1.length) {
            if (title.equals(dvds1[index].getTitel())) {
                DVD[] temp = new DVD[dvds1.length - 1];
                if (index == 0) {
                    System.out.println("hi");
                    System.arraycopy(dvds1, 1, temp, 0, dvds1.length - 1);
                    removeDVDHelp(title, temp, index + 1);
                } else {
                    System.arraycopy(dvds1, 0, temp, 0, index - 1);
                    removeDVDHelp(title, temp, index + 1);
                }
            }
        }
        System.out.println(dvds1[0].getTitel());
        this.dvds = dvds1;
    }

    public String getName() {
        return name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public DVD[] getDvds() {
        return dvds;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setDvds(DVD[] dvds) {
        this.dvds = dvds;
    }

    public static void main(String[] args) {
        Actor actor1 = new Actor("das", "sda", new Date(1978, 12, 32));
        Actor[] headliner = {actor1};

        Director mcPimmel = new Director("Mc", "Pimmel", new Date(1990, 11, 11));

        DVD first = new DVD("first", "122323", mcPimmel, headliner);
        DVD second = new DVD("second", "122323", mcPimmel, headliner);
        DVD third = new DVD("third", "122323", mcPimmel, headliner);

        DVD[] firstDVD = {first, second, first};
        Library library1 = new Library("library1", firstDVD);
        System.out.println(library1.getDvds()[0].getTitel());
        library1.addDVD(third);
        //library1.removeDVD("first");
        System.out.println(library1.getDvds()[3].getTitel());
    }
}
