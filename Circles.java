import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Circles extends JComponent {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new Circles());

    frame.setVisible(true);
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Ellipse2D old = new Ellipse2D.Double(25, 25, 75, 75);
    System.out.println("Old: " + old.getCenterX() + ", " + old.getCenterY());
    Ellipse2D point = new Ellipse2D.Double(100, 150, 2, 2);
    System.out.println("Point: " + point.getCenterX() + ", " + point.getCenterY());

    double bearing = Math.atan2(old.getCenterX() - point.getCenterX(),
                                old.getCenterY() - point.getCenterY());
    System.out.println(Math.toDegrees(bearing));
    double distance = Point2D.distance(old.getCenterX(), old.getCenterY(),
                                       point.getCenterX(), point.getCenterY());
    double radius = (distance + (old.getHeight() / 2)) / 2;
    double dx = point.getCenterX() + radius * Math.sin(bearing);
    double dy = point.getCenterY() + radius * Math.cos(bearing);
    Ellipse2D inclusive = new Ellipse2D.Double(dx - radius, dy - radius,
                                               2 * radius, 2 * radius);
    g2.setColor(Color.red);
    g2.draw(old);
    g2.draw(point);
    g2.draw(inclusive);
  }
}
