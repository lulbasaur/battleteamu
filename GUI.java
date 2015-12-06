import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GUI extends JPanel {

    private Image bg;
    private JLabel ship1 = new JLabel(new ImageIcon("graphics/ship1.png"));
    private JLabel ship2 = new JLabel(new ImageIcon("graphics/ship2.png"));

    private JLabel lazerShip1 = new JLabel(new ImageIcon("graphics/lazer.png"));
    private JLabel lazerShip2 = new JLabel(new ImageIcon("graphics/lazer.png"));
    
    private int numberOfAliens = 20;

    private JLabel[] alienArray = generateAliens(numberOfAliens);

    private static final int EMPTY = 0;
    private static final int SHIP1 = 1;
    private static final int SHIP2 = 2;
    private static final int ALIEN = 3;
    private static final int LAZER = 4;

    public JLabel[] generateAliens(int numberOfAliens) {
	int c = 0;
	JLabel[] alienArray = new JLabel[numberOfAliens];
	while (c < numberOfAliens) {
	    JLabel alien = new JLabel(new ImageIcon("graphics/alien.png"));
	    alienArray[c] = alien;
	    c++;
	}
	return alienArray;
    }
    
    public void updateFrame(JFrame frame, Coordinate[] cV) {
	int c = 0;
	while (c < cV.length) {
	    switch (cV[c].getObjectType())
		{
		case EMPTY:  drawEmpty(frame, cV[c]);

		    break;
		case SHIP1:  drawShip1(frame, cV[c]);

		    break;
		case SHIP2:  drawShip2(frame, cV[c]);

		    break;
		case ALIEN:  drawAlien(frame, cV[c]); 

		    break;
		case LAZER:  drawLazer(frame, cV[c]);

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

    public void drawEmpty(JFrame frame, Coordinate c) {
	int x = c.getX() * 30;
	int y = c.getY() * 30;

	JLabel empty = new JLabel(new ImageIcon());
	empty.setSize(30, 30);
	empty.setLocation(x, y);
	this.add(empty);

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }
    
    public void drawShip1(JFrame frame, Coordinate c) {
	int x = c.getX() * 30;
	int y = c.getY() * 30;

	this.ship1.setIcon(new ImageIcon());
        this.ship1 = new JLabel(new ImageIcon("graphics/ship1.png"));
	ship1.setSize(30, 30);
	ship1.setLocation(x, y); //x = 9, y = 15
	this.add(ship1);

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void drawShip2(JFrame frame, Coordinate c) {
	int x = c.getX() * 30;
	int y = c.getY() * 30;

	this.ship2.setIcon(new ImageIcon());
	this.ship2 = new JLabel(new ImageIcon("graphics/ship2.png"));
	ship2.setSize(30, 30);
	ship2.setLocation(x, y);
	this.add(ship2);

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void drawAlien(JFrame frame, Coordinate c) {
	int x = c.getX() * 30;
	int y = c.getY() * 30;
	int alienNumber = c.getAlienNumber();
	
	this.alienArray[alienNumber].setIcon(new ImageIcon());

	if (c.isAlive()) {
	    this.alienArray[alienNumber] = new JLabel(new ImageIcon("graphics/alien.png"));
	    this.alienArray[alienNumber].setSize(30, 30);
	    this.alienArray[alienNumber].setLocation(x, y);
	    this.add(this.alienArray[alienNumber]);
	}

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void drawLazer(JFrame frame, Coordinate c) {
	int x = c.getX() * 30;
	int y = c.getY() * 30;

	if (c.isLazer1()) {
	    this.lazerShip1.setIcon(new ImageIcon());
	    this.lazerShip1 = new JLabel(new ImageIcon("graphics/lazer.png"));
	    lazerShip1.setSize(30, 30);
	    lazerShip1.setLocation(x, y);
	    this.add(lazerShip1);
	}
	else {
	    this.lazerShip2.setIcon(new ImageIcon());
	    this.lazerShip2 = new JLabel(new ImageIcon("graphics/lazer.png"));
	    lazerShip2.setSize(30, 30);
	    lazerShip2.setLocation(x, y);
	    this.add(lazerShip2);
	}

	frame.add(this);
	frame.pack();
	repaint();
	frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
    	g.drawImage(bg, 0, 0, null);
    }
}
