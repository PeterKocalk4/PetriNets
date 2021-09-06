package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.PetriNets.Vertex;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {

void draw (Graphics graphics);

void onClick (MouseEvent event);

Vertex getVertex(int index_of_startOrEnd_in_case_of_Arc/* for Arc2DCustom: 1 for start and 2 for end .... for
 getting Vertex of Place2D or Transition2D: any integer u want*/);
}
