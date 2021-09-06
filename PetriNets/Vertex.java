package sk.stuba.fei.oop.PetriNets;

public abstract class Vertex {
    private long ID;
    private String name;
    int x;
    int y;


    public long getID() {
        return ID;
    }

    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /*

    public String whatAmI(Transition t){
        return "Transition";
    }

    public String whatAmI(Place p){
        return "Place";
    }*/

}
