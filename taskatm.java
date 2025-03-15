import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {

    private double balance = 1000.00;
    private final JLabel imageLabel;
    private final JTextField pinField;
    private final JLabel statusLabel;
    private final JButton loginButton, checkBalanceButton, depositButton, withdrawButton, logoutButton;

    public ATMInterface() {
        // Set up the JFrame
        setTitle("ATM Interface");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the image and text input
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(new Color(224, 255, 255)); // Light cyan background

        // Load and set the ATM image
        ImageIcon atmIcon = new ImageIcon("\"C:\\Users\\jinisha sharma\\OneDrive\\codsoft\\atm codsoft.jpg\"");  // Add your image path here
        imageLabel = new JLabel(atmIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the image to the panel
        topPanel.add(imageLabel);

        // Create a panel for PIN entry
        JPanel pinPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        pinPanel.setBackground(new Color(224, 255, 255));
        JLabel pinLabel = new JLabel("Enter PIN:");
        pinField = new JTextField();
        pinPanel.add(pinLabel);
        pinPanel.add(pinField);
        topPanel.add(pinPanel);

        add(topPanel, BorderLayout.NORTH);

        // Create the status label
        statusLabel = new JLabel("Please enter your PIN to log in.", JLabel.CENTER);
        statusLabel.setForeground(Color.BLUE);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(statusLabel, BorderLayout.CENTER);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBackground(new Color(224, 255, 255));

        // Initialize buttons
        loginButton = new JButton("Log In");
        checkBalanceButton = new JButton("Check Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        logoutButton = new JButton("Log Out");

        // Set button colors
        loginButton.setBackground(new Color(60, 179, 113)); // Medium sea green
        loginButton.setForeground(Color.WHITE);
        checkBalanceButton.setBackground(new Color(135, 206, 250)); // Light sky blue
        checkBalanceButton.setForeground(Color.WHITE);
        depositButton.setBackground(new Color(32, 178, 170)); // Light sea green
        depositButton.setForeground(Color.WHITE);
        withdrawButton.setBackground(new Color(255, 165, 0)); // Orange
        withdrawButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(255, 69, 0)); // Red-orange
        logoutButton.setForeground(Color.WHITE);

        // Add buttons to the panel
        buttonPanel.add(loginButton);
        buttonPanel.add(checkBalanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(logoutButton);

        // Disable buttons except for login initially
        checkBalanceButton.setEnabled(false);
        depositButton.setEnabled(false);
        withdrawButton.setEnabled(false);
        logoutButton.setEnabled(false);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        loginButton.addActionListener(new LoginAction());
        checkBalanceButton.addActionListener(new CheckBalanceAction());
        depositButton.addActionListener(new DepositAction());
        withdrawButton.addActionListener(new WithdrawAction());
        logoutButton.addActionListener(new LogoutAction());
    }

    // Action listener for the Login button
    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pin = pinField.getText().trim();
            if (pin.equals("1234")) {  // Example PIN
                statusLabel.setText("Login successful. Select an option.");
                statusLabel.setForeground(Color.GREEN);
                pinField.setEnabled(false);
                loginButton.setEnabled(false);
                checkBalanceButton.setEnabled(true);
                depositButton.setEnabled(true);
                withdrawButton.setEnabled(true);
                logoutButton.setEnabled(true);
            } else {
                statusLabel.setText("Invalid PIN. Please try again.");
                statusLabel.setForeground(Color.RED);
            }
        }
    }

    // Action listener for the Check Balance button
    private class CheckBalanceAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Current Balance: $" + String.format("%.2f", balance));
            statusLabel.setForeground(Color.BLUE);
        }
    }

    // Action listener for the Deposit button
    private class DepositAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
            if (amountStr != null) {
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0) {
                        balance += amount;
                        statusLabel.setText("Deposit successful! New Balance: $" + String.format("%.2f", balance));
                        statusLabel.setForeground(Color.BLUE);
                    } else {
                        statusLabel.setText("Please enter a positive amount.");
                        statusLabel.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Invalid amount. Please enter a valid number.");
                    statusLabel.setForeground(Color.RED);
                }
            }
        }
    }

    // Action listener for the Withdraw button
    private class WithdrawAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
            if (amountStr != null) {
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        statusLabel.setText("Withdrawal successful! New Balance: $" + String.format("%.2f", balance));
                        statusLabel.setForeground(Color.BLUE);
                    } else if (amount > balance) {
                        statusLabel.setText("Insufficient funds.");
                        statusLabel.setForeground(Color.RED);
                    } else {
                        statusLabel.setText("Please enter a positive amount.");
                        statusLabel.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Invalid amount. Please enter a valid number.");
                    statusLabel.setForeground(Color.RED);
                }
            }
        }
    }

    // Action listener for the Logout button
    private class LogoutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pinField.setEnabled(true);
            pinField.setText("");
            loginButton.setEnabled(true);
            checkBalanceButton.setEnabled(false);
            depositButton.setEnabled(false);
            withdrawButton.setEnabled(false);
            logoutButton.setEnabled(false);
            statusLabel.setText("Logged out. Please enter your PIN.");
            statusLabel.setForeground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMInterface atm = new ATMInterface();
            atm.setVisible(true);
        });
    }
}
