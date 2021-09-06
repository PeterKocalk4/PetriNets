package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.graphics.NetCanvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButton  extends Button implements MouseListener{

    NetCanvas canvas;


    public StartButton(NetCanvas nc) {
        this.canvas = nc;
        this.addMouseListener(this);
        this.setLabel("Run Petri Net");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.canvas.getMouseListeners() != null){
            for(MouseListener listener : this.canvas.getMouseListeners()){
                this.canvas.removeMouseListener(listener);
            }
        }
        this.canvas.addMouseListener(new StartListener(canvas));
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
