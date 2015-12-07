import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class SocketClientDriver extends KeyAdapter{
    int latestCommand;
    ObjectInputStream inFromServer;
    ObjectOutputStream outToServer;
  
    GUI w;
    JFrame frame;
    Ship ship1;
    Ship ship2;
    //Alien alien1;

    int ship1X;
    int ship1Y;
    int ship2X;
    int ship2Y;

    Coordinate[] updatedArray;
    ServerMessage sR;
    
    public SocketClientDriver(String server, int port) {
	
	frame = new JFrame();
	frame.setPreferredSize(new Dimension(600,620));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	w = new GUI();
	frame.addKeyListener(this);
	w.requestFocusInWindow();
	w.setLayout(null);
	w.drawBackground(frame);
	frame.setVisible(true);

	ship1 = new Ship(1);
        ship2 = new Ship(2);

	ship1X = ship1.getX();
	ship1Y = ship1.getY();
	ship2X = ship2.getX();
	ship2Y = ship2.getY();

	
	try {
	    Socket socket1 = new Socket(server, port);

	    outToServer = new ObjectOutputStream(socket1.getOutputStream());
	     
	    inFromServer = new ObjectInputStream(socket1.getInputStream());
	    /**
	       obs
	    */
	    GUIThread guit = new GUIThread(inFromServer,w,frame);
	    while(true){
		Object serverResponse = (Object) inFromServer.readObject();
		if( serverResponse instanceof ServerMessage ) {
		    sR = (ServerMessage)serverResponse;
		    updatedArray = sR.getArray();

		    System.out.print("(PLAYER) p1X: " + updatedArray[0].getX());
		}
		/**
		 här ska gui:n updateras
		 */
		w.updateFrame(frame, updatedArray);



	    }


	}
	catch ( EOFException e ) {
	    return;
        }
	catch ( UnknownHostException e ) {
	    System.err.println("Don't know about host " + server);
	    System.exit(1);
        }
	catch ( IOException e ) {
            System.err.println("Couldn't get I/O for the connection to " + server);
            System.exit(1);
		
        }
	catch( ClassNotFoundException e ) {
	    e.printStackTrace();
	    System.exit( -1 );
	    
	}
    }

    public void keyPressed(KeyEvent e){
	try{
	
	    int keys = e.getKeyCode();
	    if(keys == KeyEvent.VK_A){
		System.out.println("LEFT");
		latestCommand = 0;
		outToServer.writeObject(latestCommand);
	    }
	    else if(keys == KeyEvent.VK_D){
		System.out.println("RIGHT");
		latestCommand = 1;
		outToServer.writeObject(latestCommand);

	    }
	    else if(keys == KeyEvent.VK_SPACE){
		System.out.println("FIRE!");
		latestCommand = 2;
		outToServer.writeObject(latestCommand);
			
	    }
	}
	catch (UnknownHostException ev) {
	    System.err.println("Don't know about host." );
	    System.exit(1);
        }
	catch (IOException ev) {
            System.err.println("Couldn't get I/O for the connection.");
            System.exit(1);
        }
	
	
    }

    public int latestCommand(){

	return latestCommand;
    }

       
    

}
