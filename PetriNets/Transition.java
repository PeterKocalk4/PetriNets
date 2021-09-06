package sk.stuba.fei.oop.PetriNets;

public class Transition extends Vertex {
    private String name;


    public Transition(long ID, String name) {
        setID(ID);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return getID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fire(){


    }


   /* public void setTokens(int tokens) {
    }
    public int getTokens(){
        return 0;
    } ;*/
}
