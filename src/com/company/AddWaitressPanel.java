package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddWaitressPanel extends JPanel implements ActionListener , MouseListener {
    public MainFrame frame;
    public JTextField nameField;
    public JTextField pinFiled;                      // Инициализираме променливи
    public JButton createButton;
    public boolean isTrue1 =false;
    public boolean isTrue2 =false;


    public AddWaitressPanel(MainFrame frame) {
        this.frame = frame;
        nameField = new JTextField("Въведи име:");
        nameField.addMouseListener(this);
        add(nameField);
        pinFiled = new JTextField("Въведи пин:");                           // Създаваме панел за добавяне на нов сервитьор
        pinFiled.addMouseListener(this);
        add(pinFiled);
        createButton = new JButton("Нов сервитьор");
        createButton.addActionListener(this);
        add(createButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        checkWaiter();   // Извикваме метода при натискане на бутона

    }

    public void checkWaiter() {
        boolean isTrue = false;
        if (nameField.getText().length() < 4 || pinFiled.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Moля попълнете всички полета с поне 4 символа!", "Грешка", JOptionPane.ERROR_MESSAGE);  // Проверяваме 2те полета дали съдържат поне 4 символа,ако да продължаваме с др проверки

        } else {
            for (Waitress waitress : frame.waitresses) {
                if (waitress.waitressName.equals(nameField.getText())) {
                    JOptionPane.showMessageDialog(null, "Съществува такова име", "Грешка", JOptionPane.ERROR_MESSAGE);
                    isTrue = true;
                    break;                                                                                                                                            // Проверяваме ArrayLista дали вече не съществува такова име и пин код
                }
                if (waitress.pinCode.equals(pinFiled.getText())) {
                    JOptionPane.showMessageDialog(null, "Съществува такъв пин", "Грешка", JOptionPane.ERROR_MESSAGE);
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                Waitress waitress = new Waitress(nameField.getText(), pinFiled.getText());
                frame.waitresses.add(waitress);                         //Ако са свободни името и пинкода създаваме нашия нов сервитьор
                frame.showLoginFromWaiterpanel();
            }
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {
        if (mouseEvent.getSource()==nameField){
            if(!isTrue1) {
                nameField.setText("");
                isTrue1=true;
            }
        }                                                                 // при минаване на мишката през текстовото поле се изтрива текста (само 1 път)
        if (mouseEvent.getSource()==pinFiled){
            if(!isTrue2) {
                pinFiled.setText("");
                isTrue2=true;
            }
        }


    }

    public void mouseExited(MouseEvent mouseEvent) {

    }
}
