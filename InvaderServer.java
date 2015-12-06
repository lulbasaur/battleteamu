import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class InvaderServer implements Runnable{


    public static void main(String[] args) {

	Player[] playerVector = new Player[2];
	int serverPort = 2044;
	ServerSocket serverSocket = null;
	CoordinateGrid CG = new CoordinateGrid(20);
	GameEngine GE = new GameEngine(CG);
	
	try {serverSocket = new ServerSocket(serverPort);}	
	catch (IOException e) {
	    System.err.println("Could not connect to port: "+ serverPort + e.getMessage());
	    System.exit(-1);
	}

	int i = 0;

	while(true){

	    try {
		
		System.out.println("Listening...");
		Socket s = serverSocket.accept();
		System.out.println("Got connection from player: " + (i+1));
		
		if(i < 2){
		    playerVector[i] = new Player(s,i+1,GE);	
		}
		playerVector[i++].start();
			    
	    }
	    catch (IOException e) {
		System.err.println("Could not connect to the player " + e.getMessage());
		System.exit(-1);
	    }
	    
	}
	
    }

    public void run(){
	
	System.exit(-1);
    }

    
}
