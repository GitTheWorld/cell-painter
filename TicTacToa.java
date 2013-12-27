import library.*;
/**
 * TicTacToa
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class TicTacToa extends bridge
{
    public static void main(String[] args) {
        new TicTacToa();
    }

    public TicTacToa()
    {
        super(3,3);
        this.your_code();
    }

    public void your_code()
    {
        while(true){

            for(int i=0;i<9;i++)
            {
                this.runTurn(i%2);
                if(this.isEnd(i%2)){break;}
            }

            while(true)
            {
                if(this.mouse.isPressed())
                {
                    break;
                }
            }

            this.mouse.reset();
            this.reset();
        }
    }

    // wait for player interaction
    private void runTurn(int number)
    {
        while(true)
        {
            if(this.mouse.isPressed())
            {
                pos position = this.mouse.getPressed();
                if(this.isWhite(position))
                {
                    this.setForPlayer(number,position);
                    break;
                }

            }
        }
        this.mouse.reset();
    }

    // check win condition
    private boolean isEnd(int number)
    {

        // left to right
        for(int i=0;i<3;i++)
        {

            if(this.isForPlayer(number,0,i) && this.isForPlayer(number,1,i) && this.isForPlayer(number,2,i))
            {
                this.setBlack(0,i);
                this.setBlack(1,i);
                this.setBlack(2,i);
                return true;
            }

        }

        // top to bottom
        for(int i=0;i<3;i++)
        {

            if(this.isForPlayer(number,i,0) && this.isForPlayer(number,i,1) && this.isForPlayer(number,i,2))
            {
                this.setBlack(i,0);
                this.setBlack(i,1);
                this.setBlack(i,2);
                return true;
            }

        }

        // left top to right bottom
        if(this.isForPlayer(number,0,0) && this.isForPlayer(number,1,1) && this.isForPlayer(number,2,2))
        {
            this.setBlack(0,0);
            this.setBlack(1,1);
            this.setBlack(2,2);
            return true;
        }

        // right top to left bottom
        if(this.isForPlayer(number,0,2) && this.isForPlayer(number,1,1) && this.isForPlayer(number,2,0))
        {
            this.setBlack(0,2);
            this.setBlack(1,1);
            this.setBlack(2,0);
            return true;
        }
        return false;
    }

    private void setForPlayer(int number, int x, int y)
    {
        this.setForPlayer(number, new pos(x,y));
    }

    // bind player to number (set)
    private void setForPlayer(int number, pos position)
    {
        if(number==0)
        {
            this.setGreen(position);
        }
        else
        {
            this.setRed(position);
        }
    }

    private boolean isForPlayer(int number, int x, int y)
    {
        return this.isForPlayer(number, new pos(x,y));
    }

    // bin player to number (is)
    private boolean isForPlayer(int number, pos position)
    {
        if(number==0)
        {
            return this.isGreen(position);
        }
        else
        {
            return this.isRed(position);
        }
    }
}