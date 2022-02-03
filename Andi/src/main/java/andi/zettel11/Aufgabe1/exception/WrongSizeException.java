package andi.zettel11.Aufgabe1.exception;

public class WrongSizeException extends Exception{
    public WrongSizeException(int size){
        super(size + " this size is invalid.");
    }
}
