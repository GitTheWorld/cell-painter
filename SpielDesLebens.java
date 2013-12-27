import library.*;
/**
 * Einfache Implementierung vom Spiel des Lebens
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class SpielDesLebens extends bridge
{
    public static void main(String[] args) {
        new SpielDesLebens();
    }

    public SpielDesLebens()
    {
        super(20,20);
        this.your_code();
    }

    public void your_code()
    {
        while(true)
        {
            if(this.mouse.isPressed())
            {
                pos position = this.mouse.getPressed();
                if(this.isWhite(position))
                {
                    this.setBlack(position);
                }
                else
                {
                    this.setWhite(position);
                }
            }  

            if(this.key.isPressed())
            {
                this.startGameOfLife(0,0);
                this.key.reset();
            }
        } 
    }

    public void startGameOfLife(int x, int y)
    {

        // count fields around
        int lifeAround=0;
        for(int i=-1;i<2;i++)
        {
            for(int p=-1;p<2;p++)
            {
                if(i!=0||p!=0)
                {
                    if(this.isBlack(x+i,y+p)){lifeAround++;}
                }  
            }
        }

        // count it for all cells
        if(x!=19 || y!=19)
        {
            if(x==19)
            {
                this.startGameOfLife(0,y+1);
            }
            else
            {
                this.startGameOfLife(x+1,y);
            }
        }

        // set the result --> rules of life
        if(this.isBlack(x,y))
        {
            if(lifeAround!=2 && lifeAround!=3)
            {
                this.setWhite(x,y);
            }
        }

        if(this.isWhite(x,y))
        {
            if(lifeAround==3)
            {
                this.setBlack(x,y);
            }
        }    
    }
}