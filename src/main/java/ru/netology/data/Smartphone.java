package ru.netology.data;

public class Smartphone extends Product {
    protected String manufacturer;

    //конструктор super унаследованный extends от Product с текстовыми полями название и производитель
    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}