import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.awt.event.*;


class SocketClient implements KeyListener{


    public static void main(String[] args) {
	ObjectInputStream inFromServer;
	ObjectOutputStream outToServer;
	String server = "localhost";
	int port = 2044;
	try {
	    Socket socket1 = new Socket(server, port);

	    outToServer = new ObjectOutputStream(socket1.getOutputStream());
	     
	    inFromServer = new ObjectInputStream(socket1.getInputStream());



	    while(true){
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter text: ");

		// get their input as a String
		String usertext = scanner.next();

		outToServer.writeObject(usertext);
	    }
	} 
	catch (UnknownHostException e) {
	    System.err.println("Don't know about host " + server);
	    System.exit(1);
        }
	catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + server);
            System.exit(1);
        }


    }


    public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
	    System.out.println("SPACEPRESS");
	}
    }
        public void keyTyped(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
	    System.out.println("SPACETYPED");
	}
   }


    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
	    System.out.println("SPACERELEASED");
	}
    }
    

    
}
