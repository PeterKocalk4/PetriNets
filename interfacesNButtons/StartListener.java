package sk.stuba.fei.oop.interfacesNButtons;


import sk.stuba.fei.oop.PetriNets.Place;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class StartListener implements MouseListener{
    NetCanvas canvas;
    public StartListener(NetCanvas nc){
        this.canvas=nc;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        for(Drawable element:canvas.getElementList()) {
            if(element != null) {
                if (element.contains(e.getX(), e.getY())) {
                    element.onClick(e);
                    canvas.repaint();
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
}
