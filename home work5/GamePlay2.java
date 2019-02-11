public class GamePlay2{
    public static void main (string args[]){
        Game g = new Game(30);
        g.addTunnel(5,8);
        g.addTunnel(12,18);
        g.addTunnel(7,1);
        g.addTunnel(28,16);
        while(!g.isEnded()){
            g.play();
        }
    }
}