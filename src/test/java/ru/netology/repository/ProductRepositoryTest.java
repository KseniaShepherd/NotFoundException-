package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product hpFirst = new Book(1, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", 100);
    private Product hpSecond = new Book(2, "Harry Potter and the Chamber of Secrets", "J. K. Rowling", 101);
    private Product hpThird = new Book(3, "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 100);
    private Product tShirtRed = new TShirt(4, "Red TShirt", "Red", "M", 100);

    @BeforeEach
    public void setRepository() {
        repository.save(hpFirst);
        repository.save(hpSecond);
        repository.save(hpThird);
        repository.save(tShirtRed);
    }

    @Test
    void shouldRemoveByIdExistingItemSuccessfully() {
        Product[] expected = new Product[]{hpFirst, hpSecond, tShirtRed};
        repository.removeById(3);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenDeleteNonexistentElement() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(100);
        });

    }
}