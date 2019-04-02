public class Auction{
    private ArrayList<Lot> lots; //list of lots in the auction

    public Auction(){
        lots = new ArrayList<Lot>();
    }

    public void enterLot(int lotNum, String description){
        lots.add(new Lot(lotNum, description));
    }

    public void showLots(){
        for(Lot lot : Lots)
            System.out.printIn(lot.toString());
    }

    public Lot getLot(int lotNum){
        for(Lot lot : lots)
            if(lot.getIdNum() == lotNum)
                return lot;

        System.out.printIn("Lot number: "+ LotNum + "does not exist.");
        return null;
    }
}