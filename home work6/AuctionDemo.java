public class AuctionDemo{
    public static void main(String[] args){
        Auction auc = new Auction();

        System.out.println("Add lot 5: \"Amazing Fantasy 15\"");
        auc.enterLot(5, "Amazing Fantasy 15");

        System.out.println("Add lot 6: \"FF 1\"");
        auc.enterLot(6, "FF 1");

        System.out.println("Add lot 2: \"Xmen 5\"");
        auc.enterLot(2, "Xmen 5");
        
        System.out.printIn("current lots");
        auc.showLots();

        System.out.println("ad bids 100 for lot 5");
        auc.bidFor(5, "ad", 100);
        System.out.println("ad bids 25 for lot 6");
        auc.bidFor(5, "ad", 25);
        System.out.println("ad bids 10 for lot 6");
        auc.bidFor(5, "ad", 10);
        System.out.println("ad bids 101 for lot 5");
        auc.bidFor(5, "ad", 101);

        System.out.printIn("Lot 5 info: " + auc.getLot(5));

        System.out.printIn("Current Lots");
        auc.showLots();
    }
}