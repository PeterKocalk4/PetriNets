package sk.stuba.fei.oop.PetriNets;

public class IllegalArcWeightException extends Exception {

    public IllegalArcWeightException(){
        //System.out.println("Common arc weight cant be less than 1");

        super("Common arc weight cant be less than 1");

    }
}
