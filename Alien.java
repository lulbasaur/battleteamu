import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Alien {

    private int xCoord = 0;
    private int yCoord = 0;

    Alien(GUI g, JFrame frame) {
	g.placeAlien(frame);
    }

    public void move(GUI g, JFrame frame, int x, int y) {
	g.moveAlien(frame, x, y);
	this.xCoord = x;
	this.yCoord = y;
    }

}
