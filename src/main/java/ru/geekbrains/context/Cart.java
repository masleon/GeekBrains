package ru.geekbrains.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private HashMap products = new HashMap();

    public HashMap getProducts() {
        return products;
    }
}
