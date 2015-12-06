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

    Ship(int player){
	this.player = player;
    }
    
    Ship(GUI g, JFrame frame, int player){
	this.player = player;
        g.placeShip(frame, this);
    }

    public void move(GUI g, JFrame frame, int x, int y) {
        g.moveShip(frame, this, x, y);
	this.xCoord = x;
	this.yCoord = y;
    }

    public int getPlayerNr() { return player; }

    public void setX(int value) { xCoord = value; }

    public void setY(int value) { yCoord = value; }

    public int getX() { return xCoord; }

    public int getY() { return yCoord; }
    
}
