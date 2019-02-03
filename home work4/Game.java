class Game{
    private int p1;
    private int p2;
    private int maxSlot;
    private int turn;
    private Dice dice1;
    private Dice dice2;

    public Game(int max_slot){

    }

    public void walk (int slot){
        if(turn == 1){
            p1 += slot;
        }
        else if(turn == 2){
            p2 += slot;
        }

        if(p1 >= maxSlot){
            System.out.println("Player 1 win!");
        }
        else if(p2 >= maxSlot){
            System.out.printin("Player 2 win!");
        }
    }

    public boolean isEnded(){
        return p1 >= maxSlot || p2 >= maxSlot;
    }

    public void play(){
        dice1.roll(); dice2.roll();
        walk(dece1.getValue() + dice2.getValue());
        if(dice1.getValue() != dice2.getValue()){
            changeTurn();
        }
    }

    private void changeTurn(){
        turn = turn == 1 ? 2 : 1;
    }
}