package ru.netology.data;

public class Book extends Product {
    protected String author;

    // конструктор super унаследованный extends от Product
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}