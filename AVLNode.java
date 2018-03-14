

public class AVLNode extends Node{
    
    private int balance;
    
    public AVLNode(long stn, String ln, String dp,
                   String p, int y){
        super(stn, ln, dp, p, y);
        balance= 0;
    }


    
}
