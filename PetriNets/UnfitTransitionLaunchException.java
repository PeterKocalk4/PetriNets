package sk.stuba.fei.oop.PetriNets;

public class UnfitTransitionLaunchException extends Exception {
    public UnfitTransitionLaunchException(String transitionName){
        super("Not enough tokens in one or more source places to fire transition " + transitionName);

    }
}
