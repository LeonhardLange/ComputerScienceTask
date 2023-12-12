package MrThompson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendSize extends JFrame{
    private JButton confirmButton;
    private JPanel panel5;
    private JSpinner spinner1;
    static int arrSize;
    public AttendSize() {
        setContentPane(panel5);
        setTitle("Pythagoras");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        spinner1.setValue(arrSize);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrSize = (int) spinner1.getValue();
                System.out.println(arrSize);
                Attendance attendance = new Attendance();
                setVisible(false);
                dispose();
            }
        });
    }
}
