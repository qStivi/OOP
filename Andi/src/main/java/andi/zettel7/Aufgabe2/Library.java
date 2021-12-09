package andi.zettel7.Aufgabe2;

import java.util.Arrays;
import java.util.Date;

public class Library {

    private final String name;
    private Date lastModified;
    private DVD[] dvds;

    public Library (String name, DVD[] dvds){
        this.name = name;
        this.lastModified = new Date();
        this.dvds = dvds;
    }

    public void addDVD(DVD dvd){
        DVD[] dvds1 = Arrays.copyOf(this.dvds, this.dvds.length + 1);
        dvds1[dvds.length + 1] = dvd;
        this.dvds = dvds1;
        this.lastModified = new Date();
    }

    public void removeDVD(String title){
        removeDVDHelp(title, this.dvds, 0);
    }

    private void removeDVDHelp(String title, DVD[] dvds1 , int index){
        if (index < dvds1.length){
            if (title.equals(dvds1[index].getTitel())){
                //System.arraycopy();
            }
        }
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
}
