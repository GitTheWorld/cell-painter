package library;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import  java.util.List;
import  java.util.ArrayList;

/**
 * Tastatur Abfangen
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class key implements KeyListener
{

    List<Character> pressed;
    List<Character> released; 

    public key()  {
        this.pressed = new ArrayList<Character>();
        this.released = new ArrayList<Character>();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){System.exit(0);}
        addPressed(e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
        addReleased(e.getKeyChar());
    } 

    private synchronized void addPressed(char in)
    {
        this.pressed.add(in);
    }

    private synchronized void addReleased(char in)
    {
        this.released.add(in);
    }

    public synchronized char getPressed()
    {
        if(!isPressed()){return '\0';}
        char out = this.pressed.get(0);
        this.pressed.remove(0); 
        return out;
    }

    public synchronized boolean isPressed()
    {
        if(this.pressed.size()==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public synchronized char getReleased()
    {
        if(isReleased()){return '\0';}
        char out = this.released.get(0);
        this.released.remove(0); 
        return out;
    }

    public synchronized boolean isReleased()
    {
        if(this.released.size()==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public synchronized void reset()
    {
        this.pressed = new ArrayList<Character>(); 
        this.released = new ArrayList<Character>(); 
    }
}
