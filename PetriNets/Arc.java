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


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "SourceID",
        "DestID",
        "weight"
})


@XmlRootElement(name = "arc")
public abstract class Arc {
    private int weight;
    private long SourceID;
    private long DestID;





    public void setSrcID(long srcid){this.SourceID = srcid;};
    public void setDestID(long destid){this.DestID = destid;};
    public long getSrcID(){return this.SourceID;};
    public long getDestID(){return this.DestID;};
    public abstract Vertex getStart();
    public abstract Vertex getEnd();
    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weightt)throws IllegalArcWeightException{
        if(weightt < 1) {
            throw new IllegalArcWeightException();
        }else{
            this.weight=weightt;
        }
    }


}
