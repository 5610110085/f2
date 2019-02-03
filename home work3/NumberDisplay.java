public class NumberDisplay {
    private int currValue;
    private int maxValue;

    public NumberDisplay(int max){
        maxValue = max;
        currValue = 0;
    }

    public void setValue(int newValue){
        if((newValue >= 0) && (newValue < maxValue))
            currvalue = newValue;
    }

    public int getValue() {
        return currvalue; 
    }

    public String getDisplayValue(){
        if (currValue < 10)
            return "0" + currValue;
        else
            return "" + currValue;
    }

    public void increment(){
        currvalue = (currValue + 1 % maxValue);
    }
        
}