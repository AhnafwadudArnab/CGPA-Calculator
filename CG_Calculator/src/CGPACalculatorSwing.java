import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CGPACalculatorSwing extends JFrame {

    private JTextField[] subjectFields;
    private JTextField[] creditFields;
    private JLabel[] resultLabels;
    private JButton calculateCGPAButton;

    public CGPACalculatorSwing() {
        setTitle("CGPA Calculator");
        setSize(310, 350);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel[] labels = new JLabel[4];
        JLabel[] creditLabels = new JLabel[4];
        subjectFields = new JTextField[4];
        creditFields = new JTextField[4];
        resultLabels = new JLabel[4];
        calculateCGPAButton = new JButton("Calculate CGPA");

        for (int i = 0; i < 4; i++) {
            labels[i] = new JLabel("Marks " + (i + 1) + ": ");
            subjectFields[i] = new JTextField(4);
            creditLabels[i] = new JLabel("Credits " + (i + 1) + ": ");
            creditFields[i] = new JTextField(4);
            resultLabels[i] = new JLabel("Grade " + (i + 1) + ": ");

            panel.add(creditLabels[i]);
            panel.add(creditFields[i]);
            panel.add(labels[i]);
            panel.add(subjectFields[i]);
            panel.add(resultLabels[i]);
        }

        calculateCGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] marks = new int[4];
                    int[] credits = new int[4];

                    for (int i = 0; i < 4; i++) {
                        marks[i] = Integer.parseInt(subjectFields[i].getText());
                        credits[i] = Integer.parseInt(creditFields[i].getText());
                        resultLabels[i].setText("Grade for Subject " + (i + 1) + ": " + calculateGrade(marks[i]));
                    }

                    double cgpa = calculateCGPA(marks, credits);
                    double gpa = calculateGPA(marks, credits);

                    DecimalFormat df = new DecimalFormat("#.###");
                    resultLabels[3].setText("Your GPA is: " + df.format(gpa) + " | Your CGPA is: " + df.format(cgpa));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
                }
            }
        });

        panel.add(calculateCGPAButton);
        add(panel);
        setVisible(true);
    }

    private static String calculateGrade(int marks) {
        if (marks >= 90) {
            return "A (Plain)";
        } else if (marks >= 86 && marks <= 89) {
            return "A- (Minus)";
        } else if (marks >= 82 && marks <= 85) {
            return "B+ (Plus)";
        } else if (marks >= 78 && marks <= 81) {
            return "B (Plain)";
        } else if (marks >= 74 && marks <= 77) {
            return "B- (Minus)";
        } else if (marks >= 70 && marks <= 73) {
            return "C+ (Plus)";
        } else if (marks >= 66 && marks <= 69) {
            return "C (Plain)";
        } else if (marks >= 62 && marks <= 65) {
            return "C- (Minus)";
        } else if (marks >= 58 && marks <= 61) {
            return "D+ (Plus)";
        } else if (marks >= 55 && marks <= 57) {
            return "D (Plain)";
        } else {
            return "F";
        }
    }

    private static double calculateCGPA(int[] marks, int[] credits) {
        double totalGradePoints = 0;
        double totalCredits = 0;

        for (int i = 0; i < 4; i++) {
            double gradePoints = convertToGradePoints(calculateGrade(marks[i])); // Modify as needed
            totalGradePoints += gradePoints * credits[i];
            totalCredits += credits[i];
        }

        return totalGradePoints / totalCredits;
    }

    private static double calculateGPA(int[] marks, int[] credits) {
        double totalGradePoints = 0;
        double totalCredits = 0;

        for (int i = 0; i < 4; i++) {
            double gradePoints = convertToGradePoints(calculateGrade(marks[i])); // Modify as needed
            totalGradePoints += gradePoints * credits[i];
            totalCredits += credits[i];
        }

        return totalGradePoints / totalCredits;
    }

    // Convert letter grade to grade points (modify based on your grading scale)
    private static double convertToGradePoints(String letterGrade) {
        // Add your conversion logic here
        // Define grade points for each grade based on your institution's scale
        // This is a basic example; you need to tailor it to your grading scale
        switch (letterGrade) {
            case "A (Plain)": return 4.0;
            case "A- (Minus)": return 3.7;
            case "B+ (Plus)": return 3.3;
            case "B (Plain)": return 3.0;
            case "B- (Minus)": return 2.7;
            case "C+ (Plus)": return 2.3;
            case "C (Plain)": return 2.0;
            case "C- (Minus)": return 1.7;
            case "D+ (Plus)": return 1.3;
            case "D (Plain)": return 1.0;
            default: return 0.0; // Default to 0.0 for unrecognized grades
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGPACalculatorSwing();
            }
        });
    }
}
