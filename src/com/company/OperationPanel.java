package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationPanel extends JPanel implements ActionListener {
    public JButton newOrderButton;
    public JButton addToOrderButton;                    // деклариране на променливи
    public JButton billButton;
    public MainFrame frame;

    public OperationPanel(MainFrame frame) {
        this.frame = frame;
        newOrderButton = new JButton("Нова поръчка");
        newOrderButton.addActionListener(this);
        add(newOrderButton);
        addToOrderButton = new JButton("Добави към поръчка");           // Изграждане на панела за операции
        addToOrderButton.addActionListener(this);
        add(addToOrderButton);
        billButton = new JButton("Сметка");
        billButton.addActionListener(this);
        add(billButton);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newOrderButton)
            frame.showTablePanel(1);
        else if (e.getSource()==addToOrderButton)
            frame.showTablePanel(2);        //Спрямо това кой бутон е натиснат се изпраща променлива с текуща операция
        else if (e.getSource()==billButton)                 // за да знаем кой панел да заредим след избор на маса
            frame.showTablePanel(3);
    }
}
