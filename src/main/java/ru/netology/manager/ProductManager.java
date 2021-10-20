package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search) || book.getName().contains(search)) {
                return true;
            }
        } else if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            if (tShirt.getColor().contains(search) || tShirt.getName().contains(search) || tShirt.getSize().contains((search))) {
                return true;
            }
        }
        return false;
    }
}