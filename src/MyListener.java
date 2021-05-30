import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

class MyListener extends MouseInputAdapter {
    RectangleFind rf;

    public MyListener(RectangleFind rf){
        this.rf = rf;
    }
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        GeomPoint p = new GeomPoint(x,y);

        if (this.rf.polygon.size() <2){
            this.rf.polygon.add(p);
            this.rf.polygon.status = 1;
            this.rf.polygon.changed = true;
        }

        else if (this.rf.polygon.size() == 2){
            GeomPoint ha = (GeomPoint)this.rf.polygon.elementAt(0);
            GeomPoint hb = (GeomPoint)this.rf.polygon.elementAt(1);
            if (this.rf.polygon.onLeft(ha, hb, p)){
                this.rf.polygon.add(p);
                this.rf.polygon.status = 2;
                this.rf.polygon.changed = true;
            }
            else{
                this.rf.polygon.insertElementAt(p, 1);
                this.rf.polygon.status = 2;
            }
        }
        else{
            if (this.rf.polygon.addPointToHull(p)){
                this.rf.polygon.status = 2;
            }
            else{
                this.rf.polygon.status = 3;
            }
        }
        this.rf.rectangleArea.repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

}