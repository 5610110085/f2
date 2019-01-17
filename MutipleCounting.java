<<<<<<< HEAD
public class MutipleCounting
{
    public static void main(String args[])
    {
        Counter c = new Counter();
        for(int i=0;i<5;i++)
        {
            while(c.getVal() < 10){
                c.inc();
                System.out.println(c.getVal());
            }
            c.reset();
        }
    }
=======
public class MutipleCounting
{
    public static void main(String args[])
    {
        Counter c = new Counter();
        for(int i=0;i<5;i++)
        {
            while(c.getVal() < 10){
                c.inc();
                System.out.println(c.getVal());
            }
            c.reset();
        }
    }
>>>>>>> 2f49c0c9494a0efd717ddd7d4ebfd8b09ccd171f
}