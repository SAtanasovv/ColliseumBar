package com.company;

import java.util.ArrayList;

public class Order {
    public int tableNumber;
    public Waitress waitress;                            // декларация на променливи
    public ArrayList<Product> products;

    public Order(Waitress waitress,int tableNumber){
        this.waitress=waitress;
        this.tableNumber=tableNumber;                                //конструктор на поръчката
        this.products=new ArrayList<Product>();
    }


    public String printBill(){
        double bill=0.0;
        for(Product product: products){                               // метод който изчислява дължимата сума
            bill+=product.price;
        }
        return "Вас Ви обслужва " + this.waitress + ". Вашата сметка е " + bill +" лева";

    }

}
