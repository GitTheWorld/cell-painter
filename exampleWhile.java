import library.*;
/**
 * example using while-loop
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleWhile extends bridge
{
    public static void main(String[] args) {
        new exampleWhile();
    }

    public exampleWhile()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //

        int i=0;
        while(i!=10) // true --> run || false --> not run
        {
            this.setBlack(i,0);
            i++;
        }

        // end //  
    }
}