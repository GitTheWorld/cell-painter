import library.*;
/**
 * Einfaches Malprgramm V1
 * 
 * @author Marcel
 * @version 0.1
 */
public class MalprogrammV1 extends bridge
{
    public static void main(String[] args) {
        new MalprogrammV1();
    }

    public MalprogrammV1()
    {
        super(20,20);
        this.your_code();
    }

    public int your_code()
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
                else if(this.isBlack(position))
                {
                    this.setGreen(position);
                }
                else if(this.isGreen(position))
                {
                    this.setRed(position);
                }
                else if(this.isRed(position))
                {
                    this.setWhite(position);
                }
            }  
        }
    }
}