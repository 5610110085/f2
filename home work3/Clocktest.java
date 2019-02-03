public class Clocktest{
    public static void main (string[]args)
    {
        clock c = new Clock(12,35);
        c.presscenter(true);
        c.pressup();
        c.presscenter(true);
        c.pressup(); c.pressup();
        c.pressup(); c.pressup();
        c.pressup(); c.presscenter(true); 
    }
}