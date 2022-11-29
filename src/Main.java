import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new BankAccount();
    }
}

class BankAccount extends JFrame {
    private JButton deposit;
    private JButton withdraw;
    private JTextField ioField;
    private JTextField displayField;
    private JTextField warningField;
    private double balance = 0;
    final int FRAME_WIDTH = 650;
    final int FRAME_HEIGHT = 500;

    public BankAccount() {
        createComponents();
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == deposit) {
                balance += Double.parseDouble(ioField.getText());
                displayField.setText(String.valueOf(balance));
                ioField.setText("Deposit Successful!");
            } else if (event.getSource() == withdraw) {
                if (Integer.parseInt(ioField.getText()) <= balance) {
                    balance -= Integer.parseInt(ioField.getText());
                    displayField.setText(String.valueOf(balance));
                    ioField.setText("Withdraw Successful!");
                } else {
                    warningField.setText("Insufficient Funds!");
                }
            }
        }
    }

    public void createComponents() {
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        ioField = new JTextField();
        displayField = new JTextField();
        warningField = new JTextField();
        ClickListener listener = new ClickListener();
        deposit.addActionListener(listener);
        withdraw.addActionListener(listener);
        Font bigFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        ioField.setHorizontalAlignment(0);
        displayField.setHorizontalAlignment(0);
        warningField.setHorizontalAlignment(0);
        deposit.setFont(bigFont);
        withdraw.setFont(bigFont);
        ioField.setFont(bigFont);
        displayField.setFont(bigFont);
        warningField.setFont(bigFont);
        add(deposit, BorderLayout.WEST);
        add(withdraw, BorderLayout.EAST);
        add(ioField, BorderLayout.NORTH);
        add(displayField, BorderLayout.CENTER);
        add(warningField, BorderLayout.SOUTH);
    }
}