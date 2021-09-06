package sk.stuba.fei.oop.PetriNets;

import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.generated.Document;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
      //  System.out.println("Hello World!");
        try {

        /*PetriNet MyNet= new PetriNet();

        Place p1 = new Place(1, "p1", 0);
        Place p2 = new Place(2, "p2", 0);
        Place p3 = new Place(3, "p3", 1);
        Place p4 = new Place(4, "p4", 1);
        Place p5 = new Place(5, "p5", 5);
        Place p6 = new Place(6, "p6", 0);
        Place p7 = new Place(7, "p7", 0);
        Transition t1 = new Transition(1, "t1");
        Transition t2 = new Transition(2, "t2");
        Transition t3 = new Transition(3, "t3");
        Transition t4 = new Transition(4, "t4");
        Transition t5 = new Transition(5, "t5");
        ArcTranstoPl Atp1= new ArcTranstoPl(5,t2,p1);
        ArcTranstoPl Atp2= new ArcTranstoPl(2,t4,p3);
        ArcTranstoPl Atp3= new ArcTranstoPl(1,t5,p6);
        ArcTranstoPl Atp4= new ArcTranstoPl(1,t5,p7);
        ArcPltoTrans Apt1 = new ArcPltoTrans(1,p2,t3);
        ArcPltoTrans Apt2 = new ArcPltoTrans(1,p3,t4);
        ArcPltoTrans Apt3 = new ArcPltoTrans(1,p4,t5);
        ResetArc R1 = new ResetArc(p5,t5);
            MyNet.addPlace(p1);
            MyNet.addPlace(p2);
            MyNet.addPlace(p3);
            MyNet.addPlace(p4);
            MyNet.addPlace(p5);
            MyNet.addPlace(p6);
            MyNet.addPlace(p7);
            MyNet.addTrans(t1);
            MyNet.addTrans(t2);
            MyNet.addTrans(t3);
            MyNet.addTrans(t4);
            MyNet.addTrans(t5);
            MyNet.addArc(Atp1);
            MyNet.addArc(Atp2);
            MyNet.addArc(Atp3);
            MyNet.addArc(Atp4);
            MyNet.addArc(Apt1);
            MyNet.addArc(Apt2);
            MyNet.addArc(Apt3);
            MyNet.addArc(R1);


       // MyNet.showNetTransitions();

        MyNet.fire(1);
        MyNet.fire(2);
        MyNet.fire(3);
        MyNet.fire(4);
        //MyNet.fire(4);
        MyNet.fire(5);*/
        Importer importer = new Importer();
        Document doc = importer.importFile("src\\main\\resources\\insurance_demo.xml");
        PetriNet MyNet = importer.importNet(doc);

        //MyNet.showState();
       // MyNet.showNetTransitions();
            MyNet.showArcs();

        }catch (IllegalArcWeightException exception) {
            exception.printStackTrace();
        }
        catch (NullVertexException e){
            e.printStackTrace();
        }
        catch(FileNotFoundException excp){
            excp.printStackTrace();
        }
        catch(JAXBException x){
            x.printStackTrace();
        }


    }
}
