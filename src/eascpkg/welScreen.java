package eascpkg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class welScreen {

    JWindow splashScreen = new JWindow();

    public welScreen() {
        splashScreen.getContentPane().setBackground(new Color(0, 0, 0, 0));
        ImageIcon icon1 = new ImageIcon("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\clglogo1.png");
        JLabel imglbl = new JLabel(icon1);

        imglbl.setSize(icon1.getIconWidth(), icon1.getIconHeight());
        splashScreen.add(imglbl);
        splashScreen.setSize(icon1.getIconWidth(), icon1.getIconHeight());
        splashScreen.setBackground(new Color(0, 0, 0, 0));
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        int sw = (int) d.getWidth();
        int sh = (int) d.getHeight();
        splashScreen.setLocation((sw - splashScreen.getWidth()) / 2, (sh - splashScreen.getHeight()) / 2);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                splashScreen.dispose(); // Close the splash screen
                new LoginFrame().setVisible(true); // Open the main frame
            }
        }, 2000);
        splashScreen.setVisible(true);
    }

    public static void main(String args[]) {
        new welScreen();
    }
}

