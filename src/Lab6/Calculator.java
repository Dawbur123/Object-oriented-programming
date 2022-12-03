package Lab6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Calculator implements ActionListener {


    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator - v.0.1");
        ImageIcon icon = new ImageIcon("C:\\Users\\mamgl\\IdeaProjects\\Programowanie\\src\\Lab6\\Calculator_32.png");
        frame.setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 15, 10));


        JTextField textField = new JTextField("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.BOLD, 26));
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        textField.setEditable(false);


        ActionListener myActionListener = new ActionListener() {

            int firstNumber = 0;
            int secondNumber = 0;
            String operator = "noOperator";
            boolean isAction = true;
            boolean isError = false;
            boolean isThisFirstNumber = true;
            boolean wasNumberLastClicked = false;
            boolean wasEqualLastClicked = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        if(!isError) {
                            if (isAction | textField.getText().equals("0")) {
                                textField.setText(e.getActionCommand());
                            } else {
                                textField.setText(textField.getText().concat(e.getActionCommand()));
                            }
                            if (wasEqualLastClicked) {
                                operator = "noOperator";
                                firstNumber = 0;
                                secondNumber = 0;
                            }

                            isAction = false;
                            wasNumberLastClicked = true;
                            wasEqualLastClicked = false;
                        }
                        break;

                    case "C":
                        textField.setForeground(Color.BLACK);
                        textField.setText("0");
                        operator = "noOperator";
                        isAction = true;
                        wasNumberLastClicked = false;
                        isThisFirstNumber = true;
                        firstNumber = 0;
                        secondNumber = 0;
                        wasEqualLastClicked = false;
                        isError = false;
                        break;

                    case "+":
                        if (!isError) {
                            if (wasEqualLastClicked) {
                                firstNumber = Integer.parseInt(textField.getText());
                            }
                            if (wasNumberLastClicked) {
                                switch (operator) {
                                    case "subOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber -= secondNumber;
                                        }
                                        break;
                                    case "mulOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber *= secondNumber;
                                        }
                                        break;
                                    case "divOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            if (!(secondNumber == 0)) {
                                                firstNumber /= secondNumber;
                                                isError = false;
                                            } else {
                                                isError = true;
                                            }
                                        }
                                        break;
                                    default:
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber += secondNumber;
                                        }
                                        break;
                                }
                                if (isError) {
                                    textField.setForeground(Color.RED);
                                    textField.setText("Division by zero!");
                                } else {
                                    textField.setText(Integer.toString(firstNumber));
                                }

                            }
                            System.out.println(firstNumber + " " + secondNumber);

                            operator = "addOperator";
                            isAction = true;
                            wasNumberLastClicked = false;
                            wasEqualLastClicked = false;
                        }
                        break;

                    case "-":
                        if (!isError) {
                            if (wasEqualLastClicked) {
                                firstNumber = Integer.parseInt(textField.getText());
                            }
                            if (wasNumberLastClicked) {
                                switch (operator) {
                                    case "addOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber += secondNumber;
                                        }
                                        break;
                                    case "mulOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber *= secondNumber;
                                        }
                                        break;
                                    case "divOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            if (!(secondNumber == 0)) {
                                                firstNumber /= secondNumber;
                                                isError = false;
                                            } else {
                                                isError = true;
                                            }
                                        }
                                        break;
                                    default:
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber -= secondNumber;
                                        }
                                        break;
                                }
                                if (isError) {
                                    textField.setForeground(Color.RED);
                                    textField.setText("Division by zero!");
                                } else {
                                    textField.setText(Integer.toString(firstNumber));
                                }
                            }
                            System.out.println(firstNumber + " " + secondNumber);
                            operator = "subOperator";
                            isAction = true;
                            wasNumberLastClicked = false;
                            wasEqualLastClicked = false;
                        }
                        break;

                    case "*":
                        if (!isError) {
                            if (wasEqualLastClicked) {
                                firstNumber = Integer.parseInt(textField.getText());
                            }
                            if (wasNumberLastClicked) {
                                switch (operator) {
                                    case "subOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber -= secondNumber;
                                        }
                                        break;
                                    case "addOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber += secondNumber;
                                        }
                                        break;
                                    case "divOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            if (!(secondNumber == 0)) {
                                                firstNumber /= secondNumber;
                                                isError = false;
                                            } else {
                                                isError = true;
                                            }
                                        }
                                        break;
                                    default:
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber *= secondNumber;
                                        }
                                        break;
                                }
                                if (isError) {
                                    textField.setForeground(Color.RED);
                                    textField.setText("Division by zero!");
                                } else {
                                    textField.setText(Integer.toString(firstNumber));
                                }

                            }
                            System.out.println(firstNumber + " " + secondNumber);

                            operator = "mulOperator";
                            isAction = true;
                            wasNumberLastClicked = false;
                            wasEqualLastClicked = false;
                        }
                        break;

                    case "/":
                        if (!isError) {
                            if (wasEqualLastClicked) {
                                firstNumber = Integer.parseInt(textField.getText());
                            }
                            if (wasNumberLastClicked) {
                                switch (operator) {
                                    case "subOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber -= secondNumber;
                                        }
                                        break;
                                    case "mulOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber *= secondNumber;
                                        }
                                        break;
                                    case "addOperator":
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            firstNumber += secondNumber;
                                        }
                                        break;
                                    default:
                                        if (isThisFirstNumber) {
                                            firstNumber = Integer.parseInt(textField.getText());
                                            isThisFirstNumber = false;
                                        } else {
                                            secondNumber = Integer.parseInt(textField.getText());
                                            if (!(secondNumber == 0)) {
                                                firstNumber /= secondNumber;
                                                isError = false;
                                            } else {
                                                isError = true;
                                            }
                                        }
                                        break;
                                }
                                if (isError) {
                                    textField.setForeground(Color.RED);
                                    textField.setText("Division by zero!");
                                } else {
                                    textField.setText(Integer.toString(firstNumber));
                                }

                            }
                            System.out.println(firstNumber + " " + secondNumber);

                            operator = "divOperator";
                            isAction = true;
                            wasNumberLastClicked = false;
                            wasEqualLastClicked = false;
                        }
                        break;

                    case "=":
                        if (!isError) {
                            wasNumberLastClicked = false;
                            isAction = true;
                            if (!wasEqualLastClicked) {
                                secondNumber = Integer.parseInt(textField.getText());
                            }
                            switch (operator) {
                                case "addOperator":
                                    firstNumber += secondNumber;
                                    textField.setText(Integer.toString(firstNumber));
                                    break;

                                case "subOperator":
                                    firstNumber -= secondNumber;
                                    textField.setText(Integer.toString(firstNumber));
                                    break;

                                case "mulOperator":
                                    firstNumber *= secondNumber;
                                    textField.setText(Integer.toString(firstNumber));
                                    break;

                                case "divOperator":
                                    if (!(secondNumber == 0)) {
                                        firstNumber /= secondNumber;
                                        textField.setText(Integer.toString(firstNumber));
                                        isError = false;
                                    } else {
                                        textField.setForeground(Color.RED);
                                        textField.setText("Division by zero!");
                                        isError = true;
                                    }
                                    break;

                                case "noOperator":
                                    firstNumber = secondNumber;
                                    break;
                            }
                            wasEqualLastClicked = true;
                            System.out.println(firstNumber + " " + secondNumber);
                        }
                        break;

                }
            }
        };

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        JButton additionButton = new JButton("+");
        JButton subtractionButton = new JButton("-");
        JButton multiplicationButton = new JButton("*");
        JButton divisionButton = new JButton("/");
        JButton equalButton = new JButton("=");
        JButton clearButton = new JButton("C");

        JButton[] buttons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, additionButton, subtractionButton, multiplicationButton, divisionButton, equalButton, clearButton};
        for (
                JButton button : buttons) {
            button.setBackground(Color.WHITE);
            button.setFocusable(false);
            button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setBorder(BorderFactory.createLineBorder(Color.decode("#005266")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBackground(Color.WHITE);
                    button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                }
            });
            button.addActionListener(myActionListener);

        }


        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(additionButton);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(subtractionButton);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        buttonsPanel.add(multiplicationButton);
        buttonsPanel.add(button0);
        buttonsPanel.add(equalButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(divisionButton);
        buttonsPanel.setBorder(new

                EmptyBorder(10, 10, 10, 10));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new

                BorderLayout());
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.setBorder(new

                EmptyBorder(10, 10, 10, 10));
        frame.add(mainPanel);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}