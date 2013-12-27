import library.*;
/**
 * example variable
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleVariable extends bridge
{
    public static void main(String[] args) {
        new exampleVariable();
    }

    public exampleVariable()
    {
        super(10,1);
        this.your_code();
    }

    public void your_code()
    {
        // own code //
        
        boolean decision = true; 
        int number = 10;
        char character = 'a';
        
        /*
         * other possibilities
         * 
         * boolean decision;
         * decision = true;
         * 
         * int number;
         * number = 10;
         * 
         * char character;
         * character = 'a';
         * 
         * 
         * 
         */

        // decision = false;
        
        if(decision)
        {
            this.setGreen(0,0);
        }
        else
        {
            this.setRed(0,0);
        }
        
        // number = 20;
        
        if(number<15) // or >, ==, !=
        {
            this.setGreen(1,0);
        }
        else
        {
            this.setRed(1,0);
        }

        // character = 'b';
        
        if(character=='a') // or !=
        {
            this.setGreen(2,0);
        }
        else
        {
            this.setRed(2,0);
        }
        
        // very important //
        
        int integrate = 3;
        this.setGreen(integrate,0);
        
        // end //  
    }
}