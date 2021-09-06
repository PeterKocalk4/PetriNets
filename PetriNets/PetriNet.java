package sk.stuba.fei.oop.PetriNets;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "places",
        "transitions",
        "arcs"
})

@XmlRootElement(name = "petrinet")
public class PetriNet {
    private List<Place> places;
    private List<Transition> transitions;
    private List<Arc> arcs;

    public PetriNet() {
        places = new ArrayList<>();
        transitions = new ArrayList<>();
        arcs = new ArrayList<>();
    }

    public Arc getArc(long srcId, long destId){
        for(Arc arc:arcs){
            if(arc.getStart().getID()==srcId && arc.getEnd().getID()==destId){
            return arc;
            }
        }

        return null;
    }


    public Place getPlace(long ID) throws NullVertexException{

        for (Place place : places) {
            if (place.getID() == ID) {
                return place;
            }
        }
        //throw NullVertexException;
        return null;
    }

    public Transition getTransition(long ID) throws NullVertexException{

        for (Transition trans : transitions) {
            if (trans.getID() == ID) {
                return trans;
            }
        }
        //throw NullVertexException;
        return null;
    }


   // @XmlElement(type=Place.class)
   public List<Place> getPlaces() {
        return places;
    }

    public void addPlace(Place place) {
        places.add(place);
    }

   // @XmlElement(type=Transition.class)
    public List<Transition> getTransitions() {
        return transitions;
    }

    public void addTrans(Transition trans) {
        transitions.add(trans);
    }

    /**
     * Gets the value of the arc property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arc property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArc().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArcPltoTrans }
     * {@link ArcTranstoPl }
     *  {@link ResetArc }
     */

   // @XmlElement(type=Arc.class)
    public List<Arc> getArcs() {
        return arcs;
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }


    private Transition getTrans(int ID){
        for(Transition trans : transitions){
            if(trans.getID()==ID){
                return trans;
            }
        }

        System.out.println("\n Transition with ID " + ID + " not found\n");
        return null;
    }

    public boolean isExecutableGraphics(int ID){
        Transition trans = getTrans(ID);
        List<ArcPltoTrans> ToTrans = new ArrayList<>();
        List<ArcTranstoPl> FromTrans = new ArrayList<>();
        List<ResetArc> ResetArcs = new ArrayList<>();

        if(isExecutable(trans, ToTrans, FromTrans, ResetArcs)){
            return true;
        }
        return false;
    }

    private boolean isExecutable (Transition trans, List<ArcPltoTrans> ToTrans, List<ArcTranstoPl> FromTrans, List<ResetArc> ResetArcs){
        //int launch = 0;
        int totalTokens = 0;
        int totalWeight = 0;
        int listIndex=0;

        for(Arc arc : arcs) {
            if(arc.getEnd() == trans && arc.getWeight()!=0 ){
                ToTrans.add((ArcPltoTrans) arc);
                if( ToTrans.get(listIndex).getStart().getTokens() >= arc.getWeight()) {
                    totalTokens = totalTokens + ToTrans.get(listIndex).getStart().getTokens();
                    totalWeight = totalWeight + ToTrans.get(listIndex).getWeight();
                    listIndex++;
                    //launch++;
                }else{
                    return false;
                }
            }

            if(arc.getStart() == trans){
                FromTrans.add((ArcTranstoPl) arc);
            }

            if(arc.getWeight()==0 && arc.getEnd() == trans){
                ResetArcs.add((ResetArc)arc);
            }

        }

        if(totalTokens >= totalWeight) {
            return true;
        }else{
            return false;
        }
    }


    private void tryFire (int ID) throws UnfitTransitionLaunchException{

        Transition trans = getTrans(ID);
        List<ArcPltoTrans> ToTrans = new ArrayList<>();
        List<ArcTranstoPl> FromTrans = new ArrayList<>();
        List<ResetArc> ResetArcs = new ArrayList<>();

        if(isExecutable(trans, ToTrans, FromTrans, ResetArcs)){

            for(ArcPltoTrans arc : ToTrans) {
                arc.getStart().setTokens(arc.getStart().getTokens() - arc.getWeight());
               /* if(arc.getStart().getTokens() >= arc.getWeight()){

                }*/

            }

            for(ArcTranstoPl arc : FromTrans) {
                arc.getEnd().setTokens(arc.getEnd().getTokens() + arc.getWeight());
            }

            for(ResetArc arc : ResetArcs) {
                arc.getStart().setTokens(0);
            }
        }else{
            throw new UnfitTransitionLaunchException(trans.getName());
        }
    }

public void fire (int ID){
        try{
            tryFire(ID);
        }catch(UnfitTransitionLaunchException error){
            error.printStackTrace();
        }

}

public void showState() {

    System.out.println("------------Current net state------------");

    for (Place place : places) {
        System.out.println("Place name " + place.getName());
        System.out.println("ID:" + place.getID());
        System.out.println("Tokens:" + place.getTokens() + "\n");
    }
    System.out.println("-----------------------------------------");
}


    public void showNetTransitions() {
        System.out.println("---------------Transitions---------------");
        for (Transition trans : transitions) {
            System.out.println("Transition name " + trans.getName());
            System.out.println("ID:" + trans.getID());
        }
        System.out.println("------------------------------------------");
    }

    public void showArcs() {
        int i = 0;
        System.out.println("-------------------Arcs-------------------");
        for (sk.stuba.fei.oop.PetriNets.Arc arc : arcs) {
            System.out.println("Arc weight " + arc.getWeight());
            System.out.println("Start:" + arc.getStart().getName());
            System.out.println("End:" + arc.getEnd().getName());
            i++;
        }
        System.out.println("------------------------------------------");
        System.out.println("Total number of = "+i);
        System.out.println("------------------------------------------");
    }


    public void deletePlace(Place p){

        if( arcs.removeIf((Arc arr) -> (arr.getStart() == p || arr.getEnd() == p)) ){
            System.out.println("Arc deleted");

        }
        this.places.remove(p);


    }

    public void deleteTransition(Transition t){

        if(    arcs.removeIf((Arc arr) -> (arr.getStart() == t || arr.getEnd() == t)) ){
            System.out.println("Arc deleted");

        }
        this.transitions.remove(t);
    }


    public void deleteArc(Arc a){
              if(    arcs.removeIf((Arc arr) -> (arr.getStart() == a.getStart() && arr.getEnd() == a.getEnd())) ){
            System.out.println("Arc deleted");

        }
    }
}