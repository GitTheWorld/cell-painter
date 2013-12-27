package library;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;

import  java.util.List;
import  java.util.ArrayList;

/**
 * Mouse abfragen
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class mouse implements MouseListener, MouseMotionListener
{
    private List<pos> pressed;
    private List<pos> released;
    private List<pos> moved;
    private List<pos> dragged;
    private field mother;

    // Last Position and Status for Motion Listener
    private pos lastPos;
    private boolean isMoved;

    public mouse(field mother)
    {
        this.mother=mother;
        this.reset();
    }

    // Mouse Listener
    public void mousePressed(MouseEvent e) {
        addPressed(this.mother.getPos(e.getX(),e.getY()));
    }

    public void mouseReleased(MouseEvent e) {
        addReleased(this.mother.getPos(e.getX(),e.getY()));
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }    
    // END
    // Mouse Motion Listener
    public void mouseMoved(MouseEvent e) {
        addMoved(this.mother.getPos(e.getX(),e.getY()));
    }

    public void mouseDragged(MouseEvent e) {
        addDragged(this.mother.getPos(e.getX(),e.getY()));
    }
    // END

    private synchronized void addPressed(pos position)
    {
        this.pressed.add(position);
        this.dragged.add(position);
        this.lastPos=position;
    }    

    private synchronized void addReleased(pos position)
    {
        this.released.add(position);
        this.moved.add(position);
        this.lastPos=position;
    }

    private synchronized void addMoved(pos position)
    {
        if(!position.equals(lastPos))
        {
            this.moved.add(position);
            this.lastPos=position;
        }
    }    

    private synchronized void addDragged(pos position)
    {
        if(!position.equals(lastPos))
        {
            this.dragged.add(position);
            this.lastPos=position;
        }
    }

    public synchronized pos getPressed()
    {
        if(!isPressed()){return new pos(-1,-1);}
        pos out = this.pressed.get(0);
        this.pressed.remove(0); 
        return out;
    }

    public synchronized boolean isPressed()
    {
        if(this.pressed.size()==0)
        {
            return false; 
        }
        return true;
    }

    public synchronized pos getReleased()
    {
        if(!isReleased()){return new pos(-1,-1);}
        pos out = this.released.get(0);
        this.released.remove(0); 
        return out;
    }

    public synchronized boolean isReleased()
    {
        if(this.released.size()==0)
        {
            return false; 
        }
        return true;
    }

    public synchronized pos getMoved()
    {
        if(!isMoved()){return new pos(-1,-1);}
        pos out = this.moved.get(0);
        this.moved.remove(0); 
        return out;
    }

    public synchronized boolean isMoved()
    {
        if(this.moved.size()==0)
        {
            return false; 
        }
        return true;
    }

    public synchronized pos getDragged()
    {
        if(!isDragged()){return new pos(-1,-1);}
        pos out = this.dragged.get(0);
        this.dragged.remove(0); 
        return out;
    }

    public synchronized boolean isDragged()
    {
        if(this.dragged.size()==0)
        {
            return false; 
        }
        return true;
    }

    public synchronized void reset()
    {
        this.pressed = new ArrayList<pos>(); 
        this.released = new ArrayList<pos>(); 
        this.moved = new ArrayList<pos>(); 
        this.dragged = new ArrayList<pos>(); 
        this.lastPos = new pos(-1,-1);
    }

}
