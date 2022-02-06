package julian.zettel11.aufgabe1.exceptions;

public class IllegalSizeException extends Exception{

    public IllegalSizeException() {
        super("Creature's dimensions do not fit the typical dimensions of this type");
    }

}
