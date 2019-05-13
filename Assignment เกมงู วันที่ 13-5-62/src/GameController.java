import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GameController implements PlayerListener {
  private Board board;
  private Dice d1 = new Dice();
  private Dice d2 = new Dice();

  private Player p1;
  private Player p2;
  private Player currentPlayer;
  private Player winner = null;
  private int status_p1 = 0;
  private int status_p2 = 0;
  private int position = 0;
  private List<Sprite> players = new ArrayList<>();

  private List<GameSpriteListener> spriteListeners = new ArrayList<>();
  private List<GameControlListener> controlListeners = new ArrayList<>();


  private static GameController instance;
  public static GameController getInstance(){
    if(instance == null){
      instance = new GameController();
    }
    return instance;
  }

  private GameController() {
    board = new Board(80);

    p1 = new Player("P1", 0, board, this);
    p2 = new Player("P2", 1, board, this);
    currentPlayer = p1;
    
    players.add(p1);
    players.add(p2);    
  }

  private void rollDice() {
    d1.roll();
    d2.roll();
  }

  public void takeTurn() {
    if(winner != null)
      return;

    
    

    
    rollDice();

    if(status_p1 != 3 && currentPlayer == p1){
    currentPlayer.walk(d1.getFace() + d2.getFace());
    }else if(status_p2 != 3 && currentPlayer == p2){
    currentPlayer.walk(d1.getFace() + d2.getFace());
    }else if(status_p1 == 3 && currentPlayer == p1){
      currentPlayer.walk((d1.getFace() + d2.getFace())*3);
    //  System.out.println("walkp1 = "+(d1.getFace() + d2.getFace())*3);
      status_p1 = 0;
    }else if(status_p2 == 3 && currentPlayer == p2){
      currentPlayer.walk((d1.getFace() + d2.getFace())*3);
    //  System.out.println("walkp2 = "+(d1.getFace() + d2.getFace())*3);
      status_p2 = 0;
    }
    position = currentPlayer.getNextPosition();
    //System.out.println("position = "+position);
    if(position == 5|| position == 27||position == 43){
      if(currentPlayer == p1)
        status_p1 = 3;
      else status_p2 = 3;
    }
    else if(position == 13||position == 36|| position == 71){
      if(currentPlayer == p1)
        status_p1 = 2;
      else status_p2 = 2;
    }
    else if(position == 18||position == 48|| position == 65){
      if(currentPlayer == p1)
        status_p1 = 1;
      else status_p2 = 1;
    }

    //System.out.println("dice1 = "+d1.getFace()+" dice2 = "+d2.getFace()+" s1 = "+status_p1+" s2 = "+status_p2);
  }

  private void changeTurn() {
    if(status_p1 == 0 && status_p2 == 0){
    if (currentPlayer == p1)
      currentPlayer = p2;
    else
      currentPlayer = p1;
    }else if(status_p1 == 1){
      if(currentPlayer == p2){
        currentPlayer = p2;
        status_p1 = 0;
      }
    }else if(status_p2 == 1){
      if(currentPlayer == p1){
        currentPlayer = p1;
        status_p2 = 0;
      }
    }else if(status_p1 == 2){
      currentPlayer = p1;
      status_p1 = 0;
    }else if(status_p2 == 2){
      currentPlayer = p2;
      status_p2 = 0;
    }
    if(status_p1 == 3 || status_p2 == 3||status_p1 == 1 || status_p2 == 1){
    if (currentPlayer == p1)
      currentPlayer = p2;
    else
      currentPlayer = p1;
    }
  }

  @Override
  public void walking(Player owner){
    notifyGamePlayEnabled(false);
    for(GameSpriteListener listener : spriteListeners){
      listener.spriteUpdated();
    }
  }

  @Override
  public void walkCompleted(Player onwer) {        
    changeTurn();
    notifyGamePlayEnabled(true);
  }

  @Override
  public void hasWon(Player owner) {
    if (winner == null) { // first winner only
      winner = owner;
      JOptionPane.showMessageDialog(null, winner + " is won!!!");

    }
  }
  

  public Player getWinner() {
    return winner;
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public List<Sprite> getSprites(){
    return players;
  }

  public void addSpriteListener(GameSpriteListener listener){
    spriteListeners.add(listener);
  }

  public void addControlListener(GameControlListener listener){
    controlListeners.add(listener);
  }

  public void notifyGamePlayEnabled(boolean enabled){
    for(GameControlListener listener : controlListeners){
      listener.changeGamePlayEnabled(enabled);
    }
  }

}