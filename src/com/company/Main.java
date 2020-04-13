package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Waitress a = new Waitress("Monika", "0000");
        Waitress b = new Waitress("Miglena", "1111");
        Product minWater = new Product("Вода", "0.330", 2.0);
        Product cocaCola = new Product("CocaCola", "0.330", 2.5);
        Product smallWhiskey = new Product("Whiskey", "50", 3.0);       //Тестови обекти
        Product bigWhiskey = new Product("Whiskey", "100", 5.0);
        Product smallVodka = new Product("Vodka", "50", 3.0);
        Product bigVodka = new Product("Vodka", "100", 5.0);
        Order firstOrder = new Order(a, 10);
        Order secondOrder = new Order(a, 20);

        MainFrame frame = new MainFrame();

        frame.waitresses.add(a);
        frame.waitresses.add(b);
        frame.products.add(minWater);
        frame.products.add(cocaCola);
        frame.products.add(smallWhiskey);
        frame.products.add(smallVodka);
        frame.products.add(bigWhiskey);
        frame.products.add(bigVodka);
        frame.orders.add(firstOrder);
        frame.orders.add(secondOrder);
        System.out.println("GIT");


        frame.setVisible(true);


    }
}
