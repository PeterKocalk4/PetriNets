package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.generated.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

public class Exporter {
    private int useless;


    public void exportToXml(PetriNet net, File file){

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(PetriNet.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(net, file);
            System.out.println("Saved as xml");

        } catch (JAXBException ignored) {
            ignored.printStackTrace();
        }
    }
}


