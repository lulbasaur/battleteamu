import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Window extends JFrame {
  Window() {
    add(new ContentPanel());
    setSize(640, 480);
  }

  public static void main(String[] args) {
    Window jrframe = new Window();

    JPanel newPanel = new JPanel(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.WEST;
    constraints.insets = new Insets(10, 10, 10, 10);
    constraints.gridx = 0;
    constraints.gridy = 0;
    

    ImageIcon image = new ImageIcon("test.png");
    JLabel label = new JLabel("", image, JLabel.CENTER);
    JPanel panel = new JPanel(new BorderLayout());
    jrframe.add( label, BorderLayout.CENTER );
    
    jrframe.setVisible(true);
  }

}

class ContentPanel extends JPanel {
  Image bgimage = null;

  ContentPanel() {
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage("bg.jpg");
    mt.addImage(bgimage, 0);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int imwidth = bgimage.getWidth(null);
    int imheight = bgimage.getHeight(null);
    g.drawImage(bgimage, 0, 0, null);
  }
}
