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
