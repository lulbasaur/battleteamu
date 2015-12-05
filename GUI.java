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
		case SHIP1:  moveShip1(frame, cV[c].getX(), cV[c].getY());

		    break;
		case SHIP2:  moveShip2(frame, cV[c].getX(), cV[c].getY());

		    break;
		case ALIEN:  moveAlien(frame, cV[c].getX(), cV[c].getY()); 

		    break;
		case LAZER:  

		    break;
		}   
	    moveShip1(frame, cV[c].getX(), cV[c].getY());
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
    
    public void placeAlien(JFrame frame) {
	this.alien = new JLabel(new ImageIcon("graphics/alien.png"));
	alien.setSize(30, 30);
	alien.setLocation(300, 100);
	this.add(alien);
	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void moveAlien(JFrame frame, int x, int y) {
	if (x != 0) {
	    x = x * 30;
	}
	if (y != 0) {
	    y = y * 30;
	}
	alien.setLocation(x, y);
	repaint();
    }
    
    public void placeShip1(JFrame frame) {
	this.ship1 = new JLabel(new ImageIcon("graphics/ship1.png"));
	ship1.setSize(30, 30);
	ship1.setLocation(300, 400);
	this.add(ship1);
	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void placeShip2(JFrame frame) {
	this.ship2 = new JLabel(new ImageIcon("graphics/ship2.png"));
	ship2.setSize(30, 30);
	ship2.setLocation(270, 500);
	this.add(ship2);
	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void moveShip1(JFrame frame, int x, int y) {
	if (x != 0) {
	    x = x * 30;
	}
	if (y != 0) {
	    y = y * 30;
	}
	ship1.setLocation(x, y);
	repaint();
    }

    public void moveShip2(JFrame frame, int x, int y) {
	if (x != 0) {
	    x = x * 30;
	}
	if (y != 0) {
	    y = y * 30;
	}
	ship2.setLocation(x, y);
	repaint();
    }

    public void paintComponent(Graphics g) {
    	g.drawImage(bg, 0, 0, null);
    }

}
