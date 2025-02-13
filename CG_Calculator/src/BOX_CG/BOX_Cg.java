package BOX_CG;

import javax.swing.*;

public class BOX_Cg extends JFrame {

    JFrame mainFrame = new JFrame();
    JButton a1 = new JButton("CGPA calculte ");
    JTextField subject = new JTextField();
    JTextField Credit = new JTextField();
    JTextField marks = new JTextField();
    JButton calculateCGPAButton = new JButton("Calculate CGPA");

    public BOX_Cg() {

        mainFrame.setTitle("CGPA Calculator");
        mainFrame.setSize(310, 350);
        mainFrame.setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel[] labels = new JLabel[4];
        JLabel[] creditLabels = new JLabel[4];


        mainFrame.setVisible(true);
        add(panel);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BOX_Cg();
            }
        });
    }
}