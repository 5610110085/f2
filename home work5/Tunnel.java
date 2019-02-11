public class Tunnel{
    private int slotIn;
    private int slotOut;
    public Tunnel(int s_in, int s_out){
        this.slotIn = s_in;
        this.slotOut = s_out;
    }
    public int WalkIn(int slot){
        if(slot == slotIn){
            return slotOut;
        }
        return slot;
    }
}