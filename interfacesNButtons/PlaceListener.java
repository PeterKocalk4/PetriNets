package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.PetriNets.Place;
import sk.stuba.fei.oop.PetriNets.Transition;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class PlaceListener implements MouseListener {
    private NetCanvas canvass;
    private PetriNet net;

    public PlaceListener(NetCanvas nc, PetriNet net){
        this.canvass = nc;
        this.net = net;
        //System.out.println("get there");

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int y = e.getY();
        int x = e.getX();
        sk.stuba.fei.oop.PetriNets.Place p = new Place(GenerateID(), "Place", 1);
        p.setX(x);
        p.setY(y);
        this.net.addPlace(p);
        Place2D p2d = new Place2D(x, y, p);
        List<Drawable> list = this.canvass.getElementList();
        list.add(p2d);
        this.canvass.setElementList(list);
        //System.out.println("Place created successfully");
        canvass.repaint();
    }


    private long GenerateID(){
        long ID = 1;
        if(this.net.getTransitions() != null) {
            for (Transition t : this.net.getTransitions()) {
                if (t.getID() >= ID) {
                    ID = t.getID();
                }

            }
        }
        if(this.net.getPlaces() != null){
            for (Place p : this.net.getPlaces()) {
                if (p.getID() >= ID) {
                    ID = p.getID();
                }

            }
        }
        //System.out.println("idcko je "+ID);
        return ID+1;
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
}
