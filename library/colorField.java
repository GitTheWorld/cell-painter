package library;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
/**
 * GUI - Klasse zum einfachen Lernen von Java
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class colorField extends field {

    // State of the gui //
    private Color myColor[][];
    private Color background;
    private boolean border;

    public colorField(int x, int y)
    {
        pos position = new pos(x,y);
        this.background = Color.white;
        this.border = true;
        if (position.x()<1){position.x(1);}
        if (position.y()<1){position.y(1);}
        this.init(position);
        this.reset();
    }

    public colorField(pos position, boolean border)  {
        this.background = Color.white;
        this.border = border;
        if (position.x()<1){position.x(1);}
        if (position.y()<1){position.y(1);}
        this.init(position);
        this.reset();
    }

    public colorField(pos position, boolean border, Color background)  {
        this.background = background;
        this.border = border;
        if (position.x()<1){position.x(1);}
        if (position.y()<1){position.y(1);}
        this.init(position);
        this.reset();
    }

    public synchronized void paintBuffer(Graphics2D ga)
    {
        for(int i=0;i<this.fieldSize.x();i++)
        {
            for(int p=0;p<this.fieldSize.y();p++)
            {
                this.paintOne(i,p, ga);
            }
        }
    }

    // Setze Verschiebung und Form der Kästchen
    public synchronized void genFieldPlusOne()
    {
        Dimension actualSize = this.getContentPane().getSize();
        int x = actualSize.width/this.fieldSize.x();
        int y = actualSize.height/this.fieldSize.y();

        if(y<x){x=y;}    

        // Es wird nur Quadrate geben!!!
        this.sizeOne.x(x);
        this.sizeOne.y(x);

        this.plus.x((actualSize.width-x*this.fieldSize.x())/2);
        this.plus.y((actualSize.height-x*this.fieldSize.y())/2);
    }

    public void paintOne(int x, int y)
    {
        paintOne(new pos(x,y),(Graphics2D)this.getContentPane().getGraphics());    
    }

    public void paintOne(pos position)
    {
        paintOne(position,(Graphics2D)this.getContentPane().getGraphics());    
    }

    public void paintOne(int x, int y,Graphics2D ga)
    {
        paintOne(new pos(x,y),ga);    
    }

    public void paintOne(pos position,Graphics2D ga)
    {
        if(!this.isInField(position.x(),position.y())){return;}

        if(this.border){
            ga.setPaint(Color.gray); 
            ga.drawRect(position.x()*this.sizeOne.x()+this.plus.x(),position.y()*this.sizeOne.y()+this.plus.y(),this.sizeOne.x()-1,this.sizeOne.y()-1);
            ga.setPaint(this.myColor[position.x()][position.y()]); 
            ga.fillRect( position.x()*this.sizeOne.x()+this.plus.x()+1,position.y()*this.sizeOne.y()+this.plus.y()+1,this.sizeOne.x()-2,this.sizeOne.y()-2);
        }else{
            ga.setPaint(this.myColor[position.x()][position.y()]); 
            ga.fillRect( position.x()*this.sizeOne.x()+this.plus.x(),position.y()*this.sizeOne.y()+this.plus.y(),this.sizeOne.x(),this.sizeOne.y());
        }
    }

    // START OF SET COLOR //

    public synchronized boolean setBlack(int x, int y)
    {
        return setBlack(new pos(x,y));
    }

    public synchronized boolean setBlack(pos position)
    {
        if(!this.isInField(position.x(),position.y())){return false;}
        if(this.myColor[position.x()][position.y()]!=Color.black)
        {
            this.myColor[position.x()][position.y()]=Color.black;
            this.paintOne(position);
        }
        return true;
    }

    public synchronized boolean setWhite(int x, int y)
    {
        return this.setWhite(new pos(x,y));
    }

    public synchronized boolean setWhite(pos position)
    {
        if(!this.isInField(position.x(),position.y())){return false;}
        if(this.myColor[position.x()][position.y()]!=Color.white)
        {
            this.myColor[position.x()][position.y()]=Color.white;
            this.paintOne(position);
        }
        return true;
    }

    public synchronized boolean setRed(int x, int y)
    {
        return this.setRed(new pos(x,y));
    }

    public synchronized boolean setRed(pos position)
    {
        if(!this.isInField(position.x(),position.y())){return false;}
        if(this.myColor[position.x()][position.y()]!=Color.red)
        {
            this.myColor[position.x()][position.y()]=Color.red;
            this.paintOne(position);
        }
        return true;
    }

    public synchronized boolean setGreen(int x, int y)
    {
        return this.setGreen(new pos(x,y));
    }

    public synchronized boolean setGreen(pos position)
    {
        if(!this.isInField(position.x(),position.y())){return false;}
        if(this.myColor[position.x()][position.y()]!=Color.green)
        {
            this.myColor[position.x()][position.y()]=Color.green;
            this.paintOne(position);
        }
        return true;
    }

    public synchronized boolean setColor(Color color,int x, int y)
    {
        return this.setColor(color, new pos(x,y));
    }

    public synchronized boolean setColor(Color color, pos position)
    {
        if(!this.isInField(position.x(),position.y())){return false;}
        if(this.myColor[position.x()][position.y()]!=color)
        {
            this.myColor[position.x()][position.y()]=color;
            this.paintOne(position);
        }
        return true;
    }

    // END OF SET COLOR //
    // START OF IS COLOR //

    public synchronized boolean isWhite(int x, int y)
    {
        return this.isWhite(new pos(x,y));
    }

    public synchronized boolean isWhite(pos position)
    {
        if(!this.isInField(position.x(),position.y()))
        {
        if(background==Color.white){return true;}else{return false;}
        }
        if(this.myColor[position.x()][position.y()]==Color.white){return true;}
        return false;
    }

    public boolean isBlack(int x, int y)
    {
        return this.isBlack(new pos(x,y));
    }

    public boolean isBlack(pos position)
    {
        if(!this.isInField(position.x(),position.y()))
        {
        if(background==Color.black){return true;}else{return false;}
        }
        if(this.myColor[position.x()][position.y()]==Color.black){return true;}
        return false;
    }

    public boolean isRed(int x, int y)
    {
        return this.isRed(new pos(x,y));
    }

    public boolean isRed(pos position)
    {
        if(!this.isInField(position.x(),position.y()))
        {
        if(background==Color.red){return true;}else{return false;}
        }
        if(this.myColor[position.x()][position.y()]==Color.red){return true;}
        return false;
    }

    public boolean isGreen(int x, int y)
    {
        return this.isGreen(new pos(x,y));
    }

    public boolean isGreen(pos position)
    {
        if(!this.isInField(position.x(),position.y()))
        {
        if(background==Color.green){return true;}else{return false;}
        }
        if(this.myColor[position.x()][position.y()]==Color.green){return true;}
        return false;
    }

    public boolean isColor(Color color, int x, int y)
    {
        return this.isColor(color,new pos(x,y));
    }

    public boolean isColor(Color color, pos position)
    {
        if(!this.isInField(position.x(),position.y()))
        {
        if(background==color){return true;}else{return false;}
        }
        if(this.myColor[position.x()][position.y()]==color){return true;}
        return false;
    }

    // END OF IS COLOR //

    public synchronized void reset()
    {
        this.myColor = new Color[this.fieldSize.x()][this.fieldSize.y()];

        for(int i=0;i<this.fieldSize.x();i++)
        {
            for(int p=0;p<this.fieldSize.y();p++)
            {
                this.myColor[i][p]=this.background;
            }
        }

        if(this.bufferImage!=null){
            this.resetBuffer();
        }
        this.repaint();
    }

    public synchronized void setBorder(boolean border)
    {
        this.border = border;
        this.repaint();
    }

    public boolean isBorder()
    {
        return this.border;
    }

    public synchronized void setBackground(Color background)
    {
        this.background = background;
    }

    public Color getBackground()
    {
        return this.background;
    }

}