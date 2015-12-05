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

    int x;
    int y;
    GUI w;
    JFrame frame;
    Ship ship1;
    Ship ship2;
    
    public SocketClientDriver(String server, int port) {
	
        /*JFrame frame = new JFrame("testframe");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  JPanel panel = new JPanel();
	  panel.addKeyListener(this);
	  frame.add(panel);
	  frame.setSize(500, 500);
	  frame.setVisible(true);
	  panel.requestFocusInWindow();*/
	
	frame = new JFrame();
        frame.setPreferredSize(new Dimension(600,600));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	w = new GUI();
	frame.addKeyListener(this);
	w.requestFocusInWindow();
	w.setLayout(null);
	w.drawBackground(frame);
	frame.setVisible(true);

 
	ship1 = new Ship(w, frame, 1);
        ship2 = new Ship(w, frame, 2);
	
	try {
	    Socket socket1 = new Socket(server, port);

	    outToServer = new ObjectOutputStream(socket1.getOutputStream());
	     
	    inFromServer = new ObjectInputStream(socket1.getInputStream());



	    /*    while(true){
		
		  Scanner scanner = new Scanner(System.in);
		  System.out.print("Enter text: ");
		  String usertext = scanner.next();
		  outToServer.writeObject(usertext); 
		  outToServer.writeObject(latestCommand);
		  latestCommand = -1;
		  try {
		  Thread.sleep(500);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		
		  }*/
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

 
	    

    
    
    public void keyPressed(KeyEvent e){
	try{
	
	    int keys = e.getKeyCode();
	    if(keys == KeyEvent.VK_A){
		System.out.println("RIGHT");
		latestCommand = 0;
		ship1.move(w, frame, ++x, y);
		outToServer.writeObject(latestCommand);
	    }
	    else if(keys == KeyEvent.VK_D){
		System.out.println("LEFT");
		latestCommand = 1;
		ship1.move(w, frame, --x, y);
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
