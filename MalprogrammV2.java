import library.*;
/**
 * Einfache Malprgramm V2
 * 
 * @author Marcel
 * @version 0.1
 */
public class MalprogrammV2 extends bridge
{
    private int color;
    
    public static void main(String[] args) {
        new MalprogrammV2();
    }

    public MalprogrammV2()
    {
        super(20,20);
        this.color=0;
        this.your_code();
    }

    public int your_code()
    {
        while(true)
        {
            if(this.mouse.isDragged())
            {
               this.set(mouse.getDragged());
            }
            this.controlKeys();
        }
    }

    // process incoming information
    public void controlKeys()
    {
        while(this.key.isPressed())
        {
            char choose = this.key.getPressed();

            if(choose=='0')
            {
                if(this.isBorder())
                {
                    this.setBorder(false);
                }
                else
                {
                    this.setBorder(true);
                }
            }
            else if (choose=='1')
            {
                this.color=0;
            }
            else if (choose=='2')
            {
                this.color=1;
            }
            else if (choose=='3')
            {
                this.color=2;
            }
            else if (choose=='4')
            {
                this.color=3;
            }
            else if (choose=='5')
            {
                this.color=4;
            }
        }
    }

    // set current color on position
    public void set(pos position)
    {
        if(this.color==0)
        {
            this.setBlack(position);
        }
        else if(this.color==1)
        {
            this.setGreen(position);
        }
        else if(this.color==2)
        {
            this.setRed(position);
        }
        else if(this.color==3)
        {
            this.setWhite(position);
        }
    }  

}