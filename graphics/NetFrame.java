package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.PetriNets.IllegalArcWeightException;
import sk.stuba.fei.oop.PetriNets.NullVertexException;
import sk.stuba.fei.oop.PetriNets.PetriNet;
import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.generated.GraphicsTransformer;
import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.interfacesNButtons.*;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class NetFrame extends Frame implements ActionListener{
private NetCanvas canvas;
private PetriNet net = new PetriNet();

public NetFrame() throws HeadlessException{
    setSize(1800,800);

    this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            NetFrame.this.dispose();
        }
    });
    //Panel panel=new Panel();
    this.setLayout(new BorderLayout());

    canvas = new NetCanvas();
    PlaceButton placeBtn = new PlaceButton(canvas, net);
    StartButton startBtn = new StartButton(canvas);
    TransitionButton transBtn = new TransitionButton(canvas, net);
    SaveButton sBtn = new SaveButton(net);
    ArcButton arcBtn = new ArcButton(canvas, net);
    DeleteButton dBtn = new DeleteButton(canvas, net);

    JButton b1 = new JButton();
    JPanel panel =new JPanel();
    b1.setText("Load XML file");
    b1.addActionListener(this);
    panel.add(b1);

    panel.add(placeBtn);
    panel.add(transBtn);
    panel.add(arcBtn);
    panel.add(startBtn);
    panel.add(dBtn);
    panel.add(sBtn);

    this.add(panel, BorderLayout.PAGE_START);
    this.add(canvas, BorderLayout.CENTER);
    this.setVisible(true);
   // this.setVisible(true);

}

    @Override
    public void actionPerformed(ActionEvent e) {
       // System.out.println("nothing");
        FileDialog OpDialog = new FileDialog(this, "Open",FileDialog.LOAD);
        OpDialog.setVisible(true);
        if(OpDialog.getFile() != null){
            try{
                Importer importer = new Importer();
                Document doc = importer.importFile(OpDialog.getDirectory()+OpDialog.getFile());
                net = importer.importNet(doc);
                GraphicsTransformer GT = new GraphicsTransformer(net);
                this.canvas.setElementList(GT.transform(doc));
                //this.add(canvas, BorderLayout.CENTER);

                //this.setVisible(true);
                //---------------------------------------//
                this.remove(this.getComponent(0));
                //System.out.println("Component 0 je "+this.getComponent(0));
                PlaceButton placeBtn = new PlaceButton(canvas, net);
                StartButton startBtn = new StartButton(canvas);
                TransitionButton transBtn = new TransitionButton(canvas, net);
                ArcButton arcBtn = new ArcButton(canvas, net);
                DeleteButton dBtn = new DeleteButton(canvas, net);
                SaveButton sBtn = new SaveButton(net);
                JButton b1 = new JButton();
                JPanel panel =new JPanel();
                b1.setText("Load XML file");
                b1.addActionListener(this);
                panel.add(b1);

                panel.add(placeBtn);
                panel.add(transBtn);
                panel.add(arcBtn);
                panel.add(startBtn);
                panel.add(dBtn);
                panel.add(sBtn);

                this.add(panel, BorderLayout.PAGE_START);
                this.add(canvas, BorderLayout.CENTER);
                this.setVisible(true);
                //---------------------------------------//

            }catch (IllegalArcWeightException exception) {
                exception.printStackTrace();
            }
            catch (NullVertexException excc){
                excc.printStackTrace();
            }
            catch(FileNotFoundException excp){
                excp.printStackTrace();
            }
            catch(JAXBException x){
                x.printStackTrace();
            }
        }

    }
}
