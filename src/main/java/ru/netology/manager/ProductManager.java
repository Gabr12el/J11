package ru.netology.manager;

import ru.netology.data.Book;
import ru.netology.data.Product;
import ru.netology.data.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;
    //менеджер, который умеет добавлять Product'ы в репозиторий и осуществлять поиск по ним

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        //метод searchBy(String text), который возвращает массив найденных товаров
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                //"добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String text) {
        return product.getName().contains(text);
    }
}
//Менеджер при переборе всех продуктов, хранящихся в репозитории, для каждого продукта
// вызывает определённый в классе менеджера метод matches, который проверяет,
// соответствует ли продукт поисковому запросу.
//При проверке на соответствие запросу товару мы проверяем вхождение запроса в текст названия товара.