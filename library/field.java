package library;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;

/**
 * GUI - Abstrakte Klasse zum erzeugen eines Feldes
 * 
 * @author Marcel Link
 * @version 0.1
 */
public abstract class field extends JFrame{

    // SizeOfField
    protected pos fieldSize;
    protected pos sizeOne;
    protected pos plus;
    
    // Event-Listener //
    public key key;
    public mouse mouse;
    public focus focus;

    // Buffer Implementation //
    protected int bufferWidth;
    protected int bufferHeight;
    protected Image bufferImage;
    protected Graphics bufferGraphics;

    protected void init(pos fieldSize)
    {
        this.fieldSize = fieldSize;
        this.sizeOne = new pos(-1,-1);
        this.plus = new pos(-1,-1);   
        this.setSize(500, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.reset();
                
        this.key = new key();
        this.addKeyListener(this.key);

        this.mouse = new mouse(this);
        this.getContentPane().addMouseListener(this.mouse);
        this.getContentPane().addMouseMotionListener(this.mouse);

        this.focus = new focus();
        this.addFocusListener(this.focus);

        this.setVisible(true);
    }

    public void paint(Graphics g){
        super.paintComponents( g );
        g=this.getContentPane().getGraphics();

        if(this.bufferWidth!=this.getContentPane().getSize().width || 
        this.bufferHeight!=this.getContentPane().getSize().height || 
        this.bufferImage==null || this.bufferGraphics==null)
        {
            this.resetBuffer();
        }

        if(this.bufferGraphics!=null){
            this.bufferGraphics.clearRect(0,0,bufferWidth,bufferHeight);
            this.paintBuffer((Graphics2D)bufferGraphics);
            g.drawImage(bufferImage,0,0,this);
        }

    }

    public abstract void paintBuffer(Graphics2D ga);
    
    public boolean isInField(int x, int y)
    {
        return isInField(new pos(x,y));
    }

    protected boolean isInField(pos position)
    {
        if(position.x()<this.fieldSize.x() && position.x()>=0 && position.y()<this.fieldSize.y() && position.y()>=0){return true;}
        return false;
    }

    public void setFieldSize(int x, int y)
    {
        this.setFieldSize(new pos(x,y));
    }
    
    public void setFieldSize(pos fieldSize)
    {
        this.fieldSize = fieldSize;
    }
    
    public pos getFieldSize()
    {
        return this.fieldSize;
    }
    
    public pos getSizeOne()
    {
        return this.sizeOne;
    }
    
    public pos getPlus()
    {
        return this.plus;
    }
    
    public abstract void genFieldPlusOne();

    public abstract void reset();
    
    public pos getPos(int x, int y)
    {
        return getPos(new pos(x,y));
    }
    
    public pos getPos(pos position)
    {

        if(position.x()<this.plus.x() || position.x()>this.bufferWidth-this.plus.x() || position.y()<this.plus.y() || position.y()>this.bufferHeight-this.plus.y())
        {
            return new pos(-1,-1);
        } 
        return new pos((position.x()-this.plus.x())/this.sizeOne.x(),(position.y()-this.plus.y())/this.sizeOne.y());
    }

    // Buffer implementation
    public synchronized void resetBuffer(){
        // always keep track of the image size
        this.bufferWidth=this.getContentPane().getSize().width;
        this.bufferHeight=this.getContentPane().getSize().height;
        
        //    clean up the previous image
        if(this.bufferGraphics!=null){
            this.bufferGraphics.dispose();
            this.bufferGraphics=null;
        }
        if(this.bufferImage!=null){
            this.bufferImage.flush();
            this.bufferImage=null;
        }

        //    create the new image with the size of the panel
        this.bufferImage=createImage(bufferWidth,bufferHeight);
        this.bufferGraphics=bufferImage.getGraphics();
        
        this.genFieldPlusOne();
    }
}