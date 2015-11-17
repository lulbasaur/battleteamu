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

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;

public class Window  extends JFrame{
    public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;

  // Create a constructor method
  public Window(){
    // All we do is call JFrame's constructor.
    // We don't need anything special for this
    // program.
    super();
  }

  // The following methods are instance methods.
  /* Create a paint() method to override the one in JFrame.
     This is where the drawing happens. 
     We don't have to call it in our program, it gets called
     automatically whenever the frame needs to be redrawn,
     like when it it made visible or moved or whatever.*/
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setPaint(Color.gray);
    int x1 = 0;
    int y1 = 0;
    
    int x2 = CANVAS_WIDTH;
    int y2 = CANVAS_HEIGHT;
    // fill RoundRectangle2D.Double
    GradientPaint redtowhite = new GradientPaint(x1, y1, Color.pink, y2/8, x2/8, Color.blue,true);
    g2.setPaint(redtowhite);
    g2.fill(new RoundRectangle2D.Double(x1, y1, x2, y2, 0, 200));
    g2.setPaint(Color.black);

  }

  public static void main(String arg[]){
    // create an identifier named 'window' and
    // apply it to a new BasicFrame object
    // created using our constructor, above.
    Window frame = new Window();
    // Use the setSize method that our BasicFrame
    // object inherited to make the frame
    // 200 pixels wide and high.
    frame.setSize(CANVAS_WIDTH,CANVAS_HEIGHT);
    
    // Make the window show on the screen.
    frame.setVisible(true);
  }
}
