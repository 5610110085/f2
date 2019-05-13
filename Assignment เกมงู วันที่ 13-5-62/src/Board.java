import java.awt.Point;
import java.util.HashMap;

public class Board {  
  private int finishPos;
  private HashMap<Integer, Integer> tunnels = new HashMap<>();
  

  public Board(int finishPos) {
    this.finishPos = finishPos;
    prepareTunnels();
    
  }

  public int getFinishPos() {
    return finishPos;
  }

  public Integer getTunnelOutPos(int pos){
    return tunnels.get(pos);
  }

  

  public Point getRefLocationForPos(int pos){
    //800*500
    int row = ((pos - 1) / 10);
    int x;    
    if(row % 2 == 1){
      x = 82 * ((pos - 1) % 10);
    }else{
      x = 820 - ((pos - (row * 10)) * 82);
    }
    return new Point(x,  448 - (row * 64));
  }

  private void prepareTunnels(){
    tunnels.put(14, 6);
    tunnels.put(44, 22);
    tunnels.put(55, 33);
    tunnels.put(52, 50);
    tunnels.put(73, 67);
    tunnels.put(79, 57);
   
  }
  
}