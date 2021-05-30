import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("RectangleFind");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        RectangleFind controller = new RectangleFind();
        controller.buildUI(f.getContentPane());
        f.pack();
        f.setVisible(true);
    }
}
