public class AdderTest{
    public static void main(string args[]){
        adder a = new Adder();
        a.add(2);
        a.add(3);
        System.out.println(a.getVal());

        adder b = new Adder();
        b.setVal(12);
        b.add(1);
        System.out.println(b.getVal());
        a.addFrom(b);
        System.out.println(a.getVal());
    }
}