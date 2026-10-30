package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts () {
        return products;
    }

    public Optional<Product> getProductById (Long id) {
        return products.stream()
                .filter(p ->p.getId().equals(id) )
                .findFirst();
    }

    public Product addProduct (Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
