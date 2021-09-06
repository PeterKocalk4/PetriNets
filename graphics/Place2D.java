package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.PetriNets.Place;
import sk.stuba.fei.oop.PetriNets.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;


public class Place2D extends Ellipse2D.Float implements Drawable{

    private sk.stuba.fei.oop.PetriNets.Place place;
    public Place2D(int x, int y, Place place){
        super(x,y,32,32);
        this.place = place;
    }

    @Override
    public void draw(Graphics graphics){
        ((Graphics2D)graphics).setColor(Color.white);
        ((Graphics2D)graphics).fill(this);
        ((Graphics2D)graphics).setColor(Color.black);
        ((Graphics2D)graphics).draw(this);
        Font tr = new Font("TimesRoman", Font.PLAIN, 15);
        graphics.setFont(tr);
        FontMetrics metrics = graphics.getFontMetrics();
        //pocet tokenov
        graphics.drawString(Integer.toString(place.getTokens()), (int)this.getX() + 13 - ((metrics.stringWidth((String.valueOf(place.getTokens()))) -3)/ 2), (int)this.getY() + 22);
        //nazov
        graphics.drawString(place.getName(), (int)this.getX() + 13 - ((metrics.stringWidth(place.getName())-3) / 2), (int)this.getY() + 45);
    }

    @Override
    public void onClick(MouseEvent event){
        if(event.getButton() == MouseEvent.BUTTON1){
            //System.out.println("Clicked btn 1");
            place.setTokens(place.getTokens()+1);
        }else if(event.getButton() == MouseEvent.BUTTON3){
            //System.out.println("Clicked btn 3");
            place.setTokens(place.getTokens()-1);
        }
    }

    @Override
    public Vertex getVertex(int useless_here){return this.place;}

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }
}
