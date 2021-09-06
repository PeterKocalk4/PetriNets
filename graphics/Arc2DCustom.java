package sk.stuba.fei.oop.graphics;
import sk.stuba.fei.oop.PetriNets.Arc;
import sk.stuba.fei.oop.PetriNets.IllegalArcWeightException;
import sk.stuba.fei.oop.PetriNets.ResetArc;
import sk.stuba.fei.oop.PetriNets.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Arc2DCustom extends java.awt.geom.Line2D.Float implements Drawable{

    private sk.stuba.fei.oop.PetriNets.Arc arc;
    private sk.stuba.fei.oop.PetriNets.PetriNet net;

    public Arc2DCustom (sk.stuba.fei.oop.PetriNets.Arc arc, int x, int y, int x2, int y2){
        super(x,y,x2,y2);
        this.arc = arc;
    }
    @Override
    public void draw(Graphics graphics) {
        ((Graphics2D) graphics).draw(this);
        AffineTransform affineTransform = new AffineTransform();
        AffineTransform oldTransform = ((Graphics2D)graphics).getTransform();
        Polygon arrow = new Polygon();
        arrow.addPoint(0,5);
        arrow.addPoint(-5,-5);
        arrow.addPoint(5,-5);
        Polygon nextArrowForResetArc=new Polygon();
        nextArrowForResetArc.addPoint(0,-5);
        nextArrowForResetArc.addPoint(-5,-15);
        nextArrowForResetArc.addPoint(5,-15);
       // affineTransform.setToIdentity();
        double angle = Math.atan2(this.getY2()-this.getY1(), this.getX2()-this.getX1());
        int x=(int)(20*cos(angle));
        int y=(int)(20*sin(angle));

        affineTransform.translate(this.getX2()-x, this.getY2()-y);
        affineTransform.rotate((angle-Math.PI/2d));

        //Point p=findIntersection(this.x2,this.y2,this.x1,this.y1);
        ((Graphics2D)graphics).setTransform(affineTransform);
        ((Graphics2D)graphics).fill(arrow);
        if(this.arc.getWeight()==0){
            ((Graphics2D)graphics).fill(nextArrowForResetArc);
            ((Graphics2D)graphics).setTransform(oldTransform);
        }else{
            ((Graphics2D)graphics).setTransform(oldTransform);
            int xstr = (int)(Math.abs((this.getX2()+this.getX1())/2));
            int ystr=(int)(Math.abs((this.getY2()+this.getY1())/2));
            graphics.drawString(Integer.toString(this.arc.getWeight()),xstr, ystr);
        }
        //System.out.println("Moj bod by mal byt tento, ale urcite nebude "+p);


    }
    private Point findIntersection(double x1,double y1,double x2,double y2){
        x1=x1-16;
        y1=y1-16;

        Point point = new Point();
        for(int i=0; i!=32; i++){
            if(this.intersectsLine(x1,y1, x1, (y1+i))){
                point = new Point((int)x1, (int)(y1+i));
                return point;
            }
        }

        for(int i=1; i!=32; i++){

            if(this.intersectsLine((x1+32), y1, (x1+32), (y1+i))){
                point = new Point((int)(x1+32), (int)(y1+i));
                return point;
            }
        }

        for(int i=1; i!=32; i++){

            if(this.intersectsLine(x1,(y1+32), (x1+i), (y1+32))){
                point = new Point((int)(x1+i), (int)(y1+32));
                return point;
            }
        }

        for(int i=1; i!=32; i++){

            if(this.intersectsLine(x1,y1,(x1+i), y1)){
                point = new Point((int)(x1+i), (int)(y1));
                return point;
            }
        }
        return null;
    }







    /*public List<Point> calculate(double x1,double y1,double x2,double y2){
        /*double degrees = Math.atan((x2-x1)/(y2-y1));
        return degrees;
        List<Point> points = new ArrayList<>();
        //List<Point> pointsReady = new ArrayList<>();
        double m = (y1-y2)/(x1-x2);
        double b = y2 - (m*x2);
        //y=mx+b
        x1=x1-16;
        y1=y1-16;

        for(int i=1; i!=32; i++){

         if(y1+i <= ((m*x1)+b+5) && y1+i >= ((m*x1)+b-5)){
                Point p=new Point((int)x1,(int)(y1+i));
                points.add(p);
            }
        }



        for(int i=1; i!=32; i++){

            if(y1+i<=((m*(x1+32))+b+5) && y1+i>=((m*(x1+32))+b-5)){
                Point p=new Point((int)(x1+32),(int)(y1+i));
                points.add(p);
            }
        }



        for(int i=1; i!=32; i++){

            if(y1<=((m*(x1+i))+b+5) &&y1>=((m*(x1+i))+b-5)){
                Point p=new Point((int)(x1+i),(int)y1);
                points.add(p);
            }
        }


        for(int i=1; i!=32; i++){
            //117 209 --->
            //149 241

           //System.out.println("tady to je:" + (y1+32) +" a tu to druhe: "+ ((m*(x1+i))+b+5));
            if(y1+32<=((m*(x1+i))+b+5) && y1+32>=((m*(x1+i))+b-5)){
                Point p=new Point((int)(x1+i),(int)(y1+32));
                points.add(p);
            }
        }



        return points;
    }


    public Point findPoint(List<Point> points){
        Point actualPoint = new Point((int)this.getX2(), (int)this.getY2());
        Point srcPoint = new Point((int)this.getX1(), (int)this.getY1());

        for(Point p:points){
            //System.out.println("pdistancesrc" + p.distance(srcPoint));
            //System.out.println("actualpdistancesrc" + p.distance(srcPoint));
            if(p.distance(srcPoint)<= actualPoint.distance(srcPoint)){
                actualPoint=p;
            }
        }
        return actualPoint;
    }*/

    @Override
    public void onClick(MouseEvent event) {
       /* Rectangle2D rect = new Rectangle(event.getX()-3, event.getY()-3,6,6);
        try {
            if (event.getButton() == MouseEvent.BUTTON1 && rect.intersectsLine(this)) {
                System.out.println("Clicked btn 1");
                arc.setWeight(arc.getWeight() + 1);

            } else if (event.getButton() == MouseEvent.BUTTON3 && rect.intersectsLine(this)) {
                System.out.println("Clicked btn 3");
                arc.setWeight(arc.getWeight() - 1);
            }
        }
        catch(IllegalArcWeightException error){
            error.printStackTrace();
        }*/

    }

    @Override
    public Vertex getVertex(int not_useless_here) {
        if(not_useless_here == 1){
        return this.arc.getStart();
        }
        else if(not_useless_here == 2){
            return this.arc.getEnd();
        }else{
            return null;
        }

    }

    public Arc getArc(){
        return this.arc;
    }
}
