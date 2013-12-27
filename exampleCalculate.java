import library.*;
/**
 * calculate with int
 * 
 * @author Marcel Link
 * @version 0.1
 */
public class exampleCalculate extends bridge
{
    public static void main(String[] args) {
        new exampleCalculate();
    }

    public exampleCalculate()
    {
        super(10,7);
        this.your_code();
    }

    public void your_code()
    {
        int number1 = 2;
        int number2 = 4;
        int number3;
        
        number3 = number1+number2;
        this.setBlack(number3,0);
        
        number3 = number2-number1;
        this.setBlack(number3,1);
        
        number3 = number2*number1;
        this.setBlack(number3,2);
        
        number3 = number2/number1;
        this.setBlack(number3,3);
        
        number3 = number1%number2;
        this.setBlack(number3,4);
        
        this.setBlack(number3+number2+number1,5);
        
        number3++;
        this.setBlack(number3,6);
    }
}