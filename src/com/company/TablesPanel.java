package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class TablesPanel extends JPanel implements ActionListener {
    public MainFrame frame;
    public JButton tableButton;                                                   // декларация на променливи
    public ArrayList<JButton> buttonList = new ArrayList<>();
    public String numbers[] = {"10","15","20","25","30","35","40","45","50"};
    public int tableNumber;



    public int currentOperation;

    public TablesPanel(MainFrame frame) {
        this.frame = frame;
        for(String num:numbers) {
            tableButton = new JButton(num);                                     // Създаваме бутони с номера на маси от масива
            tableButton.addActionListener(this);
            buttonList.add(tableButton);
            add(tableButton);
        }
    }

    public void actionPerformed(ActionEvent e) {

        tableNumber = Integer.parseInt(((JButton) e.getSource()).getText());

        boolean isTrue = false;
        for (Order order : frame.orders) {
            if (order.tableNumber == tableNumber) {                             // Взимаме номера на масата и проверяме дали има поръцка и викаме съответния метод
                frame.currentOrder = order;
                isTrue = true;
                orderFound();
                break;
            }
        }
        if (!isTrue) {
            //Няма поръчка
            orderNotFound();

        }

    }

    public void orderFound() {
        //New order 1 -> Изкарвам попъп и му казвам, че вече има поръчка
        //Existing 2 -> Минавам на следващият екран
        //Get bill 3 -> Минавам на следващият екран
        if (currentOperation == 1) {
            JOptionPane.showMessageDialog(null, "На тази маса има поръчка! Не може да се създаде нова", "Грешка", JOptionPane.ERROR_MESSAGE);
        } else if (currentOperation == 2) {
            frame.showMenuPanel();
        } else if (currentOperation == 3)
            frame.showBillingPanel();


    }

    public void orderNotFound() {
        //New order 1 -> Създам една нова поръчка и да я добавя в масива с поръчки да мина на следващият екран
        //Existing 2 -> Трябва да му покажа попъп, че няма поръчка, която да продължи на тази маса и съответно да го попитам дали иска да направи нова поръчка
        //Get bill 3 -> Попъп, че няма поръчка на тази маса и не може да се вади сметката
        if (currentOperation == 1) {
            createOrder();

        } else if (currentOperation == 2) {
            int selectedOption = JOptionPane.showConfirmDialog(null, "На тази маса няма поръчка! Искате ли да се създаде нова?", "Грешка", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (selectedOption == JOptionPane.YES_OPTION) {
                createOrder();
            }

        } else if (currentOperation == 3)
            JOptionPane.showMessageDialog(null, "На тази маса няма поръчка! Не може да се изкара сметка", "Грешка", JOptionPane.ERROR_MESSAGE);


    }


    public void createOrder() {
        Order order = new Order(frame.currentWaitress, tableNumber);
        frame.currentOrder = order;
        frame.orders.add(order);                                        //метод за създаване на нова поръчка
        frame.showMenuPanel();
    }


}
