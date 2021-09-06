package sk.stuba.fei.oop.PetriNets;

public class InvalidTokensValueException extends Exception{
    public InvalidTokensValueException(String placeName){
        super("Number of tokens in place '" + placeName + "' cannot be less than 0");

    }
}
