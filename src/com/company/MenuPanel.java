package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MenuPanel extends JPanel implements ActionListener {
    public MainFrame frame;
    public JButton universalButton;
    public JButton applyButton;                                                     // декларация на променливи
    public JTextArea orderArea;
    public ArrayList<JButton> buttonList = new ArrayList<>();
    public Product product;
    public String popString = null;
    public int count = 0;


    public MenuPanel(MainFrame frame) {
        this.frame = frame;
        orderArea = new JTextArea(8, 15);
        add(orderArea);
        for (Product product : frame.products) {
            universalButton = new JButton(product.productName + " " + product.quantity + " " + product.price);      // От ArrayListа с продукти създаваме бутони за всеки продукт в менюто
            universalButton.addActionListener(this);
            buttonList.add(universalButton);
            add(universalButton);
        }

        applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // при натискане на бутона всички избрани продукти се добавят към поръчката на дадена маса
                int selectedOption = JOptionPane.showConfirmDialog(null, "Искате ли да добавите " + popString + " към поръчката", "Потвърди", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (selectedOption == JOptionPane.YES_OPTION)
                    frame.showLoginFromMenuPanel();
            }
        });
        add(applyButton);


    }

    public void actionPerformed(ActionEvent e) {

        String buttonString = ((JButton) (e.getSource())).getText();
        orderArea.append(buttonString + " лв\n");
        String[] str = buttonString.split(" ");
        if (count < 1) {
            popString = str[0] + " " + str[1];
            count++;
        } else {
            popString = popString + ", " + str[0] + " " + str[1];
            count+=1;
        }
        double price = Double.parseDouble(str[2]);                         // При кликане върху бутон за продукт взимаме неговото име(стринг) и го разделяме на 3 части
        product = new Product(str[0], str[1], price);                      // Създаваме обекта и го добавяме към поръчкатаpopString = popString + ", " + str[0] + " " + str[1];
        for (Order order : frame.orders) {
            if (order.equals(frame.currentOrder)) {
                order.products.add(product);
            }


        }


    }
}
