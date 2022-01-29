package de.qStivi.zettel10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Why {
    public static void main(String[] args) {
        Logger.getGlobal().log(Level.WARNING, "jup"); // With this line, yo gets printed before yee...
        System.out.println("yee");
        System.err.println("yo");
    }
}
