/* BasicFrame.java

   This is a really simple graphics program.
   It opens a frame on the screen with a single
   line drawn across it.

   It's not very polished, but it demonstrates
   a graphical program as simply as possible.mag-27Apr2008
*/

// Import the basic graphics classes.
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.event.*;
    
public class Window extends JFrame {
  Window() {
    add(new ContentPanel());
    setSize(640, 480);
  }

  public static void main(String[] args) {
    Window jrframe = new Window();
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
