import javax.swing.*;
import java.awt.*;

public class RectangleFind extends JApplet{
    JLabel label;
    JPanel buttonPane;
    JButton b1;
    JButton b2;
    JButton b3;

    ConvexHull polygon;
    RectangleArea rectangleArea;
    MyListener myListener;

    void buildUI(Container container) {
        container.setLayout(new BoxLayout(container,
                BoxLayout.Y_AXIS));
        label = new JLabel("Click within the framed area.");
        container.add(label);
        polygon = new ConvexHull();
        rectangleArea = new RectangleArea(this);
        myListener = new MyListener(this);
        rectangleArea.addMouseListener(myListener);
        container.add(rectangleArea);
        buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        b1 = new JButton("Reset");
        b1.addActionListener(e -> {
            polygon = new ConvexHull();
            rectangleArea.repaint();
            updateLabel(0);
        });
        b2 = new JButton("Find Largest Rectangle");
        b2.addActionListener(e -> {
            polygon.computeLargestRectangle();
            rectangleArea.displayedRect = 6;
            polygon.status = 16;
            rectangleArea.repaint();
        });
        b3 = new JButton("Step");
        b3.addActionListener(e -> {
            if (polygon.changed){
                polygon.computeLargestRectangle();
            }
            rectangleArea.displayedRect++;
            if (rectangleArea.displayedRect == 7){
                rectangleArea.displayedRect = 0;
            }
            polygon.status = rectangleArea.displayedRect + 10;
            rectangleArea.repaint();
        });
        buttonPane.add(b1);
        buttonPane.add(Box.createHorizontalStrut(10));
        buttonPane.add(b2);
        buttonPane.add(b3);
        container.add(buttonPane);
        rectangleArea.setAlignmentX(LEFT_ALIGNMENT);
        label.setAlignmentX(LEFT_ALIGNMENT);
        buttonPane.setAlignmentX(LEFT_ALIGNMENT);
    }

    public void updateLabel(int msg) {
        if (msg == 0){
            label.setText("Click within the framed area to add points");
        }
        else if (msg == 1){
            label.setText("Point added, click to add more points");
        }
        else if (msg == 2){
            label.setText("point added to polygon");
        }
        else if (msg == 3){
            label.setText("point inside not added");
        }
        else if (msg == 10){
            label.setText("Largest rectangle with corners on A and C only");
        }
        else if (msg == 11){
            label.setText("Largest rectangle with corners on B and D only");
        }
        else if (msg == 12){
            label.setText("Largest rectangle with corners on A,B and C");
        }
        else if (msg == 13){
            label.setText("Largest rectangle with corners on A,B and D");
        }
        else if (msg == 14){
            label.setText("Largest rectangle with corners on A,C and D");
        }
        else if (msg == 15){
            label.setText("Largest rectangle with corners on B,C and D");
        }
        else if (msg == 16){
            label.setText("Largest rectangle in polygon");
        }
        else {
            label.setText("Click to add points");
        }
    }
}