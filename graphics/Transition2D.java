package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.PetriNets.Transition;
import sk.stuba.fei.oop.PetriNets.Vertex;

import java.awt.*;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Drawable {

    private sk.stuba.fei.oop.PetriNets.Transition trans;
    private sk.stuba.fei.oop.PetriNets.PetriNet net;

    public Transition2D(int x, int y, PetriNet net, sk.stuba.fei.oop.PetriNets.Transition trans){
        super(x,y,32,32);
        this.trans = trans;
        this.net = net;

    }
    @Override
    public void draw(Graphics graphics) {
        ((Graphics2D) graphics).setColor(Color.red);
        ((Graphics2D) graphics).fill(this);
        ((Graphics2D) graphics).setColor(Color.black);
        ((Graphics2D) graphics).draw(this);

        if(net.isExecutableGraphics((int)trans.getID())){
            ((Graphics2D) graphics).setColor(Color.green);
            ((Graphics2D) graphics).fill(this);
            ((Graphics2D) graphics).setColor(Color.black);
            ((Graphics2D) graphics).draw(this);
        }

        Font tr = new Font("TimesRoman", Font.PLAIN, 15);
        graphics.setFont(tr);
        FontMetrics metrics = graphics.getFontMetrics();
        graphics.drawString(trans.getName(), (int)this.getX() + 13 - ((metrics.stringWidth(trans.getName())-3) / 2), (int)this.getY() + 47);
    }

    @Override
    public void onClick(MouseEvent event) {
        int a = (int)this.trans.getId();
        this.net.fire(a);
        System.out.println("Id je: "+a);
    }

    @Override
    public Vertex getVertex(int useless_here){return this.trans;}
}
