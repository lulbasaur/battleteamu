import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class PlayerThread extends Thread{

    GameEngine GE;
    ObjectOutputStream output;
    ServerMessage messageToClient;
    
    public PlayerThread(ObjectOutputStream output, GameEngine GE){

	this.GE = GE;
	this.output = output;
    }
    public void run(){
	
	while(true){
	    try{
		    messageToClient = new ServerMessage(GE.updateVector);
		    output.writeObject(messageToClient);
		    output.reset();
		}
		
	    
	    catch( EOFException e ) {
		return;
	    }
	    catch( IOException e ) {
		e.printStackTrace();
		System.exit( -1 );
	    }
	}
    }
}
