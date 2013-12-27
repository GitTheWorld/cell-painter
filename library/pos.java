package library;


/**
 * pos enthält eine Position im Koordinatensystem
 * 
 * @author Marcel Link
 * @version 0.1
 **/
public class pos
{
    private int x;
    private int y;

    public pos(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int x()
    {
        return this.x;
    }

    public int x(int x)
    {
        this.x=x;
        return this.x;
    }

    public int y()
    {
        return this.y;
    }

    public int y(int y)
    {
        this.y=y;
        return this.y;
    }

    public boolean equals(int x, int y)
    {
        return equals(new pos(x,y));
    }

    public boolean equals(pos position)
    {
        if(position.x()==this.x && position.y()==this.y)
        {
            return true;
        }
        return false;
    }
}
