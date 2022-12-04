# Documentation

## `public class Main`

The main class contains one line, which creates a BankAccount object

## `class BankAccount extends JFrame`

The big class

## `public BankAccount()`

The only constructor, which has no parameters

## `private class ClickListener implements ActionListener`

The ClickListener class is nested inside the BankAccount class for security (encapsulation).

## `public void actionPerformed(ActionEvent event)`

The only method here detects various actions, in this case when buttons get clicked, and depending on which one performs further actions

* **Parameters:** `event` — the event to be processed

## `public void createComponents()`

essentially the other parts of the constructor