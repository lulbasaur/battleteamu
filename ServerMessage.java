import java.io.Serializable;


public class ServerMessage implements Serializable{

    Coordinate[] cV;
    int ArrayLength;
    
    public ServerMessage(Coordinate[] cV){
	
	this.cV = cV;
	this.ArrayLength = cV.length;
    }

    public int getArrayLength(){
	return ArrayLength;
    }

    public Coordinate[] getArray(){
	return cV;
    }
}
