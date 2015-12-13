import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;



public class Player extends Thread{

    public final int playerNr;
    ObjectInputStream input = null;
    ObjectOutputStream output= null;
    GameEngine GE;

    ServerMessage messageToClient;
    public Player(Socket s, int n, GameEngine GE){

	this.GE = GE;
	playerNr = n;
	
	
	try {
	    input = new ObjectInputStream(
					  s.getInputStream() );
	    output = new ObjectOutputStream(
					   s.getOutputStream() );
	    System.out.println("Player: " + playerNr + " connected!");
	    /**obs*/
	    //PlayerThread p = new PlayerThread(output,GE);
	    //p.start();
	}
	catch( IOException e ) {
	    e.printStackTrace();
	    System.exit( -1 );
	}	
    }
    public void run(){
	
	while(true){

	    try{
		System.out.print("(PLAYER) p1 X: " + GE.updateVector[0].getX());
		messageToClient = new ServerMessage(GE.updateVector);
		output.writeObject(messageToClient);
		output.reset();
	    }
	    catch( IOException e ) {
		e.printStackTrace();
		System.exit( -1 );
	    }
	    
	    try{

		
		Object pname = (Object) input.readObject();


		
		if( pname instanceof String) {
		    System.out.println("Respons by player "+ playerNr +": " + pname);
		}
		if(pname instanceof Integer) {
		    int choice = (int)pname; 
		    switch(choice){
		    case 0:
			System.out.println("Respons by player "+ playerNr +": " + pname + " LEFT");
			GE.movePlayer(playerNr,1);
			
			break;
		    case 1:
			System.out.println("Respons by player "+ playerNr +": " + pname + " RIGHT");
			GE.movePlayer(playerNr,0);

			break;		  		    
		    case 2:
			System.out.println("Respons by player "+ playerNr +": " + pname + " FIRE");
			GE.killAlien(playerNr);

			break;
		    default:
		    break;
		    }
		    pname = -1;
		}
		System.out.print("(PLAYER) p1 X: " + GE.updateVector[0].getX());
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
	    catch( ClassNotFoundException e ) {
		e.printStackTrace();
		System.exit( -1 );

	    }
	}
    }

}
