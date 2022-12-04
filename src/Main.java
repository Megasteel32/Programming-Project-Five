/**
 @author Luca Maddaleni, 002702297
 @version 1.0
Program with a class BankAccount that extends JFrame to create a GUI. This
 GUI displays a bank account with two buttons, marked deposit and withdraw.
 By editing the top text field, users can enter any number (with or without the decimal)
 and raise or lower the balance.
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main class contains one line, which creates a BankAccount object
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new BankAccount();
    }
}

/**
 * The big class
 */
class BankAccount extends JFrame {
    /*
     * Here, we're setting up the buttons and text fields, as well as the
     * dimensions of the Frame, and the balance variable. All private for security.
     */
    private JButton deposit;
    private JButton withdraw;
    private JTextField ioField;
    private JTextField displayField;
    private JTextField warningField;
    private double balance = 0;
    final int FRAME_WIDTH = 650;
    final int FRAME_HEIGHT = 500;

    /**
     * The only constructor, which has no parameters
     */
    public BankAccount() {
        createComponents(); // calling the component creation method
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT); // setting dimensions
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting exit action
        this.setVisible(true); // setting the frame to be visible
    }

    /**
     * The ClickListener class is nested inside the BankAccount class
     * for security (encapsulation).
     */
    private class ClickListener implements ActionListener {
        /**
         * The only method here detects various actions,
         * in this case when buttons get clicked, and depending on which one
         * performs further actions
         * @param event the event to be processed
         */
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == deposit) { // if the button was deposit
                /*
                 * add balance and the input of the top field, set the
                 * text of the middle field to the new balance in the format
                 * of $X.XX, set the top field to a success message and clear
                 * any warnings
                 */
                balance += Double.parseDouble(ioField.getText());
                displayField.setText(String.format("$%.2f", balance));
                ioField.setText("Deposit Successful!");
                warningField.setText("");
            } else if (event.getSource() == withdraw) { // otherwise
                // checking if the entered value is less than or equal to the balance
                if (Double.parseDouble(ioField.getText()) <= balance) {
                    /*
                     * if so, subtract the entered value from the balance,
                     * update the balance, set the top field to a success message,
                     * and clear any warnings
                     */
                    balance -= Double.parseDouble(ioField.getText());
                    displayField.setText(String.format("$%.2f", balance));
                    ioField.setText("Withdraw Successful!");
                    warningField.setText("");
                } else {
                    // if the value was larger, display a warning
                    warningField.setText("Insufficient Funds!");
                }
            }
        }
    }

    /**
     * essentially the other parts of the constructor
     */
    public void createComponents() {
        // creating the button and textfield objects
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        ioField = new JTextField();
        displayField = new JTextField();
        // seting the center field to $0.00
        displayField.setText(String.format("$%.2f", balance));
        warningField = new JTextField();
        // creating the click listener object
        ClickListener listener = new ClickListener();
        // adding the buttons to the object
        deposit.addActionListener(listener);
        withdraw.addActionListener(listener);
        // creating a font object
        Font bigFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        // setting the text field justification
        ioField.setHorizontalAlignment(0);
        displayField.setHorizontalAlignment(0);
        warningField.setHorizontalAlignment(0);
        // setting the text field fonts
        deposit.setFont(bigFont);
        withdraw.setFont(bigFont);
        ioField.setFont(bigFont);
        displayField.setFont(bigFont);
        warningField.setFont(bigFont);
        // setting the placement of the objects
        add(deposit, BorderLayout.WEST);
        add(withdraw, BorderLayout.EAST);
        add(ioField, BorderLayout.NORTH);
        add(displayField, BorderLayout.CENTER);
        add(warningField, BorderLayout.SOUTH);
    }
}

/*
Behavior:
Enter any value into the top text field and click either deposit or withdraw.
If you click deposit, the value will be added to the current balance and a success
message will display. If you click withdraw, and you have sufficient funds,
the funds will be removed from your balance and a success message will display.
If you do not have sufficient funds, an error message will display. Enter only
numerical values without the $ sign. Any other values will cause the program to error.
Values above the size of a double will also cause the program to error.
 */