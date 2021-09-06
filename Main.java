package sk.stuba.fei.oop;

import sk.stuba.fei.oop.PetriNets.IllegalArcWeightException;
import sk.stuba.fei.oop.PetriNets.NullVertexException;
import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.graphics.NetFrame;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {
        //  System.out.println("Hello World!");
        try {
            //MyNet.showState();
            //MyNet.showNetTransitions();
            //MyNet.showArcs();

            NetFrame frame = new NetFrame();

        }catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}

