import library.*;
import java.awt.Color; // very important - load the class to define Color.<name>
/**
 * example using while-loop
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleColor extends bridge
{
    public static void main(String[] args) {
        new exampleColor();
    }

    public exampleColor()
    {
        super(2,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        this.setColor(Color.blue,0,0);

        if(this.isColor(Color.blue,0,0))
        {
            this.setColor(Color.yellow,1,0);
        }
        
        // end //  
    }
}