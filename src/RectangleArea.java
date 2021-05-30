import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class RectangleArea extends JPanel {

    RectangleFind controller;
    Dimension preferredSize = new Dimension(600,450);
    public int displayedRect = 6;

    public RectangleArea(RectangleFind controller) {
        this.controller = controller;

        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder
                (raisedBevel, loweredBevel);
        setBorder(compound);

    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  //paint background

        final ConvexHull hull = this.controller.polygon;

        GeomPoint point;
        GeomPoint prevPoint = null;

        for(int i=0; i<hull.size(); i++){

            if(i==0){
                prevPoint = (GeomPoint)hull.elementAt(hull.size()-1);
            }

            point = (GeomPoint)hull.elementAt(i);

            g.setColor(Color.black);
            g.fillOval(point.x-2, point.y-2, 5, 5);

            if(prevPoint != null){
                g.fillOval(prevPoint.x-2, prevPoint.y-2,5,5);
                g.drawLine(point.x, point.y, prevPoint.x, prevPoint.y);
            }
            prevPoint = point;
        }
        if(hull.rectp !=null){
            if (displayedRect ==6){
                g.setColor(Color.red);
            }
            else{
                g.setColor(Color.magenta);
            }
            Rectangle lr = (Rectangle)hull.RectList.elementAt(displayedRect);

            g.drawRect(lr.x,lr.y, lr.width, lr.height);
            g.fillRect(lr.x,lr.y, lr.width, lr.height);
        }

        controller.updateLabel(hull.status);

    }
}