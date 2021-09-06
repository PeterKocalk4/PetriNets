package sk.stuba.fei.oop.PetriNets;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


public class Place extends Vertex {
    private int tokens;

    public Place(long ID, String name, int tokens) {
        this.tokens = tokens;
        setName(name);
        setID(ID);

    }



    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        try {
            if (tokens < 0) {
                throw new InvalidTokensValueException(this.getName());
            } else {
                this.tokens = tokens;
            }
        }catch(InvalidTokensValueException e){
            e.printStackTrace();
        }
    }
}
