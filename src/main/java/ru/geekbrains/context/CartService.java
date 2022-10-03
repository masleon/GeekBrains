package ru.geekbrains.context;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartService {
    public void addToCart(Product product, Cart cart){
        HashMap products = cart.getProducts();
        products.put(product.getId(),product);
    }
    public void removeFromCart(Product product,Cart cart){
        HashMap products = cart.getProducts();
        products.remove(product.getId());
    }
}
