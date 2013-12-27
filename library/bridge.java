package library;
import java.awt.Color;

/**
 * bridge to show only easy methods
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class bridge
{
    private colorField mother;
    public mouse mouse;
    public key key;

    public bridge(int x, int y)
    {
        this.mother = new colorField(x, y);
        this.mouse = new mouse(this.mother);
        this.key = new key(this.mother);
    }

    public bridge(pos position, boolean border)  
    {
        this.mother = new colorField(position, border);
    }

    public bridge(pos position, boolean border, Color background)  
    {
        this.mother = new colorField(position, border,background);
    }

    public boolean setBlack(int x, int y)
    {
        return this.mother.setBlack(x,y);
    }

    public boolean setBlack(pos position)
    {
        return this.mother.setBlack(position);
    }

    public boolean setWhite(int x, int y)
    {
        return this.mother.setWhite(x,y);
    }

    public boolean setWhite(pos position)
    {
        return this.mother.setWhite(position);
    }

    public boolean setRed(int x, int y)
    {
        return this.mother.setRed(x,y);
    }

    public boolean setRed(pos position)
    {
        return this.mother.setRed(position);
    }

    public boolean setGreen(int x, int y)
    {
        return this.mother.setGreen(x,y);
    }

    public boolean setGreen(pos position)
    {
        return this.mother.setGreen(position);
    }

    public boolean setColor(Color color,int x, int y)
    {
        return this.mother.setColor(color,x,y);
    }

    public boolean setColor(Color color, pos position)
    {
        return this.mother.setColor(color,position);
    }

    public boolean isWhite(int x, int y)
    {
        return this.mother.isWhite(x,y);
    }

    public boolean isWhite(pos position)
    {
        return this.mother.isWhite(position);
    }

    public boolean isBlack(int x, int y)
    {
        return this.mother.isBlack(x,y);
    }

    public boolean isBlack(pos position)
    {
        return this.mother.isBlack(position);
    }

    public boolean isRed(int x, int y)
    {
        return this.mother.isRed(x,y);
    }

    public boolean isRed(pos position)
    {
        return this.mother.isRed(position);
    }

    public boolean isGreen(int x, int y)
    {
        return this.mother.isGreen(new pos(x,y));
    }

    public boolean isGreen(pos position)
    {
        return this.mother.isGreen(position);
    }

    public boolean isColor(Color color, int x, int y)
    {
        return this.mother.isColor(color,x,y);
    }

    public boolean isColor(Color color, pos position)
    {
        return this.mother.isColor(color,position);
    }

    public void reset()
    {
        this.mother.reset();
    }

    public synchronized void setBorder(boolean border)
    {
        this.mother.setBorder(border);
    }

    public boolean isBorder()
    {
        return this.mother.isBorder();
    }

    public synchronized void setBackground(Color background)
    {
        this.mother.setBackground(background);
    }

    public Color getBackground()
    {
        return this.mother.getBackground();
    }

    public class mouse
    {
        private colorField mother;
        mouse(colorField mother)
        {
            this.mother = mother;
        }

        public pos getPressed()
        {
            return this.mother.mouse.getPressed();
        }

        public boolean isPressed()
        {
            return this.mother.mouse.isPressed();
        }

        public pos getReleased()
        {
            return this.mother.mouse.getReleased();
        }

        public boolean isReleased()
        {
            return this.mother.mouse.isReleased();
        }

        public pos getMoved()
        {
            return this.mother.mouse.getMoved();
        }

        public boolean isMoved()
        {
            return this.mother.mouse.isMoved();
        }

        public pos getDragged()
        {
            return this.mother.mouse.getDragged();
        }

        public boolean isDragged()
        {
            return this.mother.mouse.isDragged();
        }

        public void reset()
        {
            this.mother.mouse.reset();
        }
    }

    public class key
    {
        private colorField mother;
        key(colorField mother)
        {
            this.mother = mother;
        }

        public char getPressed()
        {
            return this.mother.key.getPressed();
        }

        public boolean isPressed()
        {
            return this.mother.key.isPressed();
        }

        public char getReleased()
        {
            return this.mother.key.getReleased();
        }

        public boolean isReleased()
        {
            return this.mother.key.isReleased();
        }

        public void reset()
        {
            this.mother.key.reset();
        }
    }
}
