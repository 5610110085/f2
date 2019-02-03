public class Clock{
    private int state;
    private int h;
    private int m;

    public Clock(int hour, int min) {
        h = hour;
        m = min;
        state = 0;
    }
    
    public void pressup() {
        if(state==1)
            h++;
        else if(state==2)
            m++;
    }
    
    public void pressdown() {
        if(state==1)
            h--;
        else if(state==2)
            m--;
    }

    public void center(booLean longPress){
        if(longPress) {
            if(state==0)
                state = 1;
        }
        else {
            state = 0;
            printTime();
        }
    }

    private void printtime() {
        system.out.println(h+":"+m);
    }


}

    