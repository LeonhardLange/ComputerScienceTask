package MrThompson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends PAndE {
    private JButton gradesButton;
    private JButton participationAndEngagementButton;
    private JButton attendanceButton;
    private JPanel Poggers;
    public MainGUI() {
        setContentPane(Poggers);
        setTitle("Menu");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        attendanceButton.addActionListener(new ActionListener() { //Button that leads to Attendance page.
            @Override
            public void actionPerformed(ActionEvent e) {
                Attendance attendance = new Attendance(); //Opens the Attendance page
                setVisible(false); //Makes the current page invisible
                dispose(); //Closes the current page
            }
        });
        participationAndEngagementButton.addActionListener(new ActionListener() { //Button that leads to Engagement page.
            @Override
            public void actionPerformed(ActionEvent e) {
                PAndE pAndE = new PAndE(); //Opens the Engagement page
                setVisible(false); //Makes the current page invisible
                dispose(); //Closes the current page
            }
        });

        gradesButton.addActionListener(new ActionListener() { //Button that leads to Grades page.
            @Override
            public void actionPerformed(ActionEvent e) {
                Grades grades = new Grades(); //Opens the Grades Page
                setVisible(false); //Makes the current page invisible
                dispose(); //Closes the current page
            }
        });
    }
}
