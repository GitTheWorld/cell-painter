import library.*;
/**
 * example if
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleIf extends bridge
{
    public static void main(String[] args) {
        new exampleIf();
    }

    public exampleIf()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        this.setBlack(0,0); // comment it out or change it to other color

        if(this.isBlack(0,0))
        {
            this.setBlack(9,0);
        }
        else if(this.isGreen(0,0))
        {
            this.setGreen(9,0);
        }
        else
        {
            this.setRed(9,0);
        }

        // end //  
    }
}
