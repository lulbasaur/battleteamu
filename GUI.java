import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GUI extends JPanel {

    private Image bg;
    private JLabel ship1;
    private JLabel ship2;
    private JLabel alien;

    private Ship dummyShip1 = new Ship(1);
    private Ship dummyShip2 = new Ship(2);

    private static final int EMPTY = 0;
    private static final int SHIP1 = 1;
    private static final int SHIP2 = 2;
    private static final int ALIEN = 3;
    private static final int LAZER = 4;
    
    public void updateFrame(JFrame frame, Coordinate[] cV) {
	int c = 0;
	while (c <= cV.length) {
	    switch (cV[c].getObjectType())
		{
		case EMPTY:  

		    break;
		case SHIP1:  moveShip(frame, dummyShip1, cV[c].getX(), cV[c].getY());

		    break;
		case SHIP2:  moveShip(frame, dummyShip2, cV[c].getX(), cV[c].getY());

		    break;
		case ALIEN:  moveAlien(frame, cV[c].getX(), cV[c].getY()); 

		    break;
		case LAZER:  

		    break;
		}   
	    c++;
	}
    }

    public void drawBackground(JFrame frame) {
        this.bg = new ImageIcon("graphics/bg.png").getImage();
	Dimension size = new Dimension(this.bg.getWidth(null),
				       this.bg.getHeight(null));
	setPreferredSize(size);
	setMinimumSize(size);
	setMaximumSize(size);
	setSize(size);
	setLayout(null);
	
	frame.getContentPane().add(this);
	frame.pack();
	frame.setVisible(true);
    }
    
    public void placeAliens(JFrame frame, int width, int height) {
	width = width * 30;
	height = height * 30;
	int cX = 0;
	int cY = 0;
	int positionX = 0;
	int positionY = 0;

	while (positionX < width) {
	    while (positionY < height) {
		JLabel alien;
		alien = new JLabel(new ImageIcon("graphics/alien.png"));
		alien.setSize(30, 30);
		alien.setLocation(positionX, positionY);
		this.add(alien);
		cY++;
		positionY = 30 * cY;
	    }
	    cY = 0;
	    positionY = 0;
	    cX++;
	    positionX = 30 * cX;
	}

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void moveAlien(JFrame frame, int x, int y) {
	alien.setLocation(x*30, y*30);
	repaint();
    }

    public void placeShip(JFrame frame, Ship ship) {
	if (ship.getPlayerNr() == 1) {
	    this.ship1 = new JLabel(new ImageIcon("graphics/ship1.png"));
	    ship1.setSize(30, 30);
	    ship1.setLocation(300, 390);
	    this.add(ship1);
	    ship.setX(10);
	    ship.setY(13);
	}
	else {
	    this.ship2 = new JLabel(new ImageIcon("graphics/ship2.png"));
	    ship2.setSize(30, 30);
	    ship2.setLocation(270, 450); //x = 9, y = 15
	    this.add(ship2);
	    ship.setX(9);
	    ship.setY(15);
	}
	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void moveShip(JFrame frame, Ship ship, int x, int y) {
	if (ship.getPlayerNr() == 1) {
	    ship1.setLocation(x*30, y*30);
	}
	else {
	    ship2.setLocation(x*30, y*30);
	}
	repaint();
    }

    public void paintComponent(Graphics g) {
    	g.drawImage(bg, 0, 0, null);
    }

}
