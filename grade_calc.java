import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class milanparmar extends JFrame implements ActionListener {
    JLabel bioLabel = new JLabel("BIO:      ");
    JLabel mathLabel = new JLabel("MATH:   ");
    JLabel statLabel = new JLabel("STAT:    ");
    JLabel engLabel = new JLabel("ENG:     ");
    JLabel avgLabel = new JLabel("Average: ");

    // input field
    JTextField bioData = new JTextField(10);
    JTextField mathData = new JTextField(10);
    JTextField statData = new JTextField(10);
    JTextField engData = new JTextField(10);

    // new panel for every label 
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();

    // panels broken into three sections
    JPanel pnLeft = new JPanel();
    JPanel pnMiddle = new JPanel();
    JPanel pnRight = new JPanel();
        
    JButton aButton = new JButton("Calculate"); // action button for "Calculate"

    milanparmar(String title) {
        super(title);   // adds title to parent class
        
        aButton.setActionCommand("button1");
        aButton.addActionListener(this);        

        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));      // align left
        panel1.add(bioLabel);
        panel1.add(bioData);

        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));      // align left
        panel2.add(mathLabel);
        panel2.add(mathData);

        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));      // align left
        panel3.add(statLabel);
        panel3.add(statData);

        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));      // align left
        panel4.add(engLabel);
        panel4.add(engData);

        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));      // align left
        panel5.add(avgLabel);

        panel6.setLayout(new FlowLayout(FlowLayout.CENTER));    // align center 
        panel6.add(aButton);

        // set layout manager for left panel, add two small panels to it
        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        pnLeft.add(panel1);
        pnLeft.add(panel2);

        // set layout manager for middle panel, add two small panels to it
        pnMiddle.setLayout(new BoxLayout(pnMiddle, BoxLayout.Y_AXIS));
        pnMiddle.add(panel3);
        pnMiddle.add(panel4);

        // set layout manager for right panel, add two small panels to it
        pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
        pnRight.add(panel5);
        pnRight.add(panel6);

        // final layout which lets all components to adjust to page size
        setLayout(new FlowLayout());
        add(pnLeft);
        add(pnMiddle);
        add(pnRight);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        milanparmar frame = new milanparmar("Average Grade Calculator");
        frame.setSize(250, 250);    // 250x250px size
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // gets text input
        String bio_input = bioData.getText();
        String math_input = mathData.getText();
        String stat_input = statData.getText();
        String eng_input = engData.getText();

        ImageIcon img = new ImageIcon("error.png");     // error image import

        // isEmpty() checks for no input and "\\d+" sees if the input is a digit or not
        if (bio_input.isEmpty() || !bio_input.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Wrong input value!", "Grade Calculator", JOptionPane.INFORMATION_MESSAGE, img);
        }
        else if (math_input.isEmpty() || !math_input.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Wrong input value!", "Grade Calculator", JOptionPane.INFORMATION_MESSAGE, img);
        }
        else if (stat_input.isEmpty() || !stat_input.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Wrong input value!", "Grade Calculator", JOptionPane.INFORMATION_MESSAGE, img);
        }
        else if (eng_input.isEmpty() || !eng_input.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Wrong input value!", "Grade Calculator", JOptionPane.INFORMATION_MESSAGE, img);
        }
        else {            
            // if input is a number, convert String to Integer
            float bio = Float.parseFloat(bio_input);
            float math = Float.parseFloat(math_input);
            float stat = Float.parseFloat(stat_input);
            float eng = Float.parseFloat(eng_input);

            float avg = (bio + math + stat + eng) / 4;    // calcalate average

            avgLabel.setText("Average: " + String.valueOf(avg));
        }
    }
}