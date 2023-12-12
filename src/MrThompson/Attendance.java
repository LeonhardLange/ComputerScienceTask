package MrThompson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;


public class Attendance extends JFrame{
    private JPanel panel1;
    private JButton backButton;
    private JTable table1;
    private JButton addStudentsButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton newDayButton;
    private JButton previousDayButton;
    private JTextArea textArea1;
    String dayCount = "";
    public Attendance() { //Creates the page
        setContentPane(panel1);
        setTitle("Attendance Manager");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        createTable();
        FileReader dayTrack = null;
        try {
            dayTrack = new FileReader("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\dayTracker.txt");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        Scanner days = new Scanner(dayTrack);
        dayCount = days.nextLine();
        days.close();
        textArea1.setText("Editing day: " + dayCount);

        backButton.addActionListener(new ActionListener() { //Controls what the "back" button does
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI mainGUI = new MainGUI(); //Takes user back to the MainGUI page
                setVisible(false); //Makes the current page invisible
                dispose(); //Closes the current page
            }
        });
        addStudentsButton.addActionListener(new ActionListener() { //Button which the user uses to increase the table size.
            @Override
            public void actionPerformed(ActionEvent e) {
                AttendSize attendSize = new AttendSize(); //Opens the AttendSize page
                setVisible(false);
                dispose(); //Hides and closes current page
            }
        });
        saveButton.addActionListener(new ActionListener() { //Button to save table values to file
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableRow = "";
                String nameRow = " "; //Filler declarations
                String presentRow = " ";
                for (int i = 0;i < AttendSize.arrSize; i ++) { //for every row in the table
                    if (table1.getModel().getValueAt(i, 0) == null) { //If the field is empty save it as empty
                        nameRow = " ";
                        presentRow = " ";
                    }   else if (table1.getModel().getValueAt(i, 1) == null) { //If the field is empty save it as empty
                        nameRow = " ";
                        presentRow = " ";
                    }   else {
                        nameRow = (String) table1.getModel().getValueAt(i, 0); //Save the field value of the first column
                        presentRow = (String) table1.getModel().getValueAt(i, 1); //Save the field value of the second column
                    }
                    tableRow = tableRow + nameRow + ":" + presentRow + "\n"; //Splits the two values with a ":" and moves down a line
                }
                try {
                    FileWriter file = new FileWriter("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\config" + dayCount + "txt");
                    file.write(tableRow); //Writes the saved values to config.txt
                    file.close();
                } catch (IOException ioe) { //In case of error
                    System.out.println(ioe);
                }

            }
        });
        loadButton.addActionListener(new ActionListener() { //Button to load values from file
            @Override
            public void actionPerformed(ActionEvent e) {
                FileReader file = null;
                FileReader file2 = null; //Filler declarations
                System.out.println(dayCount);
                try {
                    file = new FileReader("C:\\\\Users\\\\xenia\\\\IdeaProjects\\\\MrThompson\\\\src\\\\MrThompson\\\\config" + dayCount + "txt");
                    file2 = new FileReader("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\config" + dayCount + "txt");
                } catch (FileNotFoundException ex) {
                    System.out.println("File does not exist!");
                    throw new RuntimeException(ex);
                }
                Scanner repeat = new Scanner(file);
                Scanner reader = new Scanner(file2);
                int y = 0;
                while (repeat.hasNextLine()) { //Finds the needed table size to fit all data
                    repeat.nextLine(); //Iterates through all lines till none available
                    y++;
                }
                String[][] dataInput = new String[y][2]; //Creates 2d in which values will be stored
                int x = 0;
                while (reader.hasNextLine()) {
                    String data2 = reader.nextLine();
                    System.out.println(data2); //Test
                    String[] colonSplit = data2.split(":"); //Splits values by the ":" and saves them in two separate variables
                    String nameRow = colonSplit[0];
                    String attendRow = colonSplit[1];
                    dataInput[x][0] = nameRow; //Writes result to 2d array
                    dataInput[x][1] = attendRow;
                    System.out.println(dataInput[x][0]); //Test
                    System.out.println(dataInput[x][1]); //Test
                    x++;
                }
                table1.setModel(new DefaultTableModel( //Creates table using 2d array
                        dataInput,
                        new String[]{"Name", "Present"} //Specify column names
                ));
            }
        });
        newDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileReader dayTrack = null;
                try {
                    dayTrack = new FileReader("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\dayTracker.txt");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Scanner days = new Scanner(dayTrack);
                dayCount = days.nextLine();
                days.close();
                dayCount = String.valueOf(Integer.parseInt(dayCount) + 1);
                System.out.println(dayCount);
                try {
                    FileWriter file = new FileWriter("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\dayTracker.txt");
                    file.write(dayCount); //Writes the saved values to config.txt
                    file.close();
                } catch (IOException ioe) { //In case of error
                    System.out.println(ioe);
                }
                textArea1.setText("Editing day: " + dayCount);

            }
        });
        previousDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileReader dayTrack = null;
                try {
                    dayTrack = new FileReader("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\dayTracker.txt");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Scanner days = new Scanner(dayTrack);
                dayCount = days.nextLine();
                days.close();
                dayCount = String.valueOf(Integer.parseInt(dayCount) - 1);
                System.out.println(dayCount);
                try {
                    FileWriter file = new FileWriter("C:\\Users\\xenia\\IdeaProjects\\MrThompson\\src\\MrThompson\\dayTracker.txt");
                    file.write(dayCount); //Writes the saved values to config.txt
                    file.close();
                } catch (IOException ioe) { //In case of error
                    System.out.println(ioe);
                }
                textArea1.setText("Editing day: " + dayCount);

            }
        });
    }
    private void createTable() {
        Object[][] data = { //Example values in default table
                {"John", "Absent",}
        };
        int configSize = AttendSize.arrSize;
        data = Arrays.copyOf(data, configSize); //Adds rows to table based on AttendSize setting
        table1.setModel(new DefaultTableModel( //Creates table
                data,
                new String[]{"Name", "Present"} //Column names
        ));
    }
}
