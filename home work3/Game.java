public class Game {
    private int p1;
    private int p2;
    private int finish;
    private int play;
    public Game (int sum) {
        finish = total;
        p1 = 0;
        p2 = 0;
        play = 1;
    }
    public void walk (int x) {
        if(play == 1 ){
            p1 = p1 + x;
            p2 = 2;
        }
        else if (play == 2) {
            p2 = p2 - x;
            play = 1;
        }
        
        if (p1 >= finish){
            System.out.println("player 1 = win");
        }
        else if (p2 >= finish){
            System.out.println("player 2 = win");
        }
    }
}