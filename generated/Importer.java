package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.PetriNets.IllegalArcWeightException;
import sk.stuba.fei.oop.PetriNets.NullVertexException;
import sk.stuba.fei.oop.PetriNets.PetriNet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Importer {
    private int isPlace = 0;
    private int isTrans = 0;
    private sk.stuba.fei.oop.PetriNets.Place srcPlace;
    private sk.stuba.fei.oop.PetriNets.Place destPlace;
    private sk.stuba.fei.oop.PetriNets.Transition srcTrans;
    private sk.stuba.fei.oop.PetriNets.Transition destTrans;


    public Document importFile(String path) throws JAXBException, FileNotFoundException{
        FileInputStream stream = new FileInputStream(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Document) unmarshaller.unmarshal(stream);
    }

    public PetriNet importNet(Document document) throws NullVertexException, IllegalArcWeightException {
        PetriNet net = new PetriNet();

        for(Place place : document.getPlace()){
            sk.stuba.fei.oop.PetriNets.Place place1= new sk.stuba.fei.oop.PetriNets.Place(
                    place.getId(),place.getLabel(),place.getTokens()
            );
            place1.setX(place.getX());
            place1.setY(place.getY());
            net.addPlace(place1);

        }



        for(Transition trans : document.getTransition()){
            sk.stuba.fei.oop.PetriNets.Transition trans1 = new sk.stuba.fei.oop.PetriNets.Transition(
                    trans.getId(),trans.getLabel()
            );
            trans1.setX(trans.getX());
            trans1.setY(trans.getY());
            net.addTrans(trans1);
        }

        for(Arc arc : document.getArc()){
            short SrcId = arc.getSourceId();
            short DestId = arc.getDestinationId();
            srcPlace = null;
            destPlace = null;
            srcTrans = null;
            destTrans = null;

            for(sk.stuba.fei.oop.PetriNets.Place place2 : net.getPlaces()){
                if(place2.getID() == SrcId){
                    srcPlace=place2;
                }else if(place2.getID() == DestId){
                    destPlace = place2;
                }
            }

            for(sk.stuba.fei.oop.PetriNets.Transition trans2 : net.getTransitions()){
                if(trans2.getID() == SrcId){
                    srcTrans=trans2;
                }else if(trans2.getId() == DestId){
                    destTrans = trans2;
                }


            }

            if(srcPlace != null && arc.getType().equals("regular")){


                  sk.stuba.fei.oop.PetriNets.ArcPltoTrans ArcPT = new sk.stuba.fei.oop.PetriNets.ArcPltoTrans((int) arc.getMultiplicity(), srcPlace, destTrans);
                  net.addArc(ArcPT);

            }else if(srcTrans != null && arc.getType().equals("regular")){

                sk.stuba.fei.oop.PetriNets.ArcTranstoPl ArcTP = new sk.stuba.fei.oop.PetriNets.ArcTranstoPl((int)arc.getMultiplicity(),srcTrans,destPlace);
                net.addArc(ArcTP);

            } else {

                //System.out.println("reset arc");
                sk.stuba.fei.oop.PetriNets.ResetArc ArcR = new sk.stuba.fei.oop.PetriNets.ResetArc(srcPlace,destTrans);
                net.addArc(ArcR);
            }

        }



        return net;
    }


}
