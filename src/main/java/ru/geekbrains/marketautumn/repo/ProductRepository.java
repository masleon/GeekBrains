package ru.geekbrains.marketautumn.repo;

import org.springframework.stereotype.Repository;
import ru.geekbrains.marketautumn.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
           new Product(1L,"Cheese",1.1f),
                new Product(2L,"Tomato",3.2f),
                new Product(3L,"Apple",0.4f)
        ));
    }
    public Product findById(Long id){
        return products.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getProducts() {
        return products;
    }
}
