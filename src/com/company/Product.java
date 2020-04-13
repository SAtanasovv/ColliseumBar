package com.company;

public class Product {
    public String productName;
    public String quantity;               // декларация на променливи
    public double price;

    Product(String productName,String quantity,double price){
        this.productName=productName;
        this.quantity=quantity;                         //конструктор на поръчката
        this.price=price;


    }
    public String toString(){
        return this.productName;                    // метод който да ни връща име на продукта
    }

}
