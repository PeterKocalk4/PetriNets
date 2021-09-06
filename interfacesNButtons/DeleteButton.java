package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.graphics.NetCanvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteButton extends Button implements MouseListener {
    private NetCanvas canvas;
    private PetriNet net;

    public DeleteButton(NetCanvas nc, PetriNet net) {
        this.canvas = nc;
        this.net = net;
        this.addMouseListener(this);
        this.setLabel("Delete");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.canvas.getMouseListeners() != null){
            for(MouseListener listener : this.canvas.getMouseListeners()){
                this.canvas.removeMouseListener(listener);
            }
        }
        this.canvas.addMouseListener(new DeleteListener(canvas, net));
        System.out.println("Delete");

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
