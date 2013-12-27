import library.*;
/**
 * example to use a method
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleMethod extends bridge
{
    public static void main(String[] args) {
        new exampleMethod();
    }

    public exampleMethod()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        this.setBlack(0,0);
        this.setGreen(4,0);
        this.setGreen(5,0);
        this.setRed(9,0);

        // end //  
    }
}