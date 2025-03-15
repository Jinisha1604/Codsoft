import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fee extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    JTextArea area1, area2;
    JRadioButton r5, r6, rb1, rb2, rb3, rb4;
    JButton b, Receipt, b2, Print;

    Fee() {
        // Title Label with a nice color and font style
        l1 = new JLabel("Fee Report");
        l1.setBounds(550, 100, 250, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setForeground(Color.BLUE);

        // Creating Labels and Text Fields with custom styles
        l2 = new JLabel("Name of the Student:");
        l2.setBounds(50, 150, 250, 20);
        l2.setFont(new Font("Arial", Font.PLAIN, 16));
        tf1 = new JTextField();
        tf1.setBounds(250, 150, 250, 20);
        tf1.setBackground(Color.LIGHT_GRAY);

        l3 = new JLabel("Name of the Father:");
        l3.setBounds(50, 200, 250, 20);
        l3.setFont(new Font("Arial", Font.PLAIN, 16));
        tf2 = new JTextField();
        tf2.setBounds(250, 200, 250, 20);
        tf2.setBackground(Color.LIGHT_GRAY);

        l4 = new JLabel("Roll Number:");
        l4.setBounds(50, 250, 250, 20);
        l4.setFont(new Font("Arial", Font.PLAIN, 16));
        tf3 = new JTextField();
        tf3.setBounds(250, 250, 250, 20);
        tf3.setBackground(Color.LIGHT_GRAY);

        l5 = new JLabel("Email ID:");
        l5.setBounds(50, 300, 250, 20);
        l5.setFont(new Font("Arial", Font.PLAIN, 16));
        tf4 = new JTextField();
        tf4.setBounds(250, 300, 250, 20);
        tf4.setBackground(Color.LIGHT_GRAY);

        l6 = new JLabel("Contact Number:");
        l6.setBounds(50, 350, 250, 20);
        l6.setFont(new Font("Arial", Font.PLAIN, 16));
        tf5 = new JTextField();
        tf5.setBounds(250, 350, 250, 20);
        tf5.setBackground(Color.LIGHT_GRAY);

        l7 = new JLabel("Address:");
        l7.setBounds(50, 400, 250, 20);
        l7.setFont(new Font("Arial", Font.PLAIN, 16));
        area1 = new JTextArea();
        area1.setBounds(250, 400, 250, 90);
        area1.setBackground(Color.LIGHT_GRAY);

        // Gender Selection with color change
        l9 = new JLabel("Gender:");
        l9.setBounds(50, 500, 250, 20);
        l9.setFont(new Font("Arial", Font.PLAIN, 16));

        r5 = new JRadioButton("Male");
        r6 = new JRadioButton("Female");
        r5.setBounds(250, 500, 100, 30);
        r6.setBounds(350, 500, 100, 30);
        r5.setFont(new Font("Arial", Font.PLAIN, 14));
        r6.setFont(new Font("Arial", Font.PLAIN, 14));
        r5.setBackground(Color.CYAN);
        r6.setBackground(Color.CYAN);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r5);
        bg.add(r6);

        // Nationality and other inputs
        l10 = new JLabel("Nationality:");
        l10.setBounds(50, 550, 250, 20);
        tf6 = new JTextField();
        tf6.setBounds(250, 550, 250, 20);
        tf6.setBackground(Color.LIGHT_GRAY);

        l11 = new JLabel("Year of passing 10th");
        l11.setBounds(50, 600, 250, 20);
        String[] language = {"2016", "2015", "2014"};
        final JComboBox<String> cb1 = new JComboBox<>(language);
        cb1.setBounds(250, 600, 90, 20);

        l12 = new JLabel("Year of passing 12th");
        l12.setBounds(50, 650, 250, 20);

        String[] languagess = {"2019", "2018", "2017"};
        l13 = new JLabel("Points Secured in 10th:");
        l13.setBounds(50, 700, 250, 20);
        tf7 = new JTextField();
        tf7.setBounds(250, 700, 250, 20);
        tf7.setBackground(Color.LIGHT_GRAY);

        l14 = new JLabel("Percentage in 12th:");
        l14.setBounds(50, 750, 250, 20);
        tf8 = new JTextField();
        tf8.setBounds(250, 750, 250, 20);
        tf8.setBackground(Color.LIGHT_GRAY);

        // Groups Offered with color changes
        l8 = new JLabel("Groups Offered here are:");
        l8.setBounds(800, 150, 250, 20);
        l8.setFont(new Font("Arial", Font.PLAIN, 16));

        rb1 = new JRadioButton("SEAS");
        rb2 = new JRadioButton("SLABS");
        rb1.setBounds(550, 150, 100, 30);
        rb2.setBounds(650, 150, 100, 30);
        rb1.setFont(new Font("Arial", Font.PLAIN, 14));
        rb2.setFont(new Font("Arial", Font.PLAIN, 14));
        rb1.setBackground(Color.CYAN);
        rb2.setBackground(Color.CYAN);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        rb3 = new JRadioButton("HOSTELLER");
        rb4 = new JRadioButton("DAY SCHOLAR");
        rb3.setBounds(550, 200, 120, 30);
        rb4.setBounds(650, 200, 150, 30);
        rb3.setFont(new Font("Arial", Font.PLAIN, 14));
        rb4.setFont(new Font("Arial", Font.PLAIN, 14));
        rb3.setBackground(Color.CYAN);
        rb4.setBackground(Color.CYAN);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rb3);
        bg2.add(rb4);

        // Button to Show and generate receipt
        b = new JButton("Show");
        b.setBounds(1000, 300, 80, 30);
        b.setBackground(Color.GREEN);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (rb1.isSelected()) {
                    data += "Wants to Join in SEAS\n";
                }
                if (rb2.isSelected()) {
                    data += "Wants to Join in SLABS\n";
                }
                if (rb3.isSelected()) {
                    data += "Wants to be a Hosteller\n";
                }
                if (rb4.isSelected()) {
                    data += "Wants to be a Day Scholar\n";
                }
                JOptionPane.showMessageDialog(Fee.this, data);
            }
        });

        // Generate Receipt
        Receipt = new JButton("Generate Receipt");
        Receipt.setBounds(600, 490, 150, 30);
        Receipt.setBackground(Color.BLUE);
        Receipt.setForeground(Color.WHITE);
        Receipt.setFont(new Font("Arial", Font.BOLD, 14));
        Receipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area1.setText("Generating Receipt...");
            }
        });

        // Reset Button
        b2 = new JButton("Reset");
        b2.setBounds(750, 490, 150, 30);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");
                tf7.setText("");
                tf8.setText("");
                area1.setText("");
            }
        });

        // Print Button
        Print = new JButton("Print");
        Print.setBounds(900, 490, 150, 30);
        Print.setBackground(Color.RED);
        Print.setForeground(Color.WHITE);
        Print.setFont(new Font("Arial", Font.BOLD, 14));
        Print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    area1.print();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Adding components to the JFrame
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);
        add(area1);
        add(b);
        add(Receipt);
        add(b2);
        add(Print);
        add(r5);
        add(r6);
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        add(cb1);

        // JFrame settings
        setSize(1200, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN); // Background color for JFrame
    }

    public static void main(String[] args) {
        new Fee();
    }
}
