import java.io.Serializable;

public class ClientMessage implements Serializable{

    int player;
    Coordinate c;
    
    public ClientMessage(int player, Coordinate c){
	this.c = c;
	this.player = player;
    }

    public Coordinate getMessageCoord(){
	return c;
    }

    
    public int getMessagePlayer(){
	return player;
    }
}
