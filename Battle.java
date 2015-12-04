import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Battle{

    private static final int HIT = 0;
    private static final int OCC = 1;
    private static final int UNOCC = 2;
    
    public static void main(String[] args) {

	JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(600,600));
	
	GUI w = new GUI();
	w.setLayout(null);
	w.drawBackground(frame);
 
	Ship ship1 = new Ship(w, frame, 1);
        Ship ship2 = new Ship(w, frame, 2);

	ship1.move(w, frame, 3, 3);
	ship2.move(w, frame, 6, 6);
	
	/*
	CoordinateGrid CD = new CoordinateGrid(20);

	for (int i = 5; i < 10; i++) {
	    CD.alterGrid(HIT,i,5);
	}

	clearScreen();
	CD.printGrid();

	try {
	    Thread.sleep(2000); //1000 ms is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	for (int i = 5; i < 10; i++) {
	    CD.alterGrid(HIT,2,i);
	}
	clearScreen();
	CD.printGrid();
	*/
	
    }
    public static void clearScreen() {  
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }  
	
}
