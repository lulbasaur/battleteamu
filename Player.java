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
	    System.out.println("Player: " + playerNr + " connected!");
	}
	catch( IOException e ) {
	    e.printStackTrace();
	    System.exit( -1 );
	}	
    }
    public void run(){
	
	while(true){
	    try{
		Object pname = (Object) input.readObject();
		if( pname instanceof String) {
		    System.out.println("Respons by player "+ playerNr +": " + pname);
		}
		if(pname instanceof Integer) {
		    int choice = (int)pname; 
		    switch(choice){
		    case 0:
			System.out.println("Respons by player "+ playerNr +": " + pname + " RIGHT");
		    case 1:
			System.out.println("Respons by player "+ playerNr +": " + pname + " LEFT");
		    case 2:
			System.out.println("Respons by player "+ playerNr +": " + pname + " FIRE");
		    default:
		    break;
		    }
		}
	    }
	    catch( EOFException e ) {
		return;
	    }
	    catch( IOException e ) {
		e.printStackTrace();
		System.exit( -1 );
	    }
	    catch( ClassNotFoundException e ) {
		e.printStackTrace();
		System.exit( -1 );

	    }
	}
    }

}
