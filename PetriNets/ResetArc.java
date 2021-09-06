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


@XmlRootElement(name = "resetArc")*/

public class ResetArc extends Arc {
    //private int weight = 0;
    private Place start;
    private Transition end;
 //   private long SourceID;
  //  private long DestID;

public ResetArc(){};
    public ResetArc(Place start, Transition end) throws NullVertexException {
        if(start != null && end != null){
        this.setWeight(0);
        this.start = start;
        this.end = end;
        this.setDestID(end.getID());
        this.setSrcID(start.getID());
        }else{
            throw new NullVertexException();
        }
    }

    public void setWeight(int weight){
        System.out.println("Sorry, weight of reset arc cannot be changed");
    }

   /* public int getWeight() {
        return this.getWeight();
    }*/


    public Place getStart() {
        return start;
    }

   /* public void setStart(Place start) {
        this.start = start;
    }*/

    public Transition getEnd() {
        return end;
    }

    /*public void setEnd(Transition end) {
        this.end = end;
    }*/

    /*@Override
    public long getSrcID(){
        return this.getSrcID();
    }
    @Override
    public long getDestID(){
        return this.getDestID();
    }*/

    /*@Override
    public long getDestID(){
        return this.getDestID();
    }*/

}
