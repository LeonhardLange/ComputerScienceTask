package MrThompson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Analytics extends JFrame {
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton analyseButton;
    private JPanel analy;

    public Analytics() {
        setContentPane(analy);
        setTitle("Menu");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        analyseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minspin = (int) spinner1.getValue();
                int maxspin = (int) spinner2.getValue();
                
            }
        });
    }
}
