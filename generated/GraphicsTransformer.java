package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.PetriNets.ArcPltoTrans;
import sk.stuba.fei.oop.PetriNets.ArcTranstoPl;
import sk.stuba.fei.oop.PetriNets.NullVertexException;
import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.graphics.Arc2DCustom;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.Place2D;
import sk.stuba.fei.oop.graphics.Transition2D;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class GraphicsTransformer {
    private List<Drawable> drawables;
    private PetriNet net;

    public GraphicsTransformer(PetriNet net) {
        this.net = net;
    }


    public List<Drawable> transform(Document doc) throws NullVertexException {

        drawables = new ArrayList<>();

        for (Arc arc : doc.getArc()) {

            if (this.net.getArc((long) arc.getSourceId(), (long) arc.getDestinationId()) instanceof ArcTranstoPl) {

                Arc2DCustom arc2D = new Arc2DCustom(
                        this.net.getArc((long) arc.getSourceId(), (long) arc.getDestinationId()),
                        GimmeMyTrans(arc.getSourceId(), doc).getX() + 16,
                        GimmeMyTrans(arc.getSourceId(), doc).getY() + 16,
                        GimmeMyPlace(arc.getDestinationId(), doc).getX() + 16,
                        GimmeMyPlace(arc.getDestinationId(), doc).getY() + 16
                );

                drawables.add(arc2D);
            } else if (this.net.getArc((long) arc.getSourceId(), (long) arc.getDestinationId()) instanceof ArcPltoTrans) {

                Arc2DCustom arc2D = new Arc2DCustom(
                        this.net.getArc((long) arc.getSourceId(), (long) arc.getDestinationId()),
                        GimmeMyPlace(arc.getSourceId(), doc).getX() + 16,
                        GimmeMyPlace(arc.getSourceId(), doc).getY() + 16,
                        GimmeMyTrans(arc.getDestinationId(), doc).getX() + 16,
                        GimmeMyTrans(arc.getDestinationId(), doc).getY() + 16
                );
                drawables.add(arc2D);
            } else {
                Arc2DCustom arc2D = new Arc2DCustom(
                        this.net.getArc((long) arc.getSourceId(), (long) arc.getDestinationId()),
                        GimmeMyPlace(arc.getSourceId(), doc).getX() + 16,
                        GimmeMyPlace(arc.getSourceId(), doc).getY() + 16,
                        GimmeMyTrans(arc.getDestinationId(), doc).getX() + 16,
                        GimmeMyTrans(arc.getDestinationId(), doc).getY() + 16
                );
                drawables.add(arc2D);
            }
        }

            for (Place place : doc.getPlace()) {
                Place2D place2D = new Place2D(
                        place.getX(),
                        place.getY(),
                        this.net.getPlace(place.getId())
                );
                drawables.add(place2D);
            }
            for (Transition transition : doc.getTransition()) {
                Transition2D transition2D = new Transition2D(
                        transition.getX(),
                        transition.getY(),
                        this.net,
                        this.net.getTransition(transition.getId())
                );
                drawables.add(transition2D);
            }




        return drawables;
    }



        private Place GimmeMyPlace ( short ID, Document doc){
            List<Place> places = doc.getPlace();
            for (Place pl : places) {
                if (pl.getId() == ID) {
                    return pl;
                }
            }
            return null;
        }


        private Transition GimmeMyTrans ( short ID, Document doc){
            List<Transition> transitions = doc.getTransition();
            for (Transition tr : transitions) {
                if (tr.getId() == ID) {
                    return tr;
                }
            }
            return null;


        }

}