package sk.stuba.fei.oop.interfacesNButtons;

import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.generated.Exporter;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class SaveButton extends Button implements MouseListener {
    private PetriNet net;
    public SaveButton(PetriNet net) {
        this.net = net;
        this.addMouseListener(this);
        this.setLabel("Save");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Exporter exporter = new Exporter();
        FileDialog OpDialog = new FileDialog((Frame)this.getParent().getParent(), "Save to",FileDialog.LOAD);
        OpDialog.setVisible(true);
        OpDialog.setFile(OpDialog.getFile()+".xml");
        if(OpDialog.getFile() != null){
            try{
                exporter.exportToXml(net, new File(OpDialog.getDirectory()+OpDialog.getFile()));
            }catch (Exception eeerrr){
                eeerrr.printStackTrace();
            }
        }
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
