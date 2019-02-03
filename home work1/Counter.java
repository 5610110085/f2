public class Counter
{
    int val;
    public Counter()
    {
        val = 0;
    }
    public void inc()
    {
        val++;
    }
    public void reset()
    {
        val= 0;
    }
    public int getVal()
    {
        return val;
    }
}