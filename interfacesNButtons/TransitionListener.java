package sk.stuba.fei.oop.interfacesNButtons;
import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.PetriNets.Place;
import sk.stuba.fei.oop.PetriNets.Transition;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;
import sk.stuba.fei.oop.graphics.Transition2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TransitionListener implements MouseListener {
    private NetCanvas canvas;
    private PetriNet net;

    public TransitionListener(NetCanvas nc, PetriNet net){
        this.canvas = nc;
        this.net = net;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("transition");
        int y = e.getY();
        int x = e.getX();

        sk.stuba.fei.oop.PetriNets.Transition trans = new Transition(GenerateID(), "Transition");
        this.net.addTrans(trans);
        trans.setX(x);
        trans.setY(y);
        Transition2D t2d = new Transition2D(x, y, net, trans);
        List<Drawable> list = this.canvas.getElementList();
        list.add(t2d);
        this.canvas.setElementList(list);
        //System.out.println("Place created successfully?");
        canvas.repaint();
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
   // System.out.println("idcko je "+ID+1);
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
