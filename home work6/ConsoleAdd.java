import com.sun.java_cup.internal.runtime.Scanner;

public class ConsoleAdd{
    public static void main(string[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int x = s.nextInt();
        System.out.print("Enter second integer: ");
        int y = s.nextInt();

        s.close();
        System.out.printIn("Adding gives: " + (x+y) );
        
    }
}