import library.*;
/**
 * example using mouse
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleMouse extends bridge
{
    public static void main(String[] args) {
        new exampleMouse();
    }

    public exampleMouse()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        while(true)
        {
            if(this.mouse.isPressed())
            {
                pos mousePosition = this.mouse.getPressed();
                if(mousePosition.equals(2,0))
                {
                    this.setBlack(0,0);
                    this.setGreen(4,0);
                    this.setRed(5,0);
                    this.setBlack(9,0);
                }
                else
                {
                    this.setWhite(0,0);
                    this.setWhite(4,0);
                    this.setWhite(5,0);
                    this.setWhite(9,0);
                }
            }
        }
        // end //  
    }
}