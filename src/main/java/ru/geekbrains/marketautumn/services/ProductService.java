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
}
