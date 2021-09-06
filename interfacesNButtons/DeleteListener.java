package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.*;
import sk.stuba.fei.oop.graphics.Arc2DCustom;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteListener implements MouseListener {
    private NetCanvas canvas;
    private PetriNet net;
    private List<Drawable> list = new ArrayList<>();

    public DeleteListener(NetCanvas nc, PetriNet net){
        this.canvas = nc;
         this.net = net;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int y = e.getY();
        int x = e.getX();
        Rectangle2D rectie= new Rectangle(x-3, y-3, 6, 6);
        list = this.canvas.getElementList();
        //Drawable  drawable  = list.get(0);
        for(int i=0; i<list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).contains(x, y)) {

                    if (instanceOf(net, list.get(i).getVertex(1)).equals("Place")) {
                        this.net.deletePlace(((Place) (list.get(i).getVertex(0))));
                        //System.out.println("This is place");
                        removeOtherAffectedStuff(list.get(i));
                        list.set(i, null);

                    } else if (instanceOf(net, list.get(i).getVertex(0)).equals("Transition")) {
                        this.net.deleteTransition(((Transition) (list.get(i).getVertex(1))));
                        //System.out.println("This is transition");
                        removeOtherAffectedStuff(list.get(i));
                        list.set(i, null);

                    } else {
                    }
                    this.canvas.setElementList(list);
                    canvas.repaint();
                    break;
                }else if(list.get(i) instanceof Arc2DCustom){
                    int counter = 0;

                    for(int index=0; index<list.size(); index++) {
                        if(list.get(index)!=null){if(list.get(index).contains(x, y)){counter++;}}
                    }

                    if(list.get(i).intersects(rectie) && counter == 0){
                         net.deleteArc(((Arc2DCustom) list.get(i)).getArc());
                         list.set(i, null);
                         this.canvas.setElementList(list);
                         canvas.repaint();
                         break;


                    }

                }

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public String instanceOf(PetriNet net, Vertex vertex){
        for(Place place:net.getPlaces()){
            if(place.getID() == vertex.getID()){
                return"Place";
            }
        }
        for(Transition trans:net.getTransitions()){
            if(trans.getID() == vertex.getID());
            return "Transition";
        }
        return "Idk what is this";
    }

    public void removeOtherAffectedStuff(Drawable d){
        List <Drawable> lisst = this.canvas.getElementList();
        for(int i = 0; i<lisst.size();i++){
            if(lisst.get(i) instanceof Arc2DCustom){
                if(((Arc2DCustom)lisst.get(i)).getArc().getEnd() == d.getVertex(0) ||((Arc2DCustom)lisst.get(i)).getArc().getStart() == d.getVertex(0)  ){
                    lisst.set(i, null);
                }
            }
        }
        this.canvas.setElementList(lisst);

    }

}
