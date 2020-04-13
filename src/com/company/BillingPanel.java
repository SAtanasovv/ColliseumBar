package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;


public class BillingPanel extends JPanel implements ActionListener {
    public MainFrame frame;             // Инициализираме променливи
    public JLabel billLabel;
    public JButton backButton;


    public BillingPanel(MainFrame frame) {
        this.frame = frame;
        billLabel = new JLabel(frame.currentOrder.printBill());      // Конструктор на панела за сметка
        add(billLabel);
        backButton = new JButton("Назад");
        backButton.addActionListener(this);
        add(backButton);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        removeOrder();
        frame.showLoginFromBillingPanel();
    }

    public void removeOrder() {
        for (Iterator<Order> itr = frame.orders.iterator(); itr.hasNext();) {
            Order order = itr.next();
            if (order.equals(frame.currentOrder)) {
                itr.remove();

            }
        }
    }
}
