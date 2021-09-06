package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.generated.GraphicsTransformer;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.interfacesNButtons.PlaceListener;

import java.util.List;
import java.util.ArrayList;

public class NetCanvas extends Canvas implements MouseListener {


    private List<Drawable> elementList;

    public NetCanvas() {
        this.elementList = new ArrayList<>();
        addMouseListener(this);
        this.setSize(1500, 1100);
        this.setBackground(Color.white);
    }

    public void setElementList(List<Drawable> list) {
        this.elementList = list;
    }
    public List<Drawable> getElementList(){return this.elementList;}


    @Override
    public void paint(Graphics g){
        for(Drawable element: elementList) {
            if(element != null){
            element.draw(g);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        //System.out.println("Som tu, ci?");

        //System.out.println("element list je: "+elementList);
       /* for(Drawable element: elementList) {
            if(element.contains(e.getX(), e.getY())) {
                element.onClick(e);
                repaint();
            }
        }*/
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
}
