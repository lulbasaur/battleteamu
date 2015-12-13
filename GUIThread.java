import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.util.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class GUIThread extends Thread{

    ObjectInputStream input;
    GUI gui;
    Coordinate[] updatedArray;
    JFrame frame;
    ServerMessage sR;
    
    public GUIThread(ObjectInputStream input, GUI gui, JFrame frame){
	this.frame = frame;
	this.gui = gui;
	this.input = input;
	
    }
    public void run(){
	
	/**	try{
	    while(true){
		Object serverResponse = (Object) input.readObject();
		if( serverResponse instanceof ServerMessage ) {
		    	    sR = (ServerMessage)serverResponse;
		    updatedArray = sR.getArray();
		    System.out.print("(GUITHREAD) p1X: " + updatedArray[0].getX());
		    
		    gui.updateFrame(frame, updatedArray);
		    
		}
		gui.updateFrame(frame, updatedArray);
				    
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
	    }*/
	while(true){
	    gui.updateFrame(frame, updatedArray);
	    System.out.println("(GUITHREAD)");

	}
    }
}
