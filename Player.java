import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;



public class Player extends Thread{

    public final int playerNr;
    ObjectInputStream input = null;
    ObjectOutputStream output= null;

    public Player(Socket s, int n){

	playerNr = n;
	
	
	try {
	    input = new ObjectInputStream(
					  s.getInputStream() );
	    output = new ObjectOutputStream(
					   s.getOutputStream() );
	}
	catch( IOException e ) {
	    e.printStackTrace();
	    System.exit( 1 );
	}	
    }
}
