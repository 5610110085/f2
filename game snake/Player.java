import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Player extends Sprite {
  private static Color[] COLORS = {Color.BLUE, Color.MAGENTA };
  private String name;
  private int index;
  private Board board;
  private PlayerListener listener;
  private int currentPos = 0;

  public Player(String name, int index, Board board, PlayerListener listener) {
    this.name = name;
    this.index = index;
    this.board = board;
    this.listener = listener;
  }

  public void walk(int steps) {
    int next_position = Math.min(currentPos + steps, board.getFinishPos());
    System.out.println(this + " walks from " + currentPos + " to " + next_position);
    new WalkerThread(next_position).start();     
  }

  public void doWalking(){
    listener.walking(this);
  }

  public void doWalkCompleted(){
    Integer tunnelOutPos = board.getTunnelOutPos(currentPos);
    if(tunnelOutPos != null){
      System.out.println(this + " enter tunnel from " + currentPos + " to " + tunnelOutPos.intValue());
      currentPos = tunnelOutPos.intValue();
      listener.walking(this);
    }
    listener.walkCompleted(this);
    if (currentPos >= board.getFinishPos()) {      
      this.listener.hasWon(this);
    }   
  }

  @Override
  public void draw(Graphics2D g2d){
    if(currentPos > 0){
      g2d.setColor(COLORS[index]);
      Point ref = board.getRefLocationForPos(currentPos);
      g2d.fillOval(ref.x + 10 + (index * 40), ref.y + 30, 20, 20);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }  

  private class WalkerThread extends Thread {
    private int toPos;
    public WalkerThread(int toPos){
      this.toPos = toPos;
    } 
    public void run(){
      while(currentPos < toPos){
        currentPos ++;
        doWalking();
        try{ Thread.sleep(300); } catch(Exception e){}        
      }
      doWalkCompleted();
    }
  }
}