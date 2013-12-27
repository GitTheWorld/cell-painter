import library.*;
/**
 * 4-Gewinnt
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class VierGewinnt extends bridge
{
    private boolean end;

    public static void main(String[] args) {
        new VierGewinnt();
    }

    public VierGewinnt()
    {
        super(7,6);
        this.your_code();
        this.end=false;
    }

    public void your_code()
    {
        while(true){

            for(int i=0;i<42;i++)
            {
                this.runTurn(i%2);
                if(this.end){break;}
            }

            while(true){if(this.mouse.isPressed()){break;}}
            this.reset();
            this.mouse.reset();
            this.key.reset();
            this.end=false;
        }
    }

    private boolean findPlace(int player,int number)
    {
        for(int i=5;i>=0;i--)
        {
            if(this.isWhite(number,i)){
                this.setForPlayer(player,number,i);
                this.checkEnd(player,number,i);
                return true;
            }
        }
        return false;
    }

    public boolean checkEndHori(int player, int x, int y)
    {
        int out=1;
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x+i,y)){break;}
            out++;
        }
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x-i,y)){break;}
            out++;
        }
        if(out>=4){this.end=true;}

        if(this.end)
        {
            this.setBlack(x,y);
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x+i,y)){break;}
                this.setBlack(x+i,y);
            }
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x-i,y)){break;}
                this.setBlack(x-i,y);
            }
            return true;
        }
        return false;
    }

    public boolean checkEndVerti(int player, int x, int y)
    {
        int out=1;
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x,y+i)){break;}
            out++;
        }
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x,y-i)){break;}
            out++;
        }
        if(out>=4){this.end=true;}

        if(this.end)
        {
            this.setBlack(x,y);
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x,y+i)){break;}
                this.setBlack(x,y+i);
            }
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x,y-i)){break;}
                this.setBlack(x,y-i);
            }
            return true;
        }
        return false;
    }

    public boolean checkEndDiaUp(int player, int x, int y)
    {
        int out=1;
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x+i,y+i)){break;}
            out++;
        }
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x-i,y-i)){break;}
            out++;
        }
        if(out>=4){this.end=true;}

        if(this.end)
        {
            this.setBlack(x,y);
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x+i,y+i)){break;}
                this.setBlack(x+i,y+i);
            }
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x-i,y-i)){break;}
                this.setBlack(x-i,y-i);
            }
            return true;
        }
        return false;
    }

    public boolean checkEndDiaDown(int player, int x, int y)
    {
        int out=1;
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x-i,y+i)){break;}
            out++;
        }
        for(int i=1;i<=3;i++)
        {
            if(!this.isForPlayer(player,x+i,y-i)){break;}
            out++;
        }
        if(out>=4){this.end=true;}

        if(this.end)
        {
            this.setBlack(x,y);
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x-i,y+i)){break;}
                this.setBlack(x-i,y+i);
            }
            for(int i=1;i<=3;i++)
            {
                if(!this.isForPlayer(player,x+i,y-i)){break;}
                this.setBlack(x+i,y-i);
            }
            return true;
        }
        return false;
    }

    private void checkEnd(int player,int x, int y)
    {
        if(this.checkEndHori(player,x,y)){return;}
        if(this.checkEndVerti(player,x,y)){return;}
        if(this.checkEndDiaUp(player,x,y)){return;}
        if(this.checkEndDiaDown(player,x,y)){return;}
    }

    private void runTurn(int number)
    {
        while(true)
        {
            if(this.mouse.isPressed())
            {
                int position = this.mouse.getPressed().x();
                if(position>=0 && this.findPlace(number,position)){break;}
            }
        }
        this.key.reset();
    }

    private void setForPlayer(int number, int x, int y)
    {
        this.setForPlayer(number, new pos(x,y));
    }

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