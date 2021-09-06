package sk.stuba.fei.oop.PetriNets;

public class NullVertexException extends Exception{
    public NullVertexException(){
        super("Start and/or end of the arc is not defined");

    }
}
