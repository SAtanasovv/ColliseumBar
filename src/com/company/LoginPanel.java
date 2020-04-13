package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginPanel extends JPanel implements ActionListener {
    public JLabel welcomeLabel;
    public JTextField pinField;
    public JButton okButton;            // Инициализираме променливи
    public JButton addWaitressButton;
    public MainFrame frame;
    public boolean isTrue = false;

    public LoginPanel(MainFrame frame) {
        this.frame = frame;
        welcomeLabel = new JLabel("Добре дошли!");
        add(welcomeLabel);
        pinField = new JTextField("Въведете пин: ");
        pinField.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent mouseEvent) {

            }                               // Създаваме панел за логин на сервитьор и за създаване на нов сервитьор

            public void mousePressed(MouseEvent mouseEvent) {

            }


            public void mouseReleased(MouseEvent mouseEvent) {

            }


            public void mouseEntered(MouseEvent mouseEvent) {

                if(!isTrue) {
                    pinField.setText("");                                                   // при минаване на мишката през текстовото поле се изтрива текста (само 1 път)
                    isTrue=true;
                }

            }
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        pinField.setColumns(15);
        add(pinField);
        okButton = new JButton(" OK ");
        okButton.addActionListener(this);
        add(okButton);
        addWaitressButton = new JButton("Нов сервитьор");
        addWaitressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {                       // при натискане на "Нов сервитьор" се отваря следващия панел
                frame.showAddWaiterPanel();
            }
        });
        add(addWaitressButton);
    }


    public void actionPerformed(ActionEvent e) {
        boolean isTrue = false;
        try {
            Double num = Double.parseDouble((pinField.getText()));
            if (!(pinField.getText().length() == 4)) {
                JOptionPane.showMessageDialog(null, "Пинкода трябва да съдържа 4 цифри", "Грешка", JOptionPane.ERROR_MESSAGE);
                isTrue = true;
            }                                                                                                                                                           //Проверяваме дали пин кода съдържа само цифри и дали са то1но 4

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Пинкода трябва да съдържа само цифри", "Грешка", JOptionPane.ERROR_MESSAGE);
            isTrue = true;
            return;
        }

        for (Waitress waitress : frame.waitresses) {
            if (waitress.pinCode.equals(pinField.getText())) {                      // при правилни попълнено поле и верен пин показваме панела с операции
                frame.currentWaitress = waitress;
                frame.showOperationPanel();
                isTrue = true;

            }
        }
        if (!isTrue)
            JOptionPane.showMessageDialog(null, "Грешен пин код", "Грешка", JOptionPane.ERROR_MESSAGE);

    }

}

