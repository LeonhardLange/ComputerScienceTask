package MrThompson;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame{
    private JPanel Login;
    private JPasswordField passwordField;
    private JButton btnConfirm;
    String pass;
    public UI() {
        setContentPane(Login);
        setTitle("Pythagoras");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pass = passwordField.getText();
                System.out.println(pass);

                if (pass.equals("1234")) {
                    System.out.println("yes");
                    MainGUI mainGUI = new MainGUI();
                    setVisible(false);
                    dispose();
                }
            }
        });


    }
}


