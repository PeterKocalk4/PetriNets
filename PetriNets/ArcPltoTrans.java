package sk.stuba.fei.oop.PetriNets;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}SourceID"/&gt;
 *         &lt;element ref="{}DestID"/&gt;
 *         &lt;element ref="{}weight"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */

/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "SourceID",
        "DestID",
        "weight"
})


@XmlRootElement(name = "arc")*/
public class ArcPltoTrans extends Arc{
   // private int weight;
    private Place start;
    private Transition end;


    public ArcPltoTrans(){};
    public ArcPltoTrans(int weight, Place start, Transition end) throws IllegalArcWeightException, NullVertexException{
        if(weight < 1) {
            throw new IllegalArcWeightException();
        }
        else if(start != null && end != null) {
            //this.weight = weight;
            this.setWeight(weight);
            this.start = start;
            this.end = end;
            this.setDestID(end.getID());
            this.setSrcID(start.getID());
        }else{
            throw new NullVertexException();
        }
    }

    /*public int getWeight() {
        return getWeight();
    }

    public void setWeight(int weight) throws IllegalArcWeightException {
        if(weight < 1) {
            throw new IllegalArcWeightException();
        }else{
            this.setWeight(weight);
        }

    }*/





    public Place getStart() {
        return this.start;
    }


   /* public void setStart(Place start) {
        this.start = start;
    }*/

    public Transition getEnd() {
        return end;
    }


   /* public void setEnd(Transition end) {
        this.end = end;
    }*/

}
