import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {

    private JTextField subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;
    private JButton calculateButton, resetButton;
    private JLabel totalLabel, averageLabel, gradeLabel;

    public StudentGradeCalculator() {
        // Set up the JFrame
        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));  // Added padding for a better look

        // Set background color for the JFrame
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue color

        // Initialize components
        JLabel subject1Label = new JLabel("Enter marks for Subject 1:");
        subject1Field = new JTextField();
        JLabel subject2Label = new JLabel("Enter marks for Subject 2:");
        subject2Field = new JTextField();
        JLabel subject3Label = new JLabel("Enter marks for Subject 3:");
        subject3Field = new JTextField();
        JLabel subject4Label = new JLabel("Enter marks for Subject 4:");
        subject4Field = new JTextField();
        JLabel subject5Label = new JLabel("Enter marks for Subject 5:");
        subject5Field = new JTextField();

        // Customize buttons
        calculateButton = new JButton("Calculate");
        calculateButton.setBackground(new Color(60, 179, 113)); // Medium sea green color
        calculateButton.setForeground(Color.WHITE);
        resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(255, 69, 0)); // Red-orange color
        resetButton.setForeground(Color.WHITE);
        
        // Customize labels
        totalLabel = new JLabel("Total Marks: ");
        averageLabel = new JLabel("Average Marks: ");
        gradeLabel = new JLabel("Grade: ");
        
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gradeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Add components to the JFrame
        add(subject1Label);
        add(subject1Field);
        add(subject2Label);
        add(subject2Field);
        add(subject3Label);
        add(subject3Field);
        add(subject4Label);
        add(subject4Field);
        add(subject5Label);
        add(subject5Field);
        add(calculateButton);
        add(resetButton);
        add(totalLabel);
        add(averageLabel);
        add(gradeLabel);

        // Add action listeners
        calculateButton.addActionListener(new CalculateButtonListener());
        resetButton.addActionListener(new ResetButtonListener());
    }

    // Action listener for the Calculate button
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Validate inputs and handle empty or invalid fields
                int subject1 = getValidMarks(subject1Field);
                int subject2 = getValidMarks(subject2Field);
                int subject3 = getValidMarks(subject3Field);
                int subject4 = getValidMarks(subject4Field);
                int subject5 = getValidMarks(subject5Field);

                // Calculate total and average
                int total = subject1 + subject2 + subject3 + subject4 + subject5;
                double average = total / 5.0;

                // Determine grade
                String grade;
                if (average >= 90) {
                    grade = "A";
                } else if (average >= 80) {
                    grade = "B";
                } else if (average >= 70) {
                    grade = "C";
                } else if (average >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                // Display results with custom colors
                totalLabel.setText("Total Marks: " + total);
                averageLabel.setText("Average Marks: " + String.format("%.2f", average));
                gradeLabel.setText("Grade: " + grade);

                // Change color based on grade
                if (grade.equals("A")) {
                    gradeLabel.setForeground(Color.GREEN);
                } else if (grade.equals("B") || grade.equals("C")) {
                    gradeLabel.setForeground(Color.ORANGE);
                } else {
                    gradeLabel.setForeground(Color.RED);
                }

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Helper method to validate and get marks
        private int getValidMarks(JTextField textField) throws IllegalArgumentException {
            String text = textField.getText().trim();
            if (text.isEmpty()) {
                throw new IllegalArgumentException("Please fill in all fields.");
            }
            try {
                int marks = Integer.parseInt(text);
                if (marks < 0 || marks > 100) {
                    throw new IllegalArgumentException("Marks should be between 0 and 100.");
                }
                return marks;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Please enter valid numbers only.");
            }
        }
    }

    // Action listener for the Reset button
    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all input fields and labels
            subject1Field.setText("");
            subject2Field.setText("");
            subject3Field.setText("");
            subject4Field.setText("");
            subject5Field.setText("");
            totalLabel.setText("Total Marks: ");
            averageLabel.setText("Average Marks: ");
            gradeLabel.setText("Grade: ");
            gradeLabel.setForeground(Color.BLACK); // Reset grade color to default
        }
    }

    public static void main(String[] args) {
        // Run the GUI in the event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            StudentGradeCalculator calculator = new StudentGradeCalculator();
            calculator.setVisible(true);
        });
    }
}
