package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.graphics.NetCanvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TransitionButton extends Button implements MouseListener {
    private NetCanvas canvas;
    private PetriNet net;

    public TransitionButton(NetCanvas nc, PetriNet net){
        this.net = net;
        this.canvas = nc;
        this.addMouseListener(this);
        this.setLabel("Add Transition");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.canvas.getMouseListeners() != null){
            for(MouseListener listener : this.canvas.getMouseListeners()){
                this.canvas.removeMouseListener(listener);
            }
        }
        this.canvas.addMouseListener(new TransitionListener(canvas, net));
        //System.out.println("Mouse Listener na canvase je "+canvas.getMouseListeners());

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
