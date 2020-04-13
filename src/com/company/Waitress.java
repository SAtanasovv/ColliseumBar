package com.company;

public class Waitress {
    public String waitressName;                   // декларация на променливи
    public String pinCode;

    public Waitress(String waitressName,String pinCode){
        this.waitressName=waitressName;                     // Конструктор за сервитьори
        this.pinCode=pinCode;


    }

    public String toString(){
        return this.waitressName;
    }       // метод който да ни връща име на продукта




}
