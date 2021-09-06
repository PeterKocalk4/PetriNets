package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.graphics.NetCanvas;

import javax.swing.*;
import java.awt.Button;
import java.awt.*;
import java.awt.event.*;
import sk.stuba.fei.oop.interfacesNButtons.PlaceListener;

public class PlaceButton extends Button implements MouseListener{

    NetCanvas canvas;
    private PetriNet net;


    public PlaceButton(NetCanvas nc, PetriNet net){
        this.canvas = nc;
        this.net=net;
        this.addMouseListener(this);
        this.setLabel("Add place");
       /* for(MouseListener listener : this.canvas.getMouseListeners()){
            this.canvas.removeMouseListener(listener);
        }
        this.canvas.addMouseListener(new PlaceListener());

        /*this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            }
        });*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.canvas.getMouseListeners() != null){
        for(MouseListener listener : this.canvas.getMouseListeners()){
            this.canvas.removeMouseListener(listener);
        }
        }
        this.canvas.addMouseListener(new PlaceListener(canvas, net));
        //System.out.println("Mouse Listener na canvase je "+canvas.getMouseListeners());

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
