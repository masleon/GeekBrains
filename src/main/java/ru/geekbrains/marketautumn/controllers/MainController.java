package ru.geekbrains.marketautumn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.services.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService service;

    @GetMapping("/hello")
    @ResponseBody
    public String  hello(){
        return "<h1>Hello autumn market</h1>";
    }

    //http://localhost:8189/app/calculate?a=5&b=2
    @GetMapping("/calculate")
    @ResponseBody
    public int calculate(@RequestParam int a,@RequestParam(required = false) int b){
        return a+b;
    }

    //http://localhost:8189/app/products/12/info
    @GetMapping("/products/{id}/info")
    @ResponseBody
    public String info(@PathVariable String id){
        return "product with id " + id;
    }

    @GetMapping("/product")
    public String allProducts(Model model, @RequestParam Long id){
        model.addAttribute("product", service.getProduct(id));
        return "index.html";
    }

    @GetMapping("/allproducts")
    public String getAllProducts(Model model){
        model.addAttribute("allproducts",service.getAllProducts());
        return "allproducts.html";
    }

    @GetMapping("/allAngularProducts")
    @ResponseBody
        public List<Product> getAllAngularProducts(){
            return service.getAllProducts();
        }


    @GetMapping("/product/add")
    @ResponseBody
    public void addProduct(Long id, String title, Float cost){
        service.addProduct(id, title, cost);
    }

    @GetMapping("/addproduct")
    public String form(){
        return "addproduct.html";
    }

    @GetMapping("/prod")
    @ResponseBody
        public Product prod(){
            return service.getProduct(1L);
    }

//    {"id":4,"title":"Straw","cost":112.1}
    @PostMapping("/product/add")
    @ResponseBody
    public void addProductPost(@RequestBody Product product){
        service.addProduct(product);
    }
    @GetMapping("/deleteproduct")
    @ResponseBody
    public void deleteProduct(@RequestParam Long productId){
        service.deleteProduct(productId);
    }

}
