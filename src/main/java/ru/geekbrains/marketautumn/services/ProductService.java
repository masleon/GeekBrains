package ru.geekbrains.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.repo.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product getProduct(Long id){
        return repository.findById(id);
    }

    public List<Product> getAllProducts(){
        return repository.getProducts();
    }
    public void addProduct(Long id, String title, Float cost){
        repository.addProduct(id,title,cost);
    }
    public void addProduct(Product product){
        repository.addProduct(product);
    }
    public void deleteProduct(Long id){
        Product product = repository.findById(id);
        repository.deleteProduct(product);
    }
}
