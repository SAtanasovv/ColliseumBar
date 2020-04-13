package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public ArrayList<Waitress> waitresses = new ArrayList<>();
    public ArrayList<Product> products = new ArrayList<>();    //Тук декларираме нужните ArrayList които ще изполваме в панелите, както и текущ сервитьор и поръчка
    public ArrayList<Order> orders = new ArrayList<>();
    public Waitress currentWaitress;
    public Order currentOrder;


    public LoginPanel loginPanel;
    public AddWaitressPanel addWaitressPanel;
    public OperationPanel operationPanel;               // Декалрираме панелите
    public TablesPanel tablesPanel;
    public MenuPanel menuPanel;
    public BillingPanel billingPanel;



    public MainFrame(){
        super("Colliseum");
        setLayout(new GridLayout(2,4,10,10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,550);
        showLoginPanel();

    }
    public void showLoginPanel(){
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(),getHeight());
        add(loginPanel);

    }
    public void showOperationPanel(){
        loginPanel.setVisible(false);
        remove(loginPanel);
        operationPanel = new OperationPanel(this);
        operationPanel.setSize(getWidth(),getHeight());
        add(operationPanel);

    }
    public void showTablePanel(int currentOperation){
        operationPanel.setVisible(false);
        remove(operationPanel);
        tablesPanel=new TablesPanel(this);
        tablesPanel.currentOperation=currentOperation;
        tablesPanel.setSize(getWidth(),getHeight());
        add(tablesPanel);

    }
    public void showMenuPanel(){                                                                // Съответните методи за отваряне и затваряне на панелите при преход между тях
        tablesPanel.setVisible(false);
        remove(tablesPanel);
        menuPanel=new MenuPanel(this);
        menuPanel.setSize(getWidth(),getHeight());
        add(menuPanel);
    }
    public void showBillingPanel(){
        tablesPanel.setVisible(false);
        remove(tablesPanel);
        billingPanel=new BillingPanel(this);
        billingPanel.setSize(getWidth(),getHeight());
        add(billingPanel);

    }
    public void showLoginFromMenuPanel(){
        menuPanel.setVisible(false);
        remove(menuPanel);
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(),getHeight());
        add(loginPanel);

    }
    public void showAddWaiterPanel(){
        loginPanel.setVisible(false);
        remove(loginPanel);
        addWaitressPanel = new AddWaitressPanel(this);
        addWaitressPanel.setSize(getWidth(),getHeight());
        add(addWaitressPanel);


    }
    public void showLoginFromWaiterpanel(){
        addWaitressPanel.setVisible(false);
        remove(addWaitressPanel);
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(),getHeight());
        add(loginPanel);
    }
    public void showLoginFromBillingPanel(){
        billingPanel.setVisible(false);
        remove(billingPanel);
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(),getHeight());
        add(loginPanel);
    }


}
