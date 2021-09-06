package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.*;
import sk.stuba.fei.oop.graphics.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.util.List;

public class ArcListener implements MouseListener{
    private NetCanvas canvas;
    private PetriNet net;
    private Vertex src;
    private Vertex dest;
    private boolean flag = false;
    private int xsrc;
    private int ysrc;
    private int[] positions = new int[4];


    public ArcListener(NetCanvas nc, PetriNet net)  {
        this.canvas = nc;
        this.net = net;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            //System.out.println("Arc");
            if (!flag) {
                //System.out.println("1stclick");
                ysrc = e.getY();
                xsrc = e.getX();
                flag = true;

            } else if (flag) {
                //System.out.println("2ndclick");
                int ydest = e.getY();
                int xdest = e.getX();
                List<Drawable> list = this.canvas.getElementList();
                for (Drawable d : this.canvas.getElementList()) {
                    if (d != null) {
                    if (d.contains(xsrc, ysrc)) {
                        this.src = (d.getVertex(0));
                        if (instanceOf(this.net, src).equals("Place")) {
                            positions[0] = (int) ((Place2D) d).getX();
                            positions[1] = (int) ((Place2D) d).getY();
                        } else {
                            positions[0] = (int) ((Transition2D) d).getX();
                            positions[1] = (int) ((Transition2D) d).getY();
                        }

                        //System.out.println("src jeeee "+instanceOf(this.net, src));
                    }
                    if (d.contains(xdest, ydest)) {
                        this.dest = (d.getVertex(0));
                        if (instanceOf(this.net, dest).equals("Place")) {
                            positions[2] = (int) ((Place2D) d).getX();
                            positions[3] = (int) ((Place2D) d).getY();
                        } else {
                            positions[2] = (int) ((Transition2D) d).getX();
                            positions[3] = (int) ((Transition2D) d).getY();
                        }

                    }
                }
            }//---------------
                    //System.out.println("src je " + src + " dest je " + dest);
                    if (src != null && instanceOf(this.net, src).equals("Place") && dest != null && instanceOf(this.net, dest).equals("Transition")) {
                        sk.stuba.fei.oop.PetriNets.ArcPltoTrans apt = new ArcPltoTrans(1, (Place) src, (Transition) dest);
                        this.net.addArc(apt);
                        Arc2DCustom apt2d = new Arc2DCustom(apt, positions[0] + 16, positions[1] + 16, positions[2] + 16, positions[3] + 16);
                        list.add(apt2d);
                        this.canvas.setElementList(list);
                        src = null;
                        dest = null;
                        canvas.repaint();
                    } else if (src != null && instanceOf(this.net, src).equals("Transition") && dest != null && instanceOf(this.net, dest).equals("Place")) {
                        sk.stuba.fei.oop.PetriNets.ArcTranstoPl atp = new ArcTranstoPl(1, (Transition) src, (Place) dest);
                        this.net.addArc(atp);
                        Arc2DCustom atp2d = new Arc2DCustom(atp, positions[0] + 16, positions[1] + 16, positions[2] + 16, positions[3] + 16);
                        list.add(atp2d);
                        this.canvas.setElementList(list);
                        src = null;
                        dest = null;
                        canvas.repaint();
                    } else {
                        src = null;
                        dest = null;
                        System.out.println("nothing");
                    }
                    flag = false;

            }


                //System.out.println("Place created successfully");

            }catch(NullVertexException error ){
                error.printStackTrace();
            }catch(IllegalArcWeightException err){
                err.printStackTrace();
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

}
