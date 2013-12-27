import library.*;
/**
 * example using for-loop
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleFor extends bridge
{
    public static void main(String[] args) {
        new exampleFor();
    }

    public exampleFor()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        for(int i=0;i<10;i++) // i= 0,1,2,3,4,5,6,7,8,9
        {
            this.setBlack(i,0);
        }

        // end //  
    }
}