import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Ship {

    private int player = 1;
    private int xCoord = 0;
    private int yCoord = 0;
    
    Ship(GUI g, JFrame frame, int player){
	this.player = player;
	if (this.player == 1) {
	    g.placeShip1(frame);
	}
	if (this.player == 2) {
	    g.placeShip2(frame);
	}
    }

    public void move(GUI g, JFrame frame, int x, int y) {
	if (this.player == 1) {
	    g.moveShip1(frame, x, y);
	}
	if (this.player == 2) {
	    g.moveShip2(frame, x, y);
	}
	this.xCoord = x;
	this.yCoord = y;
    }
    
}
