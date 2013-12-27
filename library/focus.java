package library;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

class focus implements FocusListener {

public void focusGained(FocusEvent fe) {
    fe.getComponent().repaint(); // Fix for Windows
}

public void focusLost(FocusEvent fe){
}       

}