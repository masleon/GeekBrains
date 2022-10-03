package ru.geekbrains.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value = "trueRepo")
public class InMemoryRepository implements Repository{
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
           new Product(1L,"Bread",50),
                new Product(2L,"Milk",80),
                new Product(3L,"Orange",100)
        ));
    }

    @Override
    public Product findById(Long id){
        return products.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
